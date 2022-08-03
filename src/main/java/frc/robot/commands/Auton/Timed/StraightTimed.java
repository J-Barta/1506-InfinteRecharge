package frc.robot.commands.Auton.Timed;

import java.time.Instant;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Timed.DriveTimed;
import frc.robot.subsystems.Drivetrain;

public class StraightTimed extends SequentialCommandGroup {

    public StraightTimed(Drivetrain dt) {
        addCommands(
                new DriveTimed(dt, 0.5 , 5)
                // new PrintCommand("STARTED GOING STRAIGHT"),
                // new InstantCommand(() -> dt.arcadeDrive(1, 0)),
                // new WaitCommand(2),
                // new PrintCommand("STOPPED GOING STRAIGHT"),
                // new InstantCommand(() -> dt.arcadeDrive(0, 0))
        );
    }
}
