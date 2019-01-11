package org.usfirst.frc3620.robot.subsystems;

import org.usfirst.frc3620.robot.RobotMap;
import org.usfirst.frc3620.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class ButtonSubsystem extends Subsystem {
    private final Solenoid buttonPresser = RobotMap.buttonPresser;


    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
     //   setDefaultCommand();
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    }

    public void buttonPresserOut() {
        buttonPresser.set(true);
    }

    public void buttonPresserIn() {
        buttonPresser.set(false);
    }


}