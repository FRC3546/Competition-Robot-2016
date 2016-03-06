package org.usfirst.frc3546.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc3546.Robot;
import org.usfirst.frc3546.StopWhen;

import java.util.SortedMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by Andrew on 3/4/16.
 */
public class DriveAtAngle extends Command implements PIDOutput, PIDSource {

    public static final double P = 0.08;
    public static final double I = 0;
    public static final double D = 0;

    public static final double MAX_TURN_OUTPUT = .5;
    public static final double ANGLE_TOLERANCE = 5;
    public static final double EMERGENCY_TIMEOUT = 6;

    public static final double JERK_THRESHOLD = 1.3;

    private PIDController turnController;
    private double rotateRate;
    private double forward_output;
    private StopWhen stopWhen;
    private double timeout = 0;

    public DriveAtAngle(double angle, double forward_output, StopWhen stopWhen){
        this(angle, forward_output);
        if (stopWhen != StopWhen.YawAngle && stopWhen != StopWhen.Collision && stopWhen != StopWhen.NotLevel)
            throw new IllegalArgumentException();

        this.stopWhen = stopWhen;
    }


    public DriveAtAngle(double angle, double forward_output, double timeout){
        this(angle, forward_output);
        this.timeout = timeout;
        this.stopWhen = StopWhen.Timeout;
    }


    private DriveAtAngle(double angle, double forward_output){
        turnController = new PIDController(P, I, D, this, this);
        turnController.setInputRange(-180, 180);
        turnController.setContinuous(true);
        turnController.setOutputRange(-MAX_TURN_OUTPUT, MAX_TURN_OUTPUT);
        turnController.setAbsoluteTolerance(ANGLE_TOLERANCE);
        turnController.setToleranceBuffer(1);
        turnController.disable();
        turnController.setSetpoint(angle);

        this.forward_output = forward_output;

        LiveWindow.addActuator("Autonomous", "RotationController", turnController);
    }

    public DriveAtAngle(double angle){
        this(angle, 0, StopWhen.YawAngle);
    }

    @Override
    protected void initialize() {
        turnController.enable();
    }

    @Override
    protected void execute() {
        Robot.drivetrain.takeRotateInput(forward_output, rotateRate);
    }

    @Override
     public void pidWrite(double output) {
        rotateRate = output;
    }

    @Override
    protected boolean isFinished() {
        if (stopWhen != StopWhen.Timeout && timeSinceInitialized() > EMERGENCY_TIMEOUT){
            System.out.println("DriveAtAngle timed out!");
            return true;
        }

        if (stopWhen == StopWhen.YawAngle){
            return Math.abs(Robot.gyro.getGyroSensorAngle() - turnController.getSetpoint()) < ANGLE_TOLERANCE;
        } else if (stopWhen == StopWhen.Collision) {
            return checkJerk();
        } else if (stopWhen == StopWhen.NotLevel) {
            return !Robot.gyro.isLevel();
        } else { //Timeout
            return timeSinceInitialized() > timeout;
        }
    }

    private boolean checkJerk(){
        double jerk = Robot.gyro.getJerk();
        if (jerk > JERK_THRESHOLD && timeSinceInitialized() > .6){
            System.out.println("Robot collided with something");
            return true;
        }

        return false;
    }

    @Override
    protected void end() {
        turnController.disable();
        Robot.drivetrain.stop();
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    public void setPIDSourceType(PIDSourceType pidSource) {}

    @Override
    public PIDSourceType getPIDSourceType() {
        return PIDSourceType.kDisplacement;
    }

    @Override
    public double pidGet() {
        return Robot.gyro.getGyroSensorAngle();
    }
}
