package org.usfirst.frc3546.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3546.Robot;
import org.usfirst.frc3546.subsystems.BallIntake;

/**
 * Created by Owner on 3/3/2016.
 */
public class DropBall extends CommandGroup {
    public DropBall(boolean arm_is_up){
        if (!arm_is_up) throw new IllegalArgumentException();
        addSequential(new SweeperArmPositionLower());
        addSequential(new WaitCommand(.2));
        addParallel(new SweeperBarRotationOut(), 2);
        addSequential(new WaitCommand(1.5));
        addSequential(new SweeperArmPositionRaise());
    }
}
