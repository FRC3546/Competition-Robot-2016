package org.usfirst.frc3546.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3546.StopWhen;
import org.usfirst.frc3546.commands.autonomous.*;

import java.awt.geom.Arc2D;

/**
 * Created by Andrew on 3/5/16.
 */
public class AutonomousSelection {
    private SendableChooser autoChooser;
    private SendableChooser delayChooser;

    public AutonomousSelection(){
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Do Nothing", new DoNothing());

        autoChooser.addObject("Low Bar - Drop Ball", new LowBar(true));
        autoChooser.addObject("Cheval De Frise - Drop Ball", new ChevalDeFrise(true));
        autoChooser.addObject("Category B - Drop Ball", new Moat(true));
        autoChooser.addObject("Category D - Drop Ball", new RockWallRevised(true));

        autoChooser.addObject("Low Bar - Keep Ball", new LowBar(false));
        autoChooser.addObject("Cheval De Frise - Keep Ball", new ChevalDeFrise(false));
        autoChooser.addObject("Category B - Keep Ball", new Moat(false));
        autoChooser.addObject("Category D - Keep Ball", new RockWallRevised(false));

        autoChooser.addObject("Low Bar - Keep Ball, Get out of way (collision)", new LowBar(false, StopWhen.Collision));
        autoChooser.addObject("Cheval De Frise - Keep Ball, Get out of way (collision)", new ChevalDeFrise(false, StopWhen.Collision));
        autoChooser.addObject("Category B - Keep Ball, Get out of way (collision)", new Moat(false, StopWhen.Collision));
        autoChooser.addObject("Category D - Keep Ball, Get out of way (collision)", new RockWallRevised(false, StopWhen.Collision));

        autoChooser.addObject("Low Bar - Keep Ball, Get out of way (On Ramp)", new LowBar(false, StopWhen.NotLevel));
        autoChooser.addObject("Cheval De Frise - Keep Ball, Get out of way (On Ramp)", new ChevalDeFrise(false, StopWhen.NotLevel));
        autoChooser.addObject("Category B - Keep Ball, Get out of way (On Ramp)", new Moat(false, StopWhen.NotLevel));
        autoChooser.addObject("Category D - Keep Ball, Get out of way (On Ramp)", new RockWallRevised(false, StopWhen.NotLevel));

        delayChooser = new SendableChooser();
        delayChooser.addDefault("0 Seconds", 0.0);
        delayChooser.addObject("1 Second", 1.0);
        delayChooser.addObject("2 Seconds", 2.0);
        delayChooser.addObject("3 Seconds", 3.0);
        delayChooser.addObject("4 Seconds", 4.0);
        delayChooser.addObject("5 Seconds", 5.0);
        delayChooser.addObject("6 Seconds", 6.0);
        delayChooser.addObject("7 Seconds", 7.0);
        delayChooser.addObject("8 Seconds", 8.0);
        delayChooser.addObject("9 Seconds", 9.0);
        delayChooser.addObject("10 Seconds", 10.0);

        SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
        SmartDashboard.putData("Autonomous Delay Chooser", delayChooser);
    }

    public Command getSelectedCommand(){
        return (Command) autoChooser.getSelected();
    }

    public double getSelectedDelay(){
        return (Double) delayChooser.getSelected();
    }
}
