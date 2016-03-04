package org.usfirst.frc3546.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3546.Robot;
import org.usfirst.frc3546.StopWhen;

/**
 * Created by Owner on 2/27/2016.
 */
public class DriveOverDefense extends CommandGroup {
    public DriveOverDefense(boolean drive_backwards){
        this(drive_backwards, false);
    }

    public DriveOverDefense(boolean drive_backwards, boolean stop_inside){
        addSequential(new DriveStraight(drive_backwards, true, StopWhen.NotLevel));
        if (!stop_inside) addSequential(new DriveStraight(.3, drive_backwards, false));
        if (!stop_inside) addSequential(new DriveStraight(drive_backwards, false, StopWhen.Level));
    }
}
