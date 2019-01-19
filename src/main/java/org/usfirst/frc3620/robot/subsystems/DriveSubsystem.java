package org.usfirst.frc3620.robot.subsystems;

import org.usfirst.frc3620.robot.RobotMap;
import org.usfirst.frc3620.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveSubsystem extends Subsystem {

    private final DifferentialDrive differentialDrive = RobotMap.driveSubsystemDifferentialDrive;
    public static Encoder driveLeftEncoder = RobotMap.driveLeftEncoder;
    public static Encoder driveRightEncoder = RobotMap.driveRightEncoder;
    public double distancePerPulse = 0.0123;
    public double kickVelocityInInchesperSecond = 12;
    public double lateralShootingRange = 3;


    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here. Drive command runs in background at all times
        setDefaultCommand(new DriveCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    /**
     * drive the robot. positive Y is forward, positive X is to the right
     */
    public double getLeftEncoderVelocity(){
        driveLeftEncoder.setDistancePerPulse(distancePerPulse);
        return driveLeftEncoder.getRate();
    }

    public double getRightEncoderVelocity(){
        driveRightEncoder.setDistancePerPulse(distancePerPulse);
        return driveRightEncoder.getRate();
    }

    public double getDesiredLaunchDistance(){
        return (lateralShootingRange/kickVelocityInInchesperSecond)
        *((getLeftEncoderVelocity() + getRightEncoderVelocity())/2);
    }

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
}