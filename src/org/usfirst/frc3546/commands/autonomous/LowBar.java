package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3546.StopWhen;
import org.usfirst.frc3546.commands.*;

/**
 * Created by Owner on 2/27/2016.
 */
public class LowBar extends CommandGroup {
    public LowBar(boolean drop_ball){
        addSequential(new SweeperArmPositionLower());
        addSequential(new DriveOverDefense(false));
        addSequential(new DriveStraight(1.2, false, false));
        if (drop_ball) addParallel(new SweeperBarRotationOut(), 2);
        addSequential(new WaitCommand(1));
        addSequential(new DriveOverDefense(true, true));
        addSequential(new DriveStraight(2.4, true, false));
    }
}
