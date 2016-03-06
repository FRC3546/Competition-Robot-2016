package org.usfirst.frc3546.commands;

import org.usfirst.frc3546.Robot;

/**
 * Created by Owner on 3/5/2016.
 */
public class PrintGryo extends SimpleCommand {
    @Override
    protected void initialize() {
        System.out.println(Robot.gyro.getRobotPitch());
    }
}
