package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc3546.commands.DriveAtAngle;
import org.usfirst.frc3546.commands.DriveStraight;

/**
 * Created by Owner on 4/12/2016.
 */
public class BurgleSecretPassage extends CommandGroup {
    public BurgleSecretPassage(){
        addSequential(new BurgleBall(false));
        addSequential(new DriveAtAngle(-90));
        addSequential(new DriveStraight(1.1, false));
        addSequential(new DriveAtAngle(0));
    }
}
