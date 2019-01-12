package org.usfirst.frc3620.robot;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static DifferentialDrive driveSubsystemDifferentialDrive;
    public static Solenoid buttonPresser1;
    public static Solenoid buttonPresser2;
    
    public static Victor flagSpinner;

    public static Servo flipperServo;
    public static Relay wingRelay;
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
        //new code
        
        buttonPresser1 = new Solenoid(7);
        buttonPresser2 = new Solenoid(6);

        flipperServo = new Servo(9);
        wingRelay = new Relay(1);
        flagSpinner = new Victor(8);
        flagSpinner.setName("FlagSpinner", "RightA");
        flagSpinner.setInverted(false);
    }
}
