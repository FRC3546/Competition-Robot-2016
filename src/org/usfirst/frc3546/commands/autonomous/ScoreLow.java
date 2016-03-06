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
    public ScoreLow(){
//        addSequential(new DriveAtAngle(0));
//        addSequential(new DriveAtAngle(0, .6, StopWhen.Collision)); //Hits wall
//        addSequential(new DriveStraight(.3, true, true));
//        addSequential(new DriveAtAngle(90));
        addSequential(new DriveAtAngle(0, .4, StopWhen.NotLevel)); //TODO: Change 0 to 80
        addParallel(new SweeperArmPositionLower());
        addSequential(new WaitCommand(3.7));
        addParallel(new SweeperBarRotationOut());
//        addSequential(new DriveAtAngle(1.5, false, true));
    }
}
