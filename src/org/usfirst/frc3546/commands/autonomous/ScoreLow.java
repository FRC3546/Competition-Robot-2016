package org.usfirst.frc3546.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3546.StopWhen;
import org.usfirst.frc3546.commands.*;

/**
 * Created by Owner on 3/5/2016.
 */
public class ScoreLow extends CommandGroup {
    public ScoreLow(boolean onTowerLeft, boolean slight_angle){
        addParallel(new SweeperArmPositionRaise());
        int angle = 0;
        if (slight_angle){
            if (onTowerLeft) {
                angle = 7;
            } else {
                angle = 4;
            }
        }
        addSequential(new DriveAtAngle(angle)); //Drive towards wall
        addSequential(new DriveAtAngle(angle, .75, StopWhen.Collision)); //Hits wall
        addSequential(new DriveStraight(.2, true, true)); //Back up a bit

        double angleMult;
        if (onTowerLeft) {
            angleMult = 1;
        } else {
            angleMult = -1;
        }

        addSequential(new DriveAtAngle(angleMult * 90)); //Spin
        if (onTowerLeft) {
            addSequential(new ScoreLowFromWall(angleMult * 80));
        } else {
            addSequential(new ScoreLowFromWall(angleMult * 75));
        }
    }
}
