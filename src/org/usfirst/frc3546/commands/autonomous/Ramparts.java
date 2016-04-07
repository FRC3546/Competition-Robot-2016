package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3546.StopWhen;
import org.usfirst.frc3546.commands.DriveOverDefense;
import org.usfirst.frc3546.commands.DriveStraight;
import org.usfirst.frc3546.commands.DropBall;

/**
 * Created by Owner on 2/27/2016.
 */
public class Ramparts extends CommandGroup {
    public Ramparts(boolean drop_ball, boolean back_over, StopWhen stopWhen){
        addSequential(new DriveOverDefense(false));
        addSequential(new DriveStraight(1.2, false, false));
        addParallel(new WaitCommand(2));
        if (drop_ball) addParallel(new DropBall(true));
        if (stopWhen == StopWhen.Collision) {
            addSequential(new DriveStraight(false, true, StopWhen.Collision));
        } else {
            if (back_over) {
                addSequential(new DriveOverDefense(true, false));
//                addSequential(new DriveStraight(.1, true, false));
                addSequential(new DriveStraight(true, false, StopWhen.Level));
            }
        }
    }

    public Ramparts(boolean drop_ball, boolean back_over){
            this(drop_ball, back_over, null);
    }

    public Ramparts(boolean drop_ball){
            this(drop_ball, true);
    }
}
