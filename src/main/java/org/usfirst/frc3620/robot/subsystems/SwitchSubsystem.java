package org.usfirst.frc3620.robot.subsystems;

import java.awt.Robot;

import org.usfirst.frc3620.robot.RobotMap;
import org.usfirst.frc3620.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class SwitchSubsystem extends Subsystem {
    

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
     //   setDefaultCommand();
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    }
    //Flips Switch Up
    public void MoveFlipperFingerUp() {
        RobotMap.switchFlipper.setAngle(0);
    }
    //flips Switch Down
    /*
    
    */
    public void MoveFlipperFingerDown() {
        RobotMap.switchFlipper.setAngle(170);
    }



}