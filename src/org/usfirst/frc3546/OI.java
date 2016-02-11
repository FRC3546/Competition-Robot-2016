// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3546;

import org.usfirst.frc3546.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc3546.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton cimbingWinchLetOutButton;
    public JoystickButton climbingWinchPullInButton;
    public JoystickButton climbingArmExtendButton;
    public JoystickButton climbingArmRotationOutButton;
    public JoystickButton climbingArmRotationInButton;
    public JoystickButton sweeperBarRotationOutButton;
    public JoystickButton sweeperBarRotationInButton;
    public JoystickButton sweeperArmPositionRaiseButton;
    public JoystickButton sweeperArmPositionLowerButton;
    public Joystick leftJoystick;
    public Joystick rightJoystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        rightJoystick = new Joystick(1);
        
        leftJoystick = new Joystick(0);
        
        sweeperArmPositionLowerButton = new JoystickButton(leftJoystick, 1);
        sweeperArmPositionLowerButton.whileHeld(new SweeperArmPositionLower());
        sweeperArmPositionRaiseButton = new JoystickButton(leftJoystick, 1);
        sweeperArmPositionRaiseButton.whileHeld(new SweeperArmPositionRaise());
        sweeperBarRotationInButton = new JoystickButton(leftJoystick, 1);
        sweeperBarRotationInButton.whileHeld(new SweeperBarRotationIn());
        sweeperBarRotationOutButton = new JoystickButton(leftJoystick, 1);
        sweeperBarRotationOutButton.whileHeld(new SweeperBarRotationOut());
        climbingArmRotationInButton = new JoystickButton(leftJoystick, 1);
        climbingArmRotationInButton.whileHeld(new ClimbingArmRotationIn());
        climbingArmRotationOutButton = new JoystickButton(leftJoystick, 1);
        climbingArmRotationOutButton.whileHeld(new ClimbingArmRotationOut());
        climbingArmExtendButton = new JoystickButton(leftJoystick, 1);
        climbingArmExtendButton.whileHeld(new ClimbingArmExtend());
        climbingWinchPullInButton = new JoystickButton(leftJoystick, 1);
        climbingWinchPullInButton.whileHeld(new ClimbingWinchPullIn());
        cimbingWinchLetOutButton = new JoystickButton(leftJoystick, 1);
        cimbingWinchLetOutButton.whileHeld(new CimbingWinchLetOut());


        // SmartDashboard Buttons
        SmartDashboard.putData("CimbingWinchLetOut", new CimbingWinchLetOut());
        SmartDashboard.putData("ClimbingWinchPullIn", new ClimbingWinchPullIn());
        SmartDashboard.putData("ClimbingArmExtend", new ClimbingArmExtend());
        SmartDashboard.putData("ClimbingArmRotationOut", new ClimbingArmRotationOut());
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getLeftJoystick() {
        return leftJoystick;
    }

    public Joystick getRightJoystick() {
        return rightJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

