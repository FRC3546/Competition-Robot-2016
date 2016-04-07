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
    public LowBar(boolean drop_ball, boolean back_over, boolean inReverse, StopWhen stopWhen){
        //In reverse assumes the robot is already oriented correctly relative to the defense
        addSequential(new SweeperArmPositionLower());
        addSequential(new DriveOverDefense(inReverse));
        addSequential(new DriveStraight(.5, inReverse, false));
        if (drop_ball && !(inReverse && back_over)) addParallel(new SweeperBarRotationOut(), 2);
        if (stopWhen == StopWhen.Collision) {
            addSequential(new DriveStraight(inReverse, true, StopWhen.Collision));
        } else {
            if (back_over) {
                addSequential(new WaitCommand(1));
                addSequential(new DriveOverDefense(!inReverse, true));
                addSequential(new DriveStraight(1.5, !inReverse, false));
            }
        }
    }

    public LowBar(boolean drop_ball, boolean back_over, StopWhen stopWhen){
        this(drop_ball, back_over, false, stopWhen);
    }


    public LowBar(boolean drop_ball, boolean back_over, boolean inReverse){
        this(drop_ball, back_over, inReverse, null);
    }

    public LowBar(boolean drop_ball, boolean back_over){
        this(drop_ball, back_over, false, null);
    }

    public LowBar(boolean drop_ball){
        this(drop_ball, true);
    }
}
