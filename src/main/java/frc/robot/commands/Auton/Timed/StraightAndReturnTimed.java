package frc.robot.commands.Auton.Timed;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Timed.DriveTimed;
import frc.robot.commands.Timed.TurnTimed;
import frc.robot.subsystems.Drivetrain;

public class StraightAndReturnTimed extends SequentialCommandGroup {

    public StraightAndReturnTimed(Drivetrain dt) {
        addCommands(
                new DriveTimed(dt, 0.5, 5),
                new TurnTimed(dt, 0.5, 4.25),
                new DriveTimed(dt, 0.5, 5)
        );
    }
}
