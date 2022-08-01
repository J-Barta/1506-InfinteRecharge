package frc.robot.commands.Climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class SetClimbingHeight extends CommandBase {

    private final Climber m_climber;

    public SetClimbingHeight(Climber climber) {
        m_climber = climber;
        addRequirements(m_climber);
    }

    @Override
    public void execute() {
        m_climber.setClimbing();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}