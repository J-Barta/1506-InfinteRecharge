package frc.robot.commands.Auton.Timed;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Timed.DriveTimed;
import frc.robot.subsystems.Drivetrain;

public class StraightTimed extends SequentialCommandGroup {

    public StraightTimed(Drivetrain dt) {
        addCommands(
                new DriveTimed(dt, 0.25, 10)
        );
    }
}
