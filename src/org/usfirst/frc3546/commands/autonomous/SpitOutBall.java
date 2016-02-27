package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc3546.commands.SweeperBarRotationOut;

/**
 * Created by Owner on 2/27/2016.
 */
public class SpitOutBall extends CommandGroup {
    public SpitOutBall(){
        addSequential(new SweeperBarRotationOut(), 1);
    }
}
