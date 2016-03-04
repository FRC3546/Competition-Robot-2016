package org.usfirst.frc3546;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by Owner on 3/3/2016.
 */
public class SequentialBiCommand extends CommandGroup {
    public SequentialBiCommand(Command command1, Command command2){
        addSequential(command1);
        addSequential(command2);
    }
}
