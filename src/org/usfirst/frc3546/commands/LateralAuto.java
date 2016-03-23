package org.usfirst.frc3546.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3546.commands.autonomous.DoNothing;

/**
 * Created by Andrew on 3/10/16.
 */
public class LateralAuto extends CommandGroup {
    /**
     *
     * @param numStations -3 = Three left, -2 = Two left, -1 = One Left,
     *                  0 = Nothing,
     *                  1 = One Right, 2 = Two Right
     */
    public LateralAuto(int numStations){
        if (numStations != 0) {
            addSequential(new DriveStraight(.7, false, true));
            addSequential(new WaitCommand(.5));

            double angle;
            if (numStations < 0) {
                angle = -90;
            } else {
                angle = 90;
            }

            addSequential(new DriveAtAngle(angle));
            addSequential(new DriveAtAngle(angle, .4, 1.5 * Math.abs(numStations)));
            addSequential(new DriveAtAngle(0));
        }
    }
}
