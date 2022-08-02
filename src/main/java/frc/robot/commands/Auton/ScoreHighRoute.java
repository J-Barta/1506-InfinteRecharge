package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.HorizIndexer.HorizIndex;
import frc.robot.commands.Shooter.Shoot;
import frc.robot.commands.VertIndexer.VertIndex;
import frc.robot.subsystems.HorizIndexer;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.VertIndexer;

public class ScoreHighRoute extends SequentialCommandGroup{

    public ScoreHighRoute(Shooter shooter, VertIndexer vertIndexer, HorizIndexer horizIndexer) {
        addCommands(
            new Shoot(shooter, 10000),
            new WaitCommand(5),
            new VertIndex(vertIndexer),
            new HorizIndex(horizIndexer)
        );
    }

    
}
