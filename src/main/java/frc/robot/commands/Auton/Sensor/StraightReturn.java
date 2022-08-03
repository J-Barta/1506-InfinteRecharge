package frc.robot.commands.Auton.Sensor;

import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Drivetrain.TurnToAngleProfiled;
import frc.robot.subsystems.Drivetrain;

public class StraightReturn extends SequentialCommandGroup {

    public StraightReturn(Drivetrain dt) {
        addCommands(
                dt.getRamseteCommand("Straight-1m", true),
                new TurnToAngleProfiled(dt, 180),
                new PrintCommand("SJDFILSJDFLISJDIOFSDD FINISHED TURN"),
                dt.getRamseteCommand("Straight-1m", true)
        );
    }
}
