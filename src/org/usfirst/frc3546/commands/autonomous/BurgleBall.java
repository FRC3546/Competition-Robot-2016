package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3546.commands.*;

/**
 * Created by Andrew on 3/10/16.
 */
public class BurgleBall extends CommandGroup {
    public BurgleBall(boolean turnAround){
        if (!turnAround) addSequential(new ZeroYaw(true));
//        addParallel(new DriveStraight(.6, true));
        addParallel(new SweeperArmPositionLower());
        addParallel(new SweeperBarRotationIn(), 2.5);
        addSequential(new WaitCommand(2));
        addSequential(new SweeperArmPositionRaise());
        addSequential(new DriveStraight(.5, true));
        if (turnAround) addSequential(new DriveAtAngle(-175));
        if (turnAround) addSequential(new WaitCommand(.5));
        if (turnAround) addSequential(new ZeroYaw());
    }
}
