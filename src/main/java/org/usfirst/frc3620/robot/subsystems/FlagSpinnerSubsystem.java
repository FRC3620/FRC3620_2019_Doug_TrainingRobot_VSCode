package org.usfirst.frc3620.robot.subsystems;

import org.usfirst.frc3620.robot.RobotMap;
import org.usfirst.frc3620.robot.commands.DriveCommand;
import org.usfirst.frc3620.robot.commands.SpinFlagCommand;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class FlagSpinnerSubsystem extends Subsystem {

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new SpinFlagCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    }

    public void spinFlag(double flagspeed){
        RobotMap.flagSpinner.set(flagspeed);
    
    }
    

}