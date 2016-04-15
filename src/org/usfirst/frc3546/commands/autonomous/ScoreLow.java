package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3546.StopWhen;
import org.usfirst.frc3546.commands.*;
import org.usfirst.frc3546.subsystems.Gyro;

/**
 * Created by Owner on 3/5/2016.
 */
public class ScoreLow extends CommandGroup {
    public ScoreLow(DefenseSlot crossed_defense, boolean startInReverse){
        addParallel(new SweeperArmPositionRaise());

        //Get to the wall
        float intermediate_angle = 0;
        double intermediate_time = 0;
        switch (crossed_defense){
            case ThreeLeft: intermediate_angle = 0; intermediate_time = 0; break;
            case ThreeRight: intermediate_angle = 70; intermediate_time = 2.0; break;
        }

        float final_angle = 0;
        switch (crossed_defense){
            case LowBar: final_angle = 7; break;
            case Two: final_angle = 0; break;
            case ThreeLeft: final_angle = -25; break;
            case ThreeRight: final_angle = 20; break;
            case Four: final_angle = 23; break;
            case Five:final_angle = 4; break;
        }

        double driveTrainPower = .75;
        if (startInReverse) {
            final_angle = Gyro.convertToNegPos180(final_angle + 180);
            intermediate_angle = Gyro.convertToNegPos180(intermediate_angle + 180);
            driveTrainPower = -driveTrainPower;
        }

        if (crossed_defense == DefenseSlot.ThreeRight) {
            addSequential(new DriveAtAngle(intermediate_angle, driveTrainPower / 2, intermediate_time));
        }

        addSequential(new DriveAtAngle(final_angle, driveTrainPower, StopWhen.Collision)); //Drives and and hits wall
        addSequential(new DriveStraight(.4, !startInReverse, true)); //Back up a bit

        //Now we're at the wall. Score the goal
        boolean onTowerLeft = false;
        switch (crossed_defense){
            case LowBar: case Two: case ThreeLeft: onTowerLeft = true; break;
            case ThreeRight: case Four: case Five: onTowerLeft = false; break;
        }

        double angleMult;
        if (onTowerLeft) {
            angleMult = 1;
        } else {
            angleMult = -1;
        }

        addSequential(new DriveAtAngle(angleMult * 90)); //Spin
        if (onTowerLeft) {
            addSequential(new ScoreLowFromWall(angleMult * 80));
        } else {
            addSequential(new ScoreLowFromWall(angleMult * 70));
        }
    }
}
