package org.usfirst.frc3620.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static DifferentialDrive driveSubsystemDifferentialDrive;
    public static Servo flipperServo;
    @SuppressWarnings("deprecation")
	public static void init() {
        Victor driveSubsystemLeftSpeedControllerA = new Victor(0);
        driveSubsystemLeftSpeedControllerA.setName("DriveSubsystem", "LeftA");
        driveSubsystemLeftSpeedControllerA.setInverted(false);

        Victor driveSubsystemLeftSpeedControllerB = new Victor(1);
        driveSubsystemLeftSpeedControllerB.setName("DriveSubsystem", "LeftB");
        driveSubsystemLeftSpeedControllerB.setInverted(false);

        Victor driveSubsystemRightSpeedControllerA = new Victor(2);
        driveSubsystemRightSpeedControllerA.setName("DriveSubsystem", "RightA");
        driveSubsystemRightSpeedControllerA.setInverted(false);

        Victor driveSubsystemRightSpeedControllerB = new Victor(3);
        driveSubsystemRightSpeedControllerB.setName("DriveSubsystem", "RightB");
        driveSubsystemRightSpeedControllerB.setInverted(false);

        SpeedControllerGroup groupLeft = new SpeedControllerGroup(driveSubsystemLeftSpeedControllerA, driveSubsystemLeftSpeedControllerB);
        SpeedControllerGroup groupRight = new SpeedControllerGroup(driveSubsystemRightSpeedControllerA, driveSubsystemRightSpeedControllerB);

        driveSubsystemDifferentialDrive = new DifferentialDrive(groupLeft, groupRight);
        driveSubsystemDifferentialDrive.setName("DriveSubsystem", "Drive");
        driveSubsystemDifferentialDrive.setSafetyEnabled(true);
        driveSubsystemDifferentialDrive.setExpiration(0.1);
        driveSubsystemDifferentialDrive.setMaxOutput(1.0);
        /** 
        *tells where the servo was pluged in
       */
        flipperServo = new Servo(9);
       


    }
}
