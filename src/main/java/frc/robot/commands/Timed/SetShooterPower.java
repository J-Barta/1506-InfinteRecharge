// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Timed;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.Shooter.Shoot;
import frc.robot.subsystems.Shooter;

public class SetShooterPower extends CommandBase {
  private double pwr;
  private Shooter shooter;

  /** Creates a new SetShooterPower. */
  public SetShooterPower(Shooter shooter, double pwr) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooter = shooter;
    this.pwr = pwr;
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter.setPower(pwr);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
