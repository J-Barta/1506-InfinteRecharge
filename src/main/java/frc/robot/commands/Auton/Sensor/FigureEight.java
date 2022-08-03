package frc.robot.commands.Auton.Sensor;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;

public class FigureEight extends SequentialCommandGroup {

    public FigureEight(Drivetrain dt) {
        addCommands(
                dt.getRamseteCommand("figure-eight", true)
        );
    }
}
