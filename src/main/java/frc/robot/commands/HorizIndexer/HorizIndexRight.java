package frc.robot.commands.HorizIndexer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HorizIndexer;

public class HorizIndexRight extends CommandBase {

    private final HorizIndexer m_horizIndexer;

    public HorizIndexRight(HorizIndexer horizIndexer) {
        m_horizIndexer = horizIndexer;
        addRequirements(m_horizIndexer);
    }

    @Override
    public void execute() {
        m_horizIndexer.right();
    }
}