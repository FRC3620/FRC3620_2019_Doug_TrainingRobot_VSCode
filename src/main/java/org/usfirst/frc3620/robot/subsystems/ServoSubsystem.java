package org.usfirst.frc3620.robot.subsystems;

import org.usfirst.frc3620.robot.RobotMap;


import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ServoSubsystem extends Subsystem {


    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new DriveCommand());
    }

    @Override
    public void periodic() {
    // Put code here to be run every loop
    }
   

    /**
     * it tells to move the flipper finger up
     */
    public void moveFlipperFingerUp() {
        RobotMap.flipperServo.setAngle(0);
    }
    
    // the angel can olny move down 170 (not 180)
    public void moveFlipperFingerDown() {
        RobotMap.flipperServo.setAngle(170);    
    }
}