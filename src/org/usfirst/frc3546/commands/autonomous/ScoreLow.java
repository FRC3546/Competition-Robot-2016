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
    public ScoreLow(boolean onTowerLeft, boolean slight_angle, boolean startInReverse){
        addParallel(new SweeperArmPositionRaise());

        //Get to the wall
        float angle = 0;
        if (slight_angle){
            if (onTowerLeft) {
                angle = 7;
            } else {
                angle = 4;
            }
        }

        double driveTrainPower = .75;
        if (startInReverse) {
            angle = Gyro.convertToNegPos180(angle + 180);
            driveTrainPower = -driveTrainPower;
        }
        addSequential(new DriveAtAngle(angle, driveTrainPower, StopWhen.Collision)); //Drives and and hits wall
        addSequential(new DriveStraight(.2, !startInReverse, true)); //Back up a bit

        //Now we're at the wall. Score the goal
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
            addSequential(new ScoreLowFromWall(angleMult * 75));
        }
    }
}
