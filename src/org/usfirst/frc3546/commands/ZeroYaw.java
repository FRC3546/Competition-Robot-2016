package org.usfirst.frc3546.commands;

import org.usfirst.frc3546.Robot;

/**
 * Created by Owner on 3/5/2016.
 */
public class ZeroYaw extends SimpleCommand {
    protected void initialize(){
        Robot.gyro.zeroYaw();
    }
}
