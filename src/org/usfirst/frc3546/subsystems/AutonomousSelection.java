package org.usfirst.frc3546.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3546.SequentialBiCommand;
import org.usfirst.frc3546.StopWhen;
import org.usfirst.frc3546.commands.DriveAtAngle;
import org.usfirst.frc3546.commands.LateralAuto;
import org.usfirst.frc3546.commands.SequentialCommands;
import org.usfirst.frc3546.commands.SweeperArmPositionLower;
import org.usfirst.frc3546.commands.autonomous.*;

/**
 * Created by Andrew on 3/5/16.
 */
public class AutonomousSelection {
    private SendableChooser primaryChooser;
    private SendableChooser delayChooser;
    private SendableChooser movementChooser;
    private SendableChooser scoreChooser;
    private SendableChooser burglingChooser;

    public AutonomousSelection(){
        burglingChooser = new SendableChooser();
        burglingChooser.addDefault("Don't Burgle", new DoNothing());
        burglingChooser.addObject("Burgle Before", new BurgleBall());
        burglingChooser.addObject("Set up to Burgle After Auto",
                new SequentialCommands(new DriveAtAngle(180), new SweeperArmPositionLower())
        );

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
        movementChooser.addObject("Two Defenses Right", new LateralAuto(2));
        movementChooser.addObject("One Defense Left", new LateralAuto(-1));
        movementChooser.addObject("Two Defenses Left",  new LateralAuto(-2));

        primaryChooser = new SendableChooser();
        primaryChooser.addDefault("Do Nothing", new DoNothing());

        primaryChooser.addObject("Low Bar - Drop Ball, Go back", new LowBar(true));
        primaryChooser.addObject("Category B - Drop Ball, Go back", new Moat(true));
        primaryChooser.addObject("Category D - Drop Ball, Go back", new RockWallRevised(true));

        primaryChooser.addObject("Low Bar - Keep Ball, Go back", new LowBar(false));
        primaryChooser.addObject("Category B - Keep Ball, Go back", new Moat(false));
        primaryChooser.addObject("Category D - Keep Ball, Go back", new RockWallRevised(false));

        primaryChooser.addObject("Low Bar - Keep Ball, Stay", new LowBar(false, false));
        primaryChooser.addObject("Cheval De Frise - Keep Ball, Stay", new ChevalDeFrise(false));
        primaryChooser.addObject("Portcullis - Keep Ball, Stay", new Portcullis(false));
        primaryChooser.addObject("Category B - Keep Ball, Stay", new Moat(false, false));
        primaryChooser.addObject("Category D - Keep Ball, Stay", new RockWallRevised(false, false));

        primaryChooser.addObject("Cheval De Frise - Drop Ball, Stay", new ChevalDeFrise(true));
        primaryChooser.addObject("Portcullis - Drop Ball, Stay", new Portcullis(true));

        primaryChooser.addObject("Low Bar - Keep Ball, Get out of way (collision)", new LowBar(false, false, StopWhen.Collision));
        primaryChooser.addObject("Cheval De Frise - Keep Ball, Get out of way (collision)", new ChevalDeFrise(false, StopWhen.Collision));
        primaryChooser.addObject("Portcullis - Keep Ball, Get out of way (collision)", new Portcullis(false, StopWhen.Collision));
        primaryChooser.addObject("Category B - Keep Ball, Get out of way (collision)", new Moat(false, false, StopWhen.Collision));
        primaryChooser.addObject("Category D - Keep Ball, Get out of way (collision)", new RockWallRevised(false, false, StopWhen.Collision));

        primaryChooser.addObject("Low Bar - Keep Ball, Get out of way (On Ramp)", new LowBar(false, false, StopWhen.NotLevel));
        primaryChooser.addObject("Cheval De Frise - Keep Ball, Get out of way (On Ramp)", new ChevalDeFrise(false, StopWhen.NotLevel));
        primaryChooser.addObject("Portcullis - Keep Ball, Get out of way (On Ramp)", new Portcullis(false, StopWhen.NotLevel));
        primaryChooser.addObject("Category B - Keep Ball, Get out of way (On Ramp)", new Moat(false, false, StopWhen.NotLevel));
        primaryChooser.addObject("Category D - Keep Ball, Get out of way (On Ramp)", new RockWallRevised(false, false, StopWhen.NotLevel));

        primaryChooser.addObject("Score From Spy Box", new ScoreLowFromWall(0));

        scoreChooser = new SendableChooser();
        scoreChooser.addDefault("Don't Score", new DoNothing());
        scoreChooser.addObject("Defenses 1 or 2", new ScoreLow(true));
        scoreChooser.addObject("Defense 3", new SequentialBiCommand(new LateralAuto(-2), new ScoreLow(true)));
        scoreChooser.addObject("Defense 4", new SequentialBiCommand(new LateralAuto(-3), new ScoreLow(true)));
        scoreChooser.addObject("Defense 5", new ScoreLow(false));

        SmartDashboard.putData("Autonomous Lateral Movement Chooser", movementChooser);
        SmartDashboard.putData("Autonomous Mode Chooser", primaryChooser);
        SmartDashboard.putData("Autonomous Delay Chooser", delayChooser);
        SmartDashboard.putData("Autonomous Score Mode Chooser", scoreChooser);
    }

    public Command getSelectedCommand(){
        Command burgleCommand1 = (Command) burglingChooser.getSelected();
        Command burgleCommand2 = (Command) burglingChooser.getSelected();

        if (burgleCommand1 instanceof SequentialCommands) burgleCommand1 = new DoNothing();
        if (burgleCommand2 instanceof BurgleBall) burgleCommand2 = new DoNothing();

        return new SequentialCommands(
                burgleCommand1,
                new WaitCommand((Double) delayChooser.getSelected()),
                (Command) movementChooser.getSelected(),
                (Command) primaryChooser.getSelected(),
                (Command) scoreChooser.getSelected(),
                burgleCommand2
            );
    }
}
