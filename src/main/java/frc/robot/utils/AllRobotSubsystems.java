package frc.robot.utils;

import frc.robot.subsystems.*;

public class AllRobotSubsystems {
    Drivetrain drivetrain;
    HorizIndexer horizIndexer;
    Intake intake;
    Shifter shifter;
    Shooter shooter;
    VertIndexer vertIndexer;

    public AllRobotSubsystems(Drivetrain drivetrain, HorizIndexer horizIndexer, Intake intake, Shifter shifter, Shooter shooter, VertIndexer vertIndexer) {
        this.drivetrain = drivetrain;
        this.horizIndexer = horizIndexer;
        this.intake = intake;
        this.shifter = shifter;
        this.shooter = shooter;
        this.vertIndexer = vertIndexer;
    }
}
