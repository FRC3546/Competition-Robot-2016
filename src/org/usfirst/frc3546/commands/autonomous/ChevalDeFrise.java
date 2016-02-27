package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc3546.commands.DriveStraight;
import org.usfirst.frc3546.commands.SweeperArmPositionLower;
import org.usfirst.frc3546.commands.SweeperArmPositionRaise;
import org.usfirst.frc3546.commands.SweeperBarRotationOut;

/**
 * Created by Owner on 2/27/2016.
 */
public class ChevalDeFrise extends CommandGroup {
    public ChevalDeFrise(){

        addSequential(new DriveStraight(2, false));

        addSequential(new SweeperArmPositionLower());
        addSequential(new DriveStraight(.5, false));

        addSequential(new SweeperArmPositionRaise());
        addSequential(new DriveStraight(4, false));

        addSequential(new SweeperArmPositionLower());
        addSequential(new SweeperBarRotationOut(), 1);

        addSequential(new SweeperArmPositionRaise());
        addSequential(new DriveStraight(-1, true));
    }
}
