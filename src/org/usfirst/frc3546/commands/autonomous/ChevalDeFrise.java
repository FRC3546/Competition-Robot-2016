package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3546.SequentialBiCommand;
import org.usfirst.frc3546.StopWhen;
import org.usfirst.frc3546.commands.*;

/**
 * Created by Owner on 2/27/2016.
 */
public class ChevalDeFrise extends CommandGroup {
    public ChevalDeFrise(boolean drop_ball, StopWhen stopWhen){

        addSequential(new DriveStraight(1.9, false));
//        addParallel(new DriveStraight(.2, false, false));
        addSequential(new WaitCommand(.075));
        addSequential(new SweeperArmPositionLower());
        addSequential(new WaitCommand(.6));

        addSequential(new DriveStraight(false, true, StopWhen.ChevalAngle));
        addParallel(new SweeperArmPositionRaise());

//        addSequential(new WaitCommand(.2));
        addSequential(new DriveStraight(false, true, StopWhen.Level));
        addSequential(new DriveStraight(1.0,false));

        if (drop_ball) addSequential(new WaitCommand(.5));
        if (drop_ball) addParallel(new DropBall(true));

        if (stopWhen == StopWhen.Collision) {
            addSequential(new DriveStraight(false, true, StopWhen.Collision));
        }

    }

    public ChevalDeFrise(boolean drop_ball){
        this(drop_ball, null);
    }
}
