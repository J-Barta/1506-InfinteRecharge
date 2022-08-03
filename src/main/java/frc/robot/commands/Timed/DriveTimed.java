package frc.robot.commands.Timed;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveTimed extends CommandBase {
    private double accelTimeSeconds;
    private Timer timer;
    private Drivetrain dt;
    private double pwr;
    private double totalSeconds;
    private State state;
    private double accelerationTime;
    private double currentPwr;

    public DriveTimed(Drivetrain dt, double pwr, double seconds, double accelTime) {
        timer = new Timer();
        this.accelTimeSeconds = accelTime;
        this.dt = dt;
        this.pwr = pwr;
        this.totalSeconds = seconds;

        this.accelerationTime = calculateAccelerationTime();

        addRequirements(dt);
    }

    public DriveTimed(Drivetrain dt, double pwr, double seconds) {
        this(dt, pwr, seconds, 0.5);
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
        dt.arcadeDrive(0, 0);
        state = State.Accelerating;
    }

    @Override
    public void execute() {
        if(state==State.Accelerating) {
            currentPwr = (timer.get() / accelerationTime) * pwr;
            if(timer.get() > accelerationTime) state = State.Steady;
        } else if(state == State.Decelerating) {
            double timeDecelerating = timer.get()-(totalSeconds - accelerationTime);
            currentPwr = pwr- ((timeDecelerating / accelerationTime) *pwr);
        } else {
            if(timer.get() > totalSeconds - accelerationTime) state =State.Decelerating;
        }

        dt.arcadeDrive(currentPwr, 0);
    }

    @Override
    public void end(boolean interrupted) {
        dt.arcadeDrive(0, 0);
        timer.stop();
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= totalSeconds;
    }

    private enum State {
        Accelerating,
        Steady,
        Decelerating
    }

    private double calculateAccelerationTime() {
        if(totalSeconds>=2) return accelTimeSeconds;
        else return totalSeconds/2.0;
    }



}
