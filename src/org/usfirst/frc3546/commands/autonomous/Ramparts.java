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
        addSequential(new DriveStraight(.8, false, false));
        addParallel(new WaitCommand(1));
        if (drop_ball) addSequential(new DropBall(true));
        if (stopWhen == StopWhen.Collision) {
            addSequential(new DriveStraight(false, true, StopWhen.Collision));
        } else if (stopWhen == StopWhen.NotLevel){
            addSequential(new DriveStraight(false, true, StopWhen.NotLevel));
        } else {
            if (back_over) {
                addSequential(new DriveOverDefense(true, false));
                addSequential(new DriveStraight(.3, true, false));
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
