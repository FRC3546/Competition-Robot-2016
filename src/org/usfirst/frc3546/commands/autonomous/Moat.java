package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3546.StopWhen;
import org.usfirst.frc3546.commands.*;

/**
 * Created by Owner on 2/27/2016.
 */
public class Moat extends CommandGroup {
    public Moat(boolean drop_ball, boolean back_over, StopWhen stopWhen){
        addSequential(new DriveOverDefense(false));
        addSequential(new DriveStraight(.8, false, false));
        if (drop_ball || back_over) addParallel(new WaitCommand(3));
        if (drop_ball) addParallel(new DropBall(true));
        if (stopWhen == StopWhen.Collision) {
            addSequential(new DriveStraight(false, true, StopWhen.Collision));
        } else {
            if (back_over) {
                addSequential(new DriveOverDefense(true, false));
                addSequential(new DriveStraight(.05, true, false));
            }
        }
    }

    public Moat(boolean drop_ball, boolean back_over){
            this(drop_ball, back_over, null);
    }

    public Moat(boolean drop_ball){
            this(drop_ball, true);
    }
}
