package org.usfirst.frc3546.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3546.commands.autonomous.*;

/**
 * Created by Andrew on 3/5/16.
 */
public class AutonomousSelection {
    private SendableChooser autoChooser;

    public AutonomousSelection(){
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Do Nothing", new DoNothing());
        autoChooser.addObject("Low Bar - Drop Ball", new LowBar());
        autoChooser.addObject("Cheval De Frise - Drop Ball", new ChevalDeFrise());
        autoChooser.addObject("Category B - Drop Ball", new Moat());
        autoChooser.addObject("Category D - Drop Ball", new RockWallRevised());

        SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
    }

    public Command getSelectedCommand(){
        return (Command) autoChooser.getSelected();
    }
}
