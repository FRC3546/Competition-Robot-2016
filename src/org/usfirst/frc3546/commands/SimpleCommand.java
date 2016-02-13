package org.usfirst.frc3546.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Created by Andrew on 12/15/15.
 */
public abstract class SimpleCommand extends Command {
    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void execute() {}

    @Override
    protected void end() {}
}
