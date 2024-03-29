// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3546.subsystems;

import edu.wpi.first.wpilibj.*;
import org.usfirst.frc3546.RobotMap;
import org.usfirst.frc3546.commands.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Drivetrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final Encoder rightDrivetrainEncoder = RobotMap.drivetrainRightDrivetrainEncoder;
    private final Encoder leftDrivetrainEncoder = RobotMap.drivetrainLeftDrivetrainEncoder;
    private final SpeedController backRightMotor = RobotMap.drivetrainBackRightMotor;
    private final SpeedController backLeftMotor = RobotMap.drivetrainBackLeftMotor;
    private final SpeedController frontRightMotor = RobotMap.drivetrainFrontRightMotor;
    private final SpeedController frontLeftMotor = RobotMap.drivetrainFrontLeftMotor;
    private final RobotDrive drivetrainMotors = RobotMap.drivetrainDrivetrainMotors;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        //setDefaultCommand(new Drive());
    }


    public void takeInputs(Joystick stick1, Joystick stick2){drivetrainMotors.tankDrive(stick1, stick2);
    }

    public void takeInputs(double left, double right){drivetrainMotors.tankDrive(left, right);
    }

    public void takeRotateInput(double gas, double rotate_rate){
        drivetrainMotors.mecanumDrive_Cartesian(0, rotate_rate, -gas, 0);
    }

    public void stop() {drivetrainMotors.drive(0, 0);
    }
}

