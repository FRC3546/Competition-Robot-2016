package org.usfirst.frc3546.commands;

import org.usfirst.frc3546.Robot;

/**
 * Created by Owner on 3/5/2016.
 */
public class ZeroYaw extends SimpleCommand {
    private boolean flipped;

    public ZeroYaw(){
        this.flipped = false;
    }

    public ZeroYaw(boolean flipped){
        this.flipped = flipped;
    }

    protected void initialize(){
        if (!flipped) Robot.gyro.zeroYaw();
        else Robot.gyro.zeroYawTo180();
    }
}
