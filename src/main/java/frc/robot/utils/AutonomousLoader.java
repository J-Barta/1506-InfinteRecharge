package frc.robot.utils;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Auton.AllianceWallScoreHigh;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.commands.Auton.DriveAndCollect;
import frc.robot.commands.Auton.HangarAndBack;
import frc.robot.commands.Auton.HangarToHangar;
import frc.robot.commands.Auton.NSidedRoute;
import frc.robot.commands.Auton.Straight;
import frc.robot.commands.Auton.StraightReturn;
import frc.robot.commands.Auton.WallToLow;
import frc.robot.commands.Auton.TwoBallAuto;

import java.util.HashMap;
import java.util.Map;

public class AutonomousLoader {
    Map<Route, Command> autoRoutes = new HashMap<>();

    private SendableChooser chooser;

    public AutonomousLoader(AllRobotSubsystems subsystems, Map<String, Trajectory> paths) {
        autoRoutes.put(Route.Straight, new Straight(subsystems.drivetrain));
        autoRoutes.put(Route.StraightReturn, new StraightReturn(subsystems.drivetrain));
        autoRoutes.put(Route.Square, new NSidedRoute(subsystems.drivetrain, subsystems.shifter, 4));
        autoRoutes.put(Route.Pentagon, new NSidedRoute(subsystems.drivetrain, subsystems.shifter, 5));
        autoRoutes.put(Route.Octagon, new NSidedRoute(subsystems.drivetrain, subsystems.shifter, 8));
        autoRoutes.put(Route.HangarToHangar, new HangarToHangar(subsystems.drivetrain));
        autoRoutes.put(Route.HangarAndBack, new HangarAndBack(subsystems.drivetrain));
        autoRoutes.put(Route.DriveAndCollect, new DriveAndCollect(subsystems.drivetrain, subsystems.intake));
        autoRoutes.put(Route.WallToLow, new WallToLow(subsystems.drivetrain, subsystems.shooter, subsystems.vertIndexer, subsystems.horizIndexer));
        autoRoutes.put(Route.AllianceWallScoreHigh, new AllianceWallScoreHigh(subsystems.drivetrain, subsystems.shooter, subsystems.vertIndexer, subsystems.horizIndexer));
        autoRoutes.put(Route.TwoBallRoute, new TwoBallAuto(subsystems.drivetrain, subsystems.intake, subsystems.horizIndexer, subsystems.vertIndexer, subsystems.shooter));

        this.chooser = composeSendableChooser();
    }

    private SendableChooser composeSendableChooser() {
        SendableChooser chooser = new SendableChooser();
        for(Map.Entry<Route, Command> e : autoRoutes.entrySet()) {
            chooser.addOption(e.getKey().name(), e.getKey());
        }

        return chooser;
    }

    public SendableChooser getSendableChooser() {
        return chooser;
    }

    public Command getCurrentSelection() {
        return autoRoutes.get(chooser.getSelected());
    }

    public enum Route {
        Straight,
        StraightReturn,
        Square,
        Pentagon,
        Octagon,
        HangarToHangar,
        HangarAndBack,
        DriveAndCollect,
        WallToLow,
        AllianceWallScoreHigh,
        TwoBallRoute
    }
}
