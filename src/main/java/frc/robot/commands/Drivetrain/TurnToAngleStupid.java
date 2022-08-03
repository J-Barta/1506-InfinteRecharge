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

  private double allowedError = 0.5;

  public TurnToAngleStupid(Drivetrain dt, double angle) {
    this.dt = dt;
    this.turnAmount = angle;
  }

  @Override
  public void initialize() {
    this.startAngle = dt.getRawHeading();
    this.targetAngle = (turnAmount);
    dt.arcadeDrive(0, -0.5);
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    dt.arcadeDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    boolean val = Math.abs(dt.getRawHeading() - targetAngle) < allowedError;
    System.out.println(val);
    return val;
  }
}
