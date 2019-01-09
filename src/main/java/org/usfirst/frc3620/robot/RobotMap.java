package org.usfirst.frc3620.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
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
    public static Victor driveSubsystemLeftSpeedController;
    public static Victor driveSubsystemRightSpeedController;
    public static DifferentialDrive driveSubsystemDifferentialDrive;

    @SuppressWarnings("deprecation")
	public static void init() {
        driveSubsystemLeftSpeedController = new Victor(0);
        driveSubsystemLeftSpeedController.setName("DriveSubsystem", "Left");
        driveSubsystemLeftSpeedController.setInverted(false);

        driveSubsystemRightSpeedController = new Victor(2);
        driveSubsystemRightSpeedController.setName("DriveSubsystem", "Right");
        driveSubsystemRightSpeedController.setInverted(false);

        driveSubsystemDifferentialDrive = new DifferentialDrive(driveSubsystemLeftSpeedController, driveSubsystemRightSpeedController);
        driveSubsystemDifferentialDrive.setName("DriveSubsystem", "Drive");
        driveSubsystemDifferentialDrive.setSafetyEnabled(true);
        driveSubsystemDifferentialDrive.setExpiration(0.1);
        driveSubsystemDifferentialDrive.setMaxOutput(1.0);

    }
}
