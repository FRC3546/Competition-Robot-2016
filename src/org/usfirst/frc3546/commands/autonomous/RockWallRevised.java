package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3546.commands.DriveOverDefense;
import org.usfirst.frc3546.commands.DriveStraight;
import org.usfirst.frc3546.commands.DropBall;

/**
 * Created by Owner on 2/27/2016.
 */
public class RockWallRevised extends CommandGroup {
    public RockWallRevised(boolean drop_ball){
        addSequential(new DriveOverDefense(false));
        addSequential(new DriveStraight(.2, false, false));
        addParallel(new WaitCommand(1));
        if (drop_ball) addSequential(new DropBall(true));
        addSequential(new DriveOverDefense(true, false));
    }
}
