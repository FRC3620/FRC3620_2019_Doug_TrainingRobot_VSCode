package org.usfirst.frc3620.robot.subsystems;


import org.usfirst.frc3620.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class WingSubsystem extends Subsystem {
    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
     //   setDefaultCommand();
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    }

    public void flapUp() {
        RobotMap.wingRelay.set(RobotMap.wingRelay.get().kOn);
    }

    public void flapStop() {
        RobotMap.wingRelay.set(RobotMap.wingRelay.get().kOff);
    }
}