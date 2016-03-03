package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3546.StopWhen;
import org.usfirst.frc3546.commands.*;

/**
 * Created by Owner on 2/27/2016.
 */
public class Moat extends CommandGroup {
    public Moat(){
        addSequential(new DriveOverDefense(false));
        addSequential(new DriveStraight(.6, false, false));
//        addParallel(new SweeperBarRotationOut(), 2);
        addSequential(new WaitCommand(1));
        addSequential(new DriveOverDefense(true, false));
        addSequential(new DriveStraight(.3, true, false));
        addSequential(new WaitCommand(1));
        addSequential(new DriveStraight(false, true, StopWhen.NotLevel));
    }
}
