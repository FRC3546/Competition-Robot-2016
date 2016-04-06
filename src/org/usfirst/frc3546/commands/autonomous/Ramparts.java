package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc3546.StopWhen;

/**
 * Created by Andrew on 4/6/16.
 */
public class Ramparts extends CommandGroup {
    public Ramparts(boolean drop_ball, boolean back_over, StopWhen stopWhen){
        throw new UnsupportedOperationException("This code is template and MUST be replaced so that ramparts work");
    }

    public Ramparts(boolean drop_ball, boolean back_over){
        this(drop_ball, back_over, null);
    }

    public Ramparts(boolean drop_ball){
        this(drop_ball, true);
    }
}
