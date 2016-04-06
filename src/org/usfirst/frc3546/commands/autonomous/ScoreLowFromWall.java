package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3546.StopWhen;
import org.usfirst.frc3546.commands.*;

/**
 * Created by Owner on 3/5/2016.
 */
public class ScoreLowFromWall extends CommandGroup {
    public ScoreLowFromWall(double finalScoreAngle){
        addSequential(new DriveAtAngle(finalScoreAngle, .5, StopWhen.NotLevel));
        addParallel(new SweeperArmPositionLower());
        addParallel(new SequentialCommands(new WaitCommand(.3), new SweeperBarRotationOut()), 7);
        addSequential(new WaitCommand(1.5));
        addSequential(new DriveStraight(1.5, false, true));

        //Ram Again
        addSequential(new WaitCommand(1));
        addSequential(new DriveStraight(1.5, false, true));

        //And again...
        addSequential(new WaitCommand(1));
        addSequential(new DriveStraight(1.5, false, true));
        addSequential(new WaitCommand(1));
        addSequential(new DriveStraight(1.5, false, true));
    }
}
