package org.usfirst.frc3620.robot.subsystems;

import org.usfirst.frc3620.robot.RobotMap;
import org.usfirst.frc3620.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveSubsystem extends Subsystem {

    private final DifferentialDrive differentialDrive = RobotMap.driveSubsystemDifferentialDrive;
    private static int proximityAI;// = RobotMap.proximityAI.getAverageValue();
    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here. Drive command runs in background at all times
        setDefaultCommand(new DriveCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
        if(RobotMap.proximityAI != null) {
        proximityAI = RobotMap.proximityAI.getAverageValue();
        SmartDashboard.putNumber ("proxomityAI", proximityAI);
        }
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    /**
     * drive the robot. positive Y is forward, positive X is to the right
     */

    public void arcadeDrive (double y, double x) {
        //sends values to motor
        //!!! Make sure robot is in open area, drive carefully
        differentialDrive.arcadeDrive(y, x);
    }
    
    /**
     * shut down the robot.
     */
    public void stopDrive() {
        //stops robot
        differentialDrive.stopMotor();
    }

    public boolean isOneFootAway() {
        if(RobotMap.proximityAI != null) {
        proximityAI = RobotMap.proximityAI.getAverageValue();
        //1600 is aprox. 1 foot. the closer an object is the GREATER the value, until an object is ~3 in. away.
        return(proximityAI>1600);
        } else {
        return(false);
        }
    }
}