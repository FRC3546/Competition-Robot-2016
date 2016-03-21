package org.usfirst.frc3546.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3546.SequentialBiCommand;
import org.usfirst.frc3546.StopWhen;
import org.usfirst.frc3546.commands.LateralAuto;
import org.usfirst.frc3546.commands.SequentialCommands;
import org.usfirst.frc3546.commands.autonomous.*;

import java.awt.geom.Arc2D;
import java.util.Comparator;

/**
 * Created by Andrew on 3/5/16.
 */
public class AutonomousSelection {
    private SendableChooser autoChooser;
    private SendableChooser delayChooser;
    private SendableChooser movementChooser;
    private SendableChooser scoreChooser;

    public AutonomousSelection(){
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

        movementChooser = new SendableChooser();
        movementChooser.addDefault("No Lateral Movement", new DoNothing());
        movementChooser.addObject("One Defense Right", new LateralAuto(1));
        movementChooser.addObject("Two Defenses Right", new LateralAuto(2) );
        movementChooser.addObject("One Defense Left",  new LateralAuto(-1));
        movementChooser.addObject("Two Defenses Left",  new LateralAuto(-2));

        autoChooser = new SendableChooser();
        autoChooser.addDefault("Do Nothing", new DoNothing());

        autoChooser.addObject("Low Bar - Drop Ball, Go back", new LowBar(true));
        autoChooser.addObject("Cheval De Frise - Drop Ball, Go back", new ChevalDeFrise(true));
        autoChooser.addObject("Category B - Drop Ball, Go back", new Moat(true));
        autoChooser.addObject("Category D - Drop Ball, Go back", new RockWallRevised(true));

        autoChooser.addObject("Low Bar - Keep Ball, Go back", new LowBar(false));
        autoChooser.addObject("Cheval De Frise - Keep Ball, Go back", new ChevalDeFrise(false));
        autoChooser.addObject("Category B - Keep Ball, Go back", new Moat(false));
        autoChooser.addObject("Category D - Keep Ball, Go back", new RockWallRevised(false));

        autoChooser.addObject("Low Bar - Keep Ball, Stay", new LowBar(false, false));
        autoChooser.addObject("Cheval De Frise - Keep Ball, Stay", new ChevalDeFrise(false));
        autoChooser.addObject("Category B - Keep Ball, Stay", new Moat(false, false));
        autoChooser.addObject("Category D - Keep Ball, Stay", new RockWallRevised(false, false));

        autoChooser.addObject("Low Bar - Keep Ball, Get out of way (collision)", new LowBar(false, false, StopWhen.Collision));
        autoChooser.addObject("Cheval De Frise - Keep Ball, Get out of way (collision)", new ChevalDeFrise(false, StopWhen.Collision));
        autoChooser.addObject("Category B - Keep Ball, Get out of way (collision)", new Moat(false, false, StopWhen.Collision));
        autoChooser.addObject("Category D - Keep Ball, Get out of way (collision)", new RockWallRevised(false, false, StopWhen.Collision));

        autoChooser.addObject("Low Bar - Keep Ball, Get out of way (On Ramp)", new LowBar(false, false, StopWhen.NotLevel));
        autoChooser.addObject("Cheval De Frise - Keep Ball, Get out of way (On Ramp)", new ChevalDeFrise(false, StopWhen.NotLevel));
        autoChooser.addObject("Category B - Keep Ball, Get out of way (On Ramp)", new Moat(false, false, StopWhen.NotLevel));
        autoChooser.addObject("Category D - Keep Ball, Get out of way (On Ramp)", new RockWallRevised(false, false, StopWhen.NotLevel));

        autoChooser.addObject("Score From Spy Box", new ScoreLowFromWall(0));
//        autoChooser.addObject("Score From Spy Box", new ScoreLowFromWall(0));

        //TODO: Implement Ball Burglar Command
        //TODO: Test, Test, Test!

        scoreChooser = new SendableChooser();
        scoreChooser.addDefault("Don't Score", new DoNothing());
        scoreChooser.addObject("Defenses 1 or 2", new ScoreLow(true));
        scoreChooser.addObject("Defense 3", new SequentialBiCommand(new LateralAuto(-2), new ScoreLow(true)));
        scoreChooser.addObject("Defense 4", new SequentialBiCommand(new LateralAuto(-3), new ScoreLow(true)));
        scoreChooser.addObject("Defense 5", new ScoreLow(false));

        SmartDashboard.putData("Autonomous Lateral Movement Chooser", movementChooser);
        SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
        SmartDashboard.putData("Autonomous Delay Chooser", delayChooser);
        SmartDashboard.putData("Autonomous Score Mode Chooser", scoreChooser);
    }

    public Command getSelectedCommand(){
        return new SequentialCommands(
                new WaitCommand((Double) delayChooser.getSelected()),
                (Command) movementChooser.getSelected(),
                (Command) autoChooser.getSelected(),
                (Command) scoreChooser.getSelected()
            );
    }
}
