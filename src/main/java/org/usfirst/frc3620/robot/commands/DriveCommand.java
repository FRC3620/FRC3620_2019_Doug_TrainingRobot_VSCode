package org.usfirst.frc3620.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.slf4j.Logger;
import org.usfirst.frc3620.logger.EventLogging;
import org.usfirst.frc3620.logger.EventLogging.Level;
import org.usfirst.frc3620.robot.Robot;

/**
 *
 */
public class DriveCommand extends Command {
	Logger logger = EventLogging.getLogger(getClass(), Level.INFO);
    public DriveCommand() {
        requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	EventLogging.commandMessage(logger);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        //gets values from Y-axis of Right stick on gamepad, X-axis goes unused
        double vertical = Robot.oi.getRightVerticalJoystickSquared();
        //gets values from X-axis of Left stick on gamepad, Y-axis goes unused
        double horizontal = Robot.oi.getLeftHorizontalJoystickSquared();
        //displays current values on gamepad
        //System.out.println("Vertical Right " + vertical + ": Horizontal Left" + horizontal);

        //Checks if proximity sensor sees an object within one foot. if it does, driving stops.
        if(Robot.driveSubsystem.isOneFootAway()) {
            //System.out.println("Object within one foot of robot");
            Robot.driveSubsystem.arcadeDrive(0, 0);
        } else{
        //Calls method to drive motors, declared in subsystem, sends real values to motors
        Robot.driveSubsystem.arcadeDrive(-vertical, horizontal);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        EventLogging.commandMessage(logger);
        //stops robot
        Robot.driveSubsystem.stopDrive();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run or when cancelled by whileHeld
    @Override
    protected void interrupted() {
        EventLogging.commandMessage(logger);
        //stops robot
        Robot.driveSubsystem.stopDrive();
    }
}