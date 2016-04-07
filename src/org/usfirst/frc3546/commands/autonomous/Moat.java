package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3546.StopWhen;
import org.usfirst.frc3546.commands.*;

/**
 * Created by Owner on 2/27/2016.
 */
public class Moat extends CommandGroup {
    public Moat(boolean drop_ball, boolean back_over, boolean inReverse, StopWhen stopWhen){
        //In reverse assumes the robot is already oriented correctly relative to the defense
        addSequential(new DriveOverDefense(inReverse));
        addSequential(new DriveStraight(.8, inReverse, false));
        if (drop_ball || back_over) addParallel(new WaitCommand(3));
        if (drop_ball) addParallel(new DropBall(true));
        if (stopWhen == StopWhen.Collision) {
            addSequential(new DriveStraight(inReverse, true, StopWhen.Collision));
        } else {
            if (back_over) {
                addSequential(new DriveOverDefense(!inReverse, false));
                addSequential(new DriveStraight(.05, !inReverse, false));
            }
        }
    }

    public Moat(boolean drop_ball, boolean back_over, StopWhen stopWhen){
        this(drop_ball, back_over, false, stopWhen);
    }

    public Moat(boolean drop_ball, boolean back_over){
            this(drop_ball, back_over, null);
    }

    public Moat(boolean drop_ball){
            this(drop_ball, true);
    }
}
