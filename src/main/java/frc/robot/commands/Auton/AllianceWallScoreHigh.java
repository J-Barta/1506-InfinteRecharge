// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.HorizIndexer.HorizIndex;
import frc.robot.commands.HorizIndexer.StopHorizIndexer;
import frc.robot.commands.Shooter.Shoot;
import frc.robot.commands.Shooter.StopShooter;
import frc.robot.commands.VertIndexer.StopVertIndexer;
import frc.robot.commands.VertIndexer.VertIndex;
import frc.robot.commands.VertIndexer.VertIndexRev;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.HorizIndexer;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.VertIndexer;
import frc.robot.utils.AllRobotSubsystems;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AllianceWallScoreHigh extends SequentialCommandGroup {
  /** Creates a new AllianceWallScoreHigh. */
  public AllianceWallScoreHigh(Drivetrain dt, Shooter shooter, VertIndexer vertIndexer, HorizIndexer horizIndexer ) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new Shoot(shooter, 10000.0),
      dt.getRamseteCommand("AllianceWallScoreHigh", true).andThen(new InstantCommand(() -> dt.arcadeDrive(0, 0))), 
      new WaitCommand(3),
      new VertIndex(vertIndexer),
      new HorizIndex(horizIndexer),
      new WaitCommand(5),
      new StopHorizIndexer(horizIndexer),
      new StopVertIndexer(vertIndexer),
      new StopShooter(shooter)

      
    );
  }
}
