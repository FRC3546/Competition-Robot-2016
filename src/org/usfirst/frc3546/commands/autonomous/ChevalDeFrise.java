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
    public ChevalDeFrise(){

        addSequential(new DriveStraight(.5, false, true, StopWhen.NotLevel));
        addParallel(new DriveStraight(.2, false, false));
//        addSequential(new WaitCommand(.2));
        addSequential(new SweeperArmPositionLower());
        addSequential(new WaitCommand(.7));

        addSequential(new DriveStraight(.4, false, true, StopWhen.ChevalAngle));
        addSequential(new WaitCommand(.3));

        addParallel(new SequentialBiCommand(new WaitCommand(.5), new SweeperArmPositionRaise()));
        addSequential(new DriveStraight(.2, false, true, StopWhen.Level));

//        addSequential(new WaitCommand(.5));
//        addSequential(new DropBall(true));
    }
}
