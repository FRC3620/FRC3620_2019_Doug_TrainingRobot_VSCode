// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3620.robot;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveSubsystemLeftSpeedController;
    public static SpeedController driveSubsystemRightSpeedController;
    public static DifferentialDrive driveSubsystemDifferentialDrive;
    public static AnalogInput laserCannonSubsystemAnalogInput0;
    public static DigitalInput laserCannonSubsystemDigitalInput0;
    public static SpeedController laserCannonSubsystemSpeedController2;
    public static Servo laserCannonSubsystemServo9;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    @SuppressWarnings("deprecation")
	public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveSubsystemLeftSpeedController = new Victor(0);
        LiveWindow.addActuator("DriveSubsystem", "Left Speed Controller", (Victor) driveSubsystemLeftSpeedController);
        driveSubsystemLeftSpeedController.setInverted(false);
        driveSubsystemRightSpeedController = new Victor(1);
        LiveWindow.addActuator("DriveSubsystem", "Right Speed Controller", (Victor) driveSubsystemRightSpeedController);
        driveSubsystemRightSpeedController.setInverted(false);
        driveSubsystemDifferentialDrive = new DifferentialDrive(driveSubsystemLeftSpeedController, driveSubsystemRightSpeedController);
        LiveWindow.addActuator("DriveSubsystem", "Differential Drive", driveSubsystemDifferentialDrive);
        driveSubsystemDifferentialDrive.setSafetyEnabled(true);
        driveSubsystemDifferentialDrive.setExpiration(0.1);
        driveSubsystemDifferentialDrive.setMaxOutput(1.0);

        laserCannonSubsystemAnalogInput0 = new AnalogInput(0);
        LiveWindow.addSensor("LaserCannonSubsystem", "Analog Input 0", laserCannonSubsystemAnalogInput0);
        
        laserCannonSubsystemDigitalInput0 = new DigitalInput(0);
        LiveWindow.addSensor("LaserCannonSubsystem", "Digital Input 0", laserCannonSubsystemDigitalInput0);
        
        laserCannonSubsystemSpeedController2 = new Victor(2);
        LiveWindow.addActuator("LaserCannonSubsystem", "Speed Controller 2", (Victor) laserCannonSubsystemSpeedController2);
        laserCannonSubsystemSpeedController2.setInverted(false);
        laserCannonSubsystemServo9 = new Servo(9);
        LiveWindow.addActuator("LaserCannonSubsystem", "Servo 9", laserCannonSubsystemServo9);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
