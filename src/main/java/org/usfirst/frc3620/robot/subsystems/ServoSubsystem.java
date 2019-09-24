package org.usfirst.frc3620.robot.subsystems;

import org.usfirst.frc3620.robot.RobotMap;
import org.usfirst.frc3620.robot.commands.MoveFingerFromJoystickCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ServoSubsystem extends Subsystem {


    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new MoveFingerFromJoystickCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    }
    public void moveFlipperFingerUp() {
        RobotMap.flipperServo.setAngle(0);
    }
    public void moveFlipperFingerDown() {
        RobotMap.flipperServo.setAngle(170);    
    }

    public void moveFlipperFingerSomewhere(double where) {
        double degrees = 90 + (where * 45);
        RobotMap.flipperServo.setAngle(degrees);    
    }
}