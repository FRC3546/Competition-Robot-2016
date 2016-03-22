package org.usfirst.frc3546.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by Andrew on 3/21/16.
 */
public class SequentialCommands extends CommandGroup {
    public SequentialCommands (Command... commands){
        for (Command command : commands){
            addSequential(command);
        }
    }
}
