package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3546.StopWhen;
import org.usfirst.frc3546.commands.*;

/**
 * Created by Owner on 2/27/2016.
 */
public class Moat extends CommandGroup {
    public Moat(boolean drop_ball){
        addSequential(new DriveOverDefense(false));
        addSequential(new DriveStraight(.8, false, false));
        addParallel(new WaitCommand(1));
        if (drop_ball) addSequential(new DropBall(true));
        addSequential(new DriveOverDefense(true, false));
        addSequential(new DriveStraight(.3, true, false));
    }
}
