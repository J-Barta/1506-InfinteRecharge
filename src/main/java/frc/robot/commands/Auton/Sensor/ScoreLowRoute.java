package frc.robot.commands.Auton.Sensor;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.HorizIndexer.HorizIndex;
import frc.robot.commands.Shooter.Shoot;
import frc.robot.commands.VertIndexer.VertIndex;
import frc.robot.subsystems.HorizIndexer;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.VertIndexer;

public class ScoreLowRoute extends SequentialCommandGroup{

    public ScoreLowRoute(Shooter shooter, VertIndexer vertIndexer, HorizIndexer horizIndexer) {
        addCommands(
            new Shoot(shooter, 6000),
            new WaitCommand(2),
            new VertIndex(vertIndexer),
            new HorizIndex(horizIndexer)
        );
    }

    
}
