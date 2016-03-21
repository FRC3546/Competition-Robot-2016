package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3546.commands.*;

/**
 * Created by Andrew on 3/10/16.
 */
public class BurgleBall extends CommandGroup {
    public BurgleBall(){
        addParallel(new DriveStraight(.15, true));
        addParallel(new SweeperArmPositionLower());
        addSequential(new SweeperBarRotationIn(), 1);
        addSequential(new DriveStraight(.5, true));
        addSequential(new DriveAtAngle(180));
        addSequential(new WaitCommand(.5));
        addSequential(new ZeroYaw());
    }
}
