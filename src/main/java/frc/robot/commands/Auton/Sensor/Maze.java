package frc.robot.commands.Auton.Sensor;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;

public class Maze extends SequentialCommandGroup{

    public Maze(Drivetrain dt) {
        addCommands(
            dt.getRamseteCommand("Maze", true)
        );
    }
    
}
