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
    public Ramparts(boolean drop_ball, boolean back_over, boolean inReverse, StopWhen stopWhen){
        //In reverse assumes the robot is already oriented correctly relative to the defense
        addSequential(new DriveOverDefense(inReverse));
        addSequential(new DriveStraight(1.2, inReverse, false));
        if (drop_ball || back_over) addParallel(new WaitCommand(2));
        if (drop_ball) addParallel(new DropBall(true));
        if (stopWhen == StopWhen.Collision) {
            addSequential(new DriveStraight(inReverse, true, StopWhen.Collision));
        } else {
            if (back_over) {
                addSequential(new DriveOverDefense(!inReverse, false));
//                addSequential(new DriveStraight(.1, true, false)); //CAUTION: IF YOU RE-ENABLE. Make sure to use inReverse for the direction
                addSequential(new DriveStraight(!inReverse, false, StopWhen.Level));
            }
        }
    }

    public Ramparts(boolean drop_ball, boolean back_over, StopWhen stopWhen){
        this(drop_ball, back_over, false, stopWhen);
    }

        public Ramparts(boolean drop_ball, boolean back_over){
            this(drop_ball, back_over, null);
    }

    public Ramparts(boolean drop_ball){
            this(drop_ball, true);
    }
}
