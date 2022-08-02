// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TurnToAngleStupid extends CommandBase {
  private Drivetrain dt;
  private double turnAmount;
  private double targetAngle;
  private double startAngle;

  private double allowedError = 2;

  public TurnToAngleStupid(Drivetrain dt, double angle) {
    this.dt = dt;
    this.turnAmount = angle;
  }

  @Override
  public void initialize() {
    this.startAngle = dt.getHeading();
    this.targetAngle = (startAngle + turnAmount) % 360;
    dt.arcadeDrive(0, 0.25);
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    dt.arcadeDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return Math.abs(dt.getHeading() - targetAngle) < allowedError || dt.getHeading() - startAngle < -2;
  }
}
