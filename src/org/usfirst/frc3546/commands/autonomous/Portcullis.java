package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3546.StopWhen;
import org.usfirst.frc3546.commands.*;

/**
 * Created by Andrew on 3/22/16.
 */
public class Portcullis extends CommandGroup {
    public Portcullis(boolean drop_ball, StopWhen stopWhen){
        addSequential(new SweeperArmPositionLower());
        addSequential(new DriveStraight(false, true, StopWhen.Collision));
        addParallel(new SweeperArmPositionRaise());
        addSequential(new DriveStraight(1.2, false, false));
        if (drop_ball) addParallel(new DropBall(true));
        if (stopWhen == StopWhen.Collision) {
            addSequential(new DriveStraight(false, true, StopWhen.Collision));
        } else if (stopWhen == StopWhen.NotLevel){
            addSequential(new DriveStraight(false, true, StopWhen.NotLevel));
        }
    }

    public Portcullis(boolean drop_ball){
        this(drop_ball, null);
    }
}
