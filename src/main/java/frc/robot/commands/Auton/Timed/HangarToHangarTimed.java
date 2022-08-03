// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auton.Timed;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.HorizIndexer.HorizIndex;
import frc.robot.commands.HorizIndexer.StopHorizIndexer;
import frc.robot.commands.Intake.ExtendAndIntake;
import frc.robot.commands.Intake.StopIntakeIntake;
import frc.robot.commands.Timed.DriveTimed;
import frc.robot.commands.Timed.SetShooterPower;
import frc.robot.commands.Timed.TurnTimed;
import frc.robot.commands.VertIndexer.StopVertIndexer;
import frc.robot.commands.VertIndexer.VertIndex;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.HorizIndexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.VertIndexer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class HangarToHangarTimed extends SequentialCommandGroup {
  /** Creates a new HangarToHangarTimed. */
  public HangarToHangarTimed(Drivetrain dt, Shooter shooter, VertIndexer vertIndexer, HorizIndexer horizIndexer, Intake intake) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new ExtendAndIntake(intake),
      new DriveTimed(dt, 0.65, 10, 1),
      new StopIntakeIntake(intake),
      new SetShooterPower(shooter, 0.5),
      new TurnTimed(dt, 0.5, 1.5),
      new VertIndex(vertIndexer),
      new HorizIndex(horizIndexer),
      new WaitCommand(2),
      new StopHorizIndexer(horizIndexer),
      new StopVertIndexer(vertIndexer),
      new DriveTimed(dt, 0.65, 10)
    );
  }
}
