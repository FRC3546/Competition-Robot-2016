package org.usfirst.frc3546.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3546.Robot;

/**
 * Created by Owner on 2/27/2016.
 */
public class DriveStraight extends Command {
    public static final double DEFUALT_DRIVING_SPEED = .4;
    public static final double P_VAL = .01;

    private boolean stop_when_not_level = false;
    private boolean drive_backwards = false;

    private double driving_speed;

    /**
     * Construct the command
     * @param timeout The time to drive for. Set to -1 to drive until Robot.gyro.isLevel() is false
     * @param drive_backwards True if the robot should drive backwards
     */
    public DriveStraight(double timeout, boolean drive_backwards){
        if (timeout == -1){
            stop_when_not_level = true;
        } else {
            this.setTimeout(timeout);
        }

        this.drive_backwards = drive_backwards;

        driving_speed = DEFUALT_DRIVING_SPEED;
    }

    public DriveStraight(double timeout, double speed, boolean drive_backwards){
        this(timeout, drive_backwards);
        driving_speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double speed;
        if (timeSinceInitialized() < .3){
            speed = driving_speed * .3;
        } else if (timeSinceInitialized() < .6) {
            speed = driving_speed * .6;
        } else {
            speed = driving_speed;
        }

        double left_speed = speed;
        double right_speed = speed;

        double angle_setpoint = 0;
        double robot_angle = Robot.gyro.getRobotAngle();

        if (Math.abs(robot_angle - angle_setpoint) > 3) {
            if (robot_angle < 0){
                right_speed += Math.abs(robot_angle) * P_VAL;
            } else {
                left_speed += Math.abs(robot_angle) * P_VAL;
            }
        }

        if (drive_backwards) {
            Robot.drivetrain.takeInputs(left_speed, right_speed);
        } else {
            Robot.drivetrain.takeInputs(right_speed, left_speed);
        }

    }


    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (stop_when_not_level) {
            return !Robot.gyro.isLevel();
        }

        return false;
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
