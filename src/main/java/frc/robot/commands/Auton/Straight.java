package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Drivetrain.DriveDistance;
import frc.robot.subsystems.Drivetrain;

public class Straight extends SequentialCommandGroup {

    public Straight(Drivetrain dt) {
        addCommands(
                new PrintCommand("Started"),
                new DriveDistance(dt, 1)
        );
    }
}
