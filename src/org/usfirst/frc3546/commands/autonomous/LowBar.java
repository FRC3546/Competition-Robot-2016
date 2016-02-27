package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc3546.commands.DriveStraight;
import org.usfirst.frc3546.commands.SweeperArmPositionLower;
import org.usfirst.frc3546.commands.SweeperArmPositionRaise;
import org.usfirst.frc3546.commands.SweeperBarRotationOut;

/**
 * Created by Owner on 2/27/2016.
 */
public class LowBar extends CommandGroup {
    public LowBar(){
        addSequential(new SweeperArmPositionLower());
        addSequential(new DriveStraight(5, false));
        addSequential(new SweeperBarRotationOut(), 1);
        addSequential(new SweeperArmPositionRaise());
        addSequential(new DriveStraight(-1, true));
    }
}
