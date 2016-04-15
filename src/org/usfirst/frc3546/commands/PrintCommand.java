package org.usfirst.frc3546.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Created by Owner on 4/15/2016.
 */
public class PrintCommand extends SimpleCommand {
    String message;
    public PrintCommand (String message){
        this.message = message;
    }

    @Override
    protected void initialize() {
        System.out.println(message);
    }
}
