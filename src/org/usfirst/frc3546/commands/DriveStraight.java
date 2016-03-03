package org.usfirst.frc3546.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3546.Robot;
import org.usfirst.frc3546.StopWhen;

/**
 * Created by Owner on 2/27/2016.
 */
public class DriveStraight extends Command {
    public static final double DEFUALT_DRIVING_SPEED = .7;
    public static final double EMERGENCY_TIMEOUT = 6;
    public static final int TIMES_AT_TARGET_NEEDED = 10;
    public static final double P_VAL = .01;

    private int times_at_target = 0;

    private double timeout;

    private StopWhen stopWhen = StopWhen.Timeout;
    private boolean drive_backwards = false;
    private boolean ramp_up = true;

    private double driving_speed;

    /**
     * Construct the command
     * @param timeout The time to drive for. Set to -1 to drive until Robot.gyro.isLevel() is false
     * @param drive_backwards True if the robot should drive backwards
     */
    public DriveStraight(double timeout, boolean drive_backwards){
        if (timeout < 0) throw new IllegalArgumentException();
        this.timeout = timeout;

        this.drive_backwards = drive_backwards;

        driving_speed = -DEFUALT_DRIVING_SPEED;

        if (drive_backwards) driving_speed = -driving_speed;
    }

    public DriveStraight(double timeout, boolean drive_backwards, boolean ramp_up){
        this(timeout, drive_backwards);
        this.ramp_up = ramp_up;
    }

    public DriveStraight(double timeout, double speed, boolean drive_backwards){
        this(timeout, drive_backwards);
        driving_speed = speed;
    }

    public DriveStraight(boolean drive_backwards, boolean ramp_up, StopWhen stopWhen){
        this(EMERGENCY_TIMEOUT, drive_backwards);
        if (stopWhen == StopWhen.Timeout) throw new IllegalArgumentException();
        this.stopWhen = stopWhen;
        this.ramp_up = ramp_up;
    }

    public DriveStraight(double speed, boolean drive_backwards, boolean ramp_up, StopWhen stopWhen){
        this(EMERGENCY_TIMEOUT, drive_backwards);
        if (stopWhen == StopWhen.Timeout) throw new IllegalArgumentException();
        this.ramp_up = ramp_up;
        this.stopWhen = stopWhen;
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double speed;
        if (timeSinceInitialized() < .3 && ramp_up){
            speed = driving_speed * .3;
        } else if (timeSinceInitialized() < .6 && ramp_up) {
            speed = driving_speed * .6;
        } else {
            speed = driving_speed;
        }

        double left_speed = speed;
        double right_speed = speed;

//        double angle_setpoint = 0;
//        double robot_angle = Robot.gyro.getRobotAngle();
//
//        if (Math.abs(robot_angle - angle_setpoint) >
//                3) {
//            if (robot_angle < 0){
//                right_speed -= Math.abs(robot_angle) * P_VAL;
//            } else {
//                left_speed -= Math.abs(robot_angle) * P_VAL;
//            }
//        }

        Robot.drivetrain.takeInputs(left_speed, right_speed);
//        System.out.println(left_speed + ", " + right_speed + "; ");
    }


    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (stopWhen == StopWhen.NotLevel) {
            System.out.println("Not Level: " + !Robot.gyro.isLevel());
            if (!Robot.gyro.isLevel()) times_at_target++; else times_at_target = 0;
            return times_at_target > TIMES_AT_TARGET_NEEDED;
        } else if (stopWhen == StopWhen.Level) {
            System.out.println("Level: " + Robot.gyro.isLevel());
            if (Robot.gyro.isLevel()) times_at_target++; else times_at_target = 0;
            return times_at_target > TIMES_AT_TARGET_NEEDED;
        } else {
            return timeSinceInitialized() > timeout;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
