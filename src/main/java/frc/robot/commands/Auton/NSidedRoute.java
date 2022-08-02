package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Drivetrain.DriveDistance;
import frc.robot.commands.Drivetrain.TurnToAngleProfiled;
import frc.robot.commands.Macros.TurnToAngle2;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shifter;

import java.util.ArrayList;
import java.util.List;

public class NSidedRoute extends SequentialCommandGroup {

    public NSidedRoute(Drivetrain dt, Shifter shifter,int n) {
        double turnAmount = 180 - (((n-2) * 180.0 ) / n);

        List<Command> commands = new ArrayList<>();

        for(int i = 0; i<n; i++) {
            commands.add(dt.getRamseteCommand("Straight-1m", true));
            commands.add(new TurnToAngleProfiled(dt, turnAmount));
        }

        Command[] array = new Command[commands.size()];
        for(int i = 0; i < commands.size(); i++) array[i] = commands.get(i);

        addCommands(array);
    }
}
