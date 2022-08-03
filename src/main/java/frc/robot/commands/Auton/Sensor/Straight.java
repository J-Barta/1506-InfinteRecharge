package frc.robot.commands.Auton.Sensor;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;

public class Straight extends SequentialCommandGroup {

    public Straight(Drivetrain dt) {
        addCommands(
                dt.getRamseteCommand("Straight-1m", true)
        );
    }
}
