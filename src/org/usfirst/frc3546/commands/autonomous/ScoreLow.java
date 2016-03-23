package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3546.StopWhen;
import org.usfirst.frc3546.commands.DriveAtAngle;
import org.usfirst.frc3546.commands.DriveStraight;
import org.usfirst.frc3546.commands.SweeperArmPositionLower;
import org.usfirst.frc3546.commands.SweeperBarRotationOut;

/**
 * Created by Owner on 3/5/2016.
 */
public class ScoreLow extends CommandGroup {
    public ScoreLow(boolean onTowerLeft){
        addSequential(new DriveAtAngle(0)); //Drive towards wall
        addSequential(new DriveAtAngle(0, 1, StopWhen.Collision)); //Hits wall
        addSequential(new DriveStraight(.3, true, true)); //Back up a bit

        double angleMult;
        if (onTowerLeft) {
            angleMult = 1;
        } else {
            angleMult = -1;
        }

        addSequential(new DriveAtAngle(angleMult * 90)); //Spin
        addSequential(new ScoreLowFromWall(angleMult * 80)); //Score
    }
}
