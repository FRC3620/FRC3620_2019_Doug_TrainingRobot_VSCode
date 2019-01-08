package org.usfirst.frc3620.robot.subsystems;

import org.usfirst.frc3620.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 */
public class LaserCannonSubsystem extends Subsystem {
    private final AnalogInput analogInput0 = RobotMap.laserCannonSubsystemAnalogInput0;
    private final DigitalInput digitalInput0 = RobotMap.laserCannonSubsystemDigitalInput0;
    private final SpeedController speedController2 = RobotMap.laserCannonSubsystemSpeedController2;
    private final Servo servo9 = RobotMap.laserCannonSubsystemServo9;

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}