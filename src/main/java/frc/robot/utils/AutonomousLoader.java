package frc.robot.utils;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Auton.Sensor.AllianceWallScoreHigh;
import frc.robot.commands.Auton.Sensor.DriveAndCollect;
import frc.robot.commands.Auton.Sensor.HangarAndBack;
import frc.robot.commands.Auton.Sensor.HangarScore;
import frc.robot.commands.Auton.Sensor.HangarToHangar;
import frc.robot.commands.Auton.Old.NSidedRoute;
import frc.robot.commands.Auton.Old.ScoreHighRoute;
import frc.robot.commands.Auton.Sensor.ScoreLowRoute;
import frc.robot.commands.Auton.Sensor.Straight;
import frc.robot.commands.Auton.Sensor.StraightReturn;
import frc.robot.commands.Auton.Sensor.WallToLow;
import frc.robot.commands.Auton.Sensor.TwoBallAuto;
import frc.robot.commands.Auton.Timed.StraightTimed;

import java.util.HashMap;
import java.util.Map;

public class AutonomousLoader {
    Map<Route, Command> autoRoutes = new HashMap<>();

    private SendableChooser chooser;

    public AutonomousLoader(AllRobotSubsystems s, Map<String, Trajectory> paths) {

        //Sensor routes
        autoRoutes.put(Route.SensorStraight, new Straight(s.drivetrain));
        autoRoutes.put(Route.SensorStraightReturn, new StraightReturn(s.drivetrain));
        autoRoutes.put(Route.SensorSquare, new NSidedRoute(s.drivetrain, s.shifter, 4));
        autoRoutes.put(Route.SensorPentagon, new NSidedRoute(s.drivetrain, s.shifter, 5));
        autoRoutes.put(Route.SensorOctagon, new NSidedRoute(s.drivetrain, s.shifter, 8));
        autoRoutes.put(Route.SensorHangarToHangar, new HangarToHangar(s.drivetrain));
        autoRoutes.put(Route.SensorHangarAndBack, new HangarAndBack(s.drivetrain));
        autoRoutes.put(Route.SensorDriveAndCollect, new DriveAndCollect(s.drivetrain, s.intake));
        autoRoutes.put(Route.SensorWallToLow, new WallToLow(s.drivetrain, s.shooter, s.vertIndexer, s.horizIndexer));
        autoRoutes.put(Route.SensorAllianceWallScoreHigh, new AllianceWallScoreHigh(s.drivetrain, s.shooter, s.vertIndexer, s.horizIndexer));
        autoRoutes.put(Route.SensorTwoBallRoute, new TwoBallAuto(s.drivetrain, s.intake, s.horizIndexer, s.vertIndexer, s.shooter));
        autoRoutes.put(Route.SensorHangarScore, new HangarScore(s.drivetrain, s.shooter, s.vertIndexer, s.horizIndexer, s.intake));
        autoRoutes.put(Route.SensorScoreLow, new ScoreLowRoute(s.shooter, s.vertIndexer, s.horizIndexer));
        autoRoutes.put(Route.SensorScoreHigh, new ScoreHighRoute(s.shooter, s.vertIndexer, s.horizIndexer));

        //Timed routes
        autoRoutes.put(Route.TimedStraight, new StraightTimed(s.drivetrain));

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
        SensorStraight,
        SensorStraightReturn,
        SensorSquare,
        SensorPentagon,
        SensorOctagon,
        SensorHangarToHangar,
        SensorHangarAndBack,
        SensorDriveAndCollect,
        SensorWallToLow,
        SensorAllianceWallScoreHigh,
        SensorTwoBallRoute,
        SensorHangarScore,
        SensorScoreLow,
        SensorScoreHigh,
        TimedStraight

    }
}
