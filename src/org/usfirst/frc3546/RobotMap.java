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

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController climbingClimbingArmExtensionMotor;
    public static SpeedController climbingClimbingWinchMotor;
    public static DoubleSolenoid climbingArmRotatationSolenoid;
    public static AnalogPotentiometer ballIntakeSweeperArmPositionPotentiometer;
    public static SpeedController ballIntakeSweeperArmPositionMotor;
    public static Relay ballIntakeSweeperBarRotationMotor;
    public static Encoder drivetrainRightDrivetrainEncoder;
    public static Encoder drivetrainLeftDrivetrainEncoder;
    public static SpeedController drivetrainBackRightMotor;
    public static SpeedController drivetrainBackLeftMotor;
    public static SpeedController drivetrainFrontRightMotor;
    public static SpeedController drivetrainFrontLeftMotor;
    public static RobotDrive drivetrainDrivetrainMotors;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        climbingClimbingArmExtensionMotor = new VictorSP(7);
        LiveWindow.addActuator("Climbing", "ClimbingArmExtensionMotor", (VictorSP) climbingClimbingArmExtensionMotor);
        
        climbingClimbingWinchMotor = new VictorSP(6);
        LiveWindow.addActuator("Climbing", "ClimbingWinchMotor", (VictorSP) climbingClimbingWinchMotor);
        
        climbingArmRotatationSolenoid = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("Climbing", "ArmRotatationSolenoid", climbingArmRotatationSolenoid);
        
        ballIntakeSweeperArmPositionPotentiometer = new AnalogPotentiometer(0, 1.0, 0.0);
        LiveWindow.addSensor("BallIntake", "SweeperArmPositionPotentiometer", ballIntakeSweeperArmPositionPotentiometer);
        
        ballIntakeSweeperArmPositionMotor = new TalonSRX(4);
        LiveWindow.addActuator("BallIntake", "SweeperArmPositionMotor", (TalonSRX) ballIntakeSweeperArmPositionMotor);
        
        ballIntakeSweeperBarRotationMotor = new Relay(0);
        LiveWindow.addActuator("BallIntake", "SweeperBarRotationMotor", ballIntakeSweeperBarRotationMotor);
        
        drivetrainRightDrivetrainEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "RightDrivetrainEncoder", drivetrainRightDrivetrainEncoder);
        drivetrainRightDrivetrainEncoder.setDistancePerPulse(1.0);
        drivetrainRightDrivetrainEncoder.setPIDSourceType(PIDSourceType.kRate);
        drivetrainLeftDrivetrainEncoder = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "LeftDrivetrainEncoder", drivetrainLeftDrivetrainEncoder);
        drivetrainLeftDrivetrainEncoder.setDistancePerPulse(1.0);
        drivetrainLeftDrivetrainEncoder.setPIDSourceType(PIDSourceType.kRate);
        drivetrainBackRightMotor = new VictorSP(0);
        LiveWindow.addActuator("Drivetrain", "BackRightMotor", (VictorSP) drivetrainBackRightMotor);
        
        drivetrainBackLeftMotor = new VictorSP(1);
        LiveWindow.addActuator("Drivetrain", "BackLeftMotor", (VictorSP) drivetrainBackLeftMotor);
        
        drivetrainFrontRightMotor = new VictorSP(2);
        LiveWindow.addActuator("Drivetrain", "FrontRightMotor", (VictorSP) drivetrainFrontRightMotor);
        
        drivetrainFrontLeftMotor = new VictorSP(3);
        LiveWindow.addActuator("Drivetrain", "FrontLeftMotor", (VictorSP) drivetrainFrontLeftMotor);
        
        drivetrainDrivetrainMotors = new RobotDrive(drivetrainFrontLeftMotor, drivetrainBackLeftMotor,
              drivetrainFrontRightMotor, drivetrainBackRightMotor);
        
        drivetrainDrivetrainMotors.setSafetyEnabled(true);
        drivetrainDrivetrainMotors.setExpiration(0.1);
        drivetrainDrivetrainMotors.setSensitivity(0.5);
        drivetrainDrivetrainMotors.setMaxOutput(1.0);
        drivetrainDrivetrainMotors.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        drivetrainDrivetrainMotors.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        drivetrainDrivetrainMotors.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        drivetrainDrivetrainMotors.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
