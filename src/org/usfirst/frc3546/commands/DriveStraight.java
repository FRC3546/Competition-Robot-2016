package org.usfirst.frc3546.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3546.Robot;

/**
 * Created by Owner on 2/27/2016.
 */
public class DriveStraight extends Command {
    public static final double DRIVING_SPEED = .4;
    public static final double P_VAL = .01;

    // Called just before this Command runs the first time
    protected void initialize() {
        //Remove before flight
        this.setTimeout(5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double speed;
        if (timeSinceInitialized() < .3){
            speed = DRIVING_SPEED * .3;
        } else if (timeSinceInitialized() < .6) {
            speed = DRIVING_SPEED * .6;
        } else {
            speed = DRIVING_SPEED;
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

        Robot.drivetrain.takeInputs(left_speed, right_speed);
    }


    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
