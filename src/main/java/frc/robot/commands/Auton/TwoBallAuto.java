package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Drivetrain.TurnToAngleProfiled;
import frc.robot.commands.HorizIndexer.HorizIndex;
import frc.robot.commands.HorizIndexer.StopHorizIndexer;
import frc.robot.commands.Intake.ExtendAndIntake;
import frc.robot.commands.Intake.StopIntakeIntake;
import frc.robot.commands.Macros.TurnToAngleProfiled2;
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
            new Shoot(shooter, 6000),
            dt.getRamseteCommand("to-shoot-2-ball", true), 

            new WaitCommand(1),

            new HorizIndex(horizIndexer),
            new VertIndex(vertIndexer),

            new WaitCommand(2),

            new TurnToAngleProfiled(dt, 180).withTimeout(5),

            new StopVertIndexer(vertIndexer),
            new StopHorizIndexer(horizIndexer),

            new ExtendAndIntake(intake),
            
            dt.getRamseteCommand("to-ball-2-ball", false),
            dt.getRamseteCommand("back-to-shoot", false),

            new TurnToAngleProfiled(dt, 140).withTimeout(5),

            new HorizIndex(horizIndexer),
            new VertIndex(vertIndexer),

            new WaitCommand(2),

            new StopVertIndexer(vertIndexer),
            new StopIntakeIntake(intake)
        
        );
    }
    
    
}
