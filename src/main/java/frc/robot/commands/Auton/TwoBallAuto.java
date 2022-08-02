package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.HorizIndexer.HorizIndex;
import frc.robot.commands.HorizIndexer.StopHorizIndexer;
import frc.robot.commands.Intake.ExtendAndIntake;
import frc.robot.commands.Intake.StopIntakeIntake;
import frc.robot.commands.Shooter.Shoot;
import frc.robot.commands.Shooter.StopShooter;
import frc.robot.commands.VertIndexer.StopVertIndexer;
import frc.robot.commands.VertIndexer.VertIndex;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.HorizIndexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.VertIndexer;

public class TwoBallAuto extends SequentialCommandGroup{

    public TwoBallAuto(Drivetrain dt, Intake intake, HorizIndexer horizIndexer, VertIndexer vertIndexer, Shooter shooter) {
        addCommands(
            new Shoot(shooter, 2000),

            new WaitCommand(2),

            new HorizIndex(horizIndexer),
            new VertIndex(vertIndexer),

            new WaitCommand(2),

            new ParallelCommandGroup(
                new SequentialCommandGroup(
                    new WaitCommand(2),

                    new ExtendAndIntake(intake),
                    new StopHorizIndexer(horizIndexer),
                    new StopVertIndexer(vertIndexer)
                ),

                dt.getRamseteCommand("Hub-to-ball-pickup", true)                        
            ),
            
            dt.getRamseteCommand("Ball-pickup-to-hub", false),
            new HorizIndex(horizIndexer),
            new VertIndex(vertIndexer),
            new WaitCommand(2),
            new StopVertIndexer(vertIndexer),
            new StopIntakeIntake(intake),
            new StopShooter(shooter)
        
        );
    }
    
    
}
