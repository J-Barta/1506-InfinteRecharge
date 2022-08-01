package frc.robot.utils;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Auton.Straight;

import java.util.HashMap;
import java.util.Map;

public class AutonomousLoader {
    Map<Route, Command> autoRoutes = new HashMap<>();

    private SendableChooser chooser;

    public AutonomousLoader(AllRobotSubsystems subsystems) {
        autoRoutes.put(Route.Straight, new Straight());

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
        Straight
    }
}
