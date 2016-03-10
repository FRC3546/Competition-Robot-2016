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
public class ScoreLowFromWall extends CommandGroup {
    public ScoreLowFromWall(double finalScoreAngle){
        addSequential(new DriveAtAngle(finalScoreAngle, .4, StopWhen.NotLevel));
        addParallel(new SweeperArmPositionLower());
        addSequential(new WaitCommand(3.7));
        addParallel(new SweeperBarRotationOut(), 3);
        addSequential(new DriveStraight(1, false, true));
    }
}
