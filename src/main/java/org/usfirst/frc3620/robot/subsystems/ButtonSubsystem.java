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
    private final Solenoid buttonPresser1 = RobotMap.buttonPresser1;
    private final Solenoid buttonPresser2 = RobotMap.buttonPresser2;


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
        buttonPresser1.set(true);
        buttonPresser2.set(true);
    }

    public void buttonPresserIn() {
        buttonPresser1.set(false);
        buttonPresser2.set(false);
    }


}