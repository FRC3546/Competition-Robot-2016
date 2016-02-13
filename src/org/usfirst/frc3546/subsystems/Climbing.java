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

import org.usfirst.frc3546.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Climbing extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController climbingArmExtensionMotor = RobotMap.climbingClimbingArmExtensionMotor;
    private final SpeedController climbingWinchMotor = RobotMap.climbingClimbingWinchMotor;
    private final DoubleSolenoid armRotatationSolenoid = RobotMap.climbingArmRotatationSolenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static final double WINCH_SPEED = .3;
    public static final double SLOW_WINCH_SPEED = .2;
    public static final double ARM_SPEED = .3;
    public static final boolean ARM_UP = false;
    public static final boolean ARM_DOWN = true;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setArmPositionValve(ARM_DOWN);
    }

    public void letWinchOut(){
        climbingWinchMotor.set(WINCH_SPEED);
    }

    public void letWinchOutSlowly(){
        climbingWinchMotor.set(SLOW_WINCH_SPEED);
    }

    public void pullWinchDown(){
        climbingWinchMotor.set(-WINCH_SPEED);
    }

    public void stopWinch() {
        climbingWinchMotor.set(0);
    }

    public void extendArm(){
        climbingArmExtensionMotor.set(ARM_SPEED);
    }

    public void stopArm(){
        climbingArmExtensionMotor.set(0);
    }

    public void setArmPositionValve(boolean valvePosition){
        if (valvePosition == ARM_UP){
            armRotatationSolenoid.set(DoubleSolenoid.Value.kForward);
        } else {
            armRotatationSolenoid.set(DoubleSolenoid.Value.kReverse);
        }

    }

    public boolean getArmPositionValve() {
        return armRotatationSolenoid.get() == DoubleSolenoid.Value.kForward;
    }

    public void invertFlagValve() {
        if (getArmPositionValve() == ARM_UP){
            setArmPositionValve(ARM_DOWN);

        } else {
            setArmPositionValve(ARM_UP);
        }
    }
}

