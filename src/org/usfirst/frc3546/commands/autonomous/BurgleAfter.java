package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3546.commands.DriveAtAngle;
import org.usfirst.frc3546.commands.SequentialCommands;
import org.usfirst.frc3546.commands.SweeperArmPositionLower;

/**
 * Created by Andrew on 4/7/2016.
 */
public class BurgleAfter extends CommandGroup {
    public BurgleAfter(double angle){
        addSequential(new WaitCommand(1));
        addSequential(new DriveAtAngle(angle));
        addSequential(new SweeperArmPositionLower());
    }
}
