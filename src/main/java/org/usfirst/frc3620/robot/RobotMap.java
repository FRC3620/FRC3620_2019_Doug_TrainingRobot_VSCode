package org.usfirst.frc3620.robot;

import org.slf4j.Logger;
import org.usfirst.frc3620.logger.EventLogging;
import org.usfirst.frc3620.logger.EventLogging.Level;
import org.usfirst.frc3620.misc.CANDeviceFinder;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

 /**
  * @author Nick Zimanski (SlippStream)
  * @version 1/25/19
  *
  * Added light subsystem functionality, initialized to PWM 9
  */
public class RobotMap {
    public static DifferentialDrive driveSubsystemDifferentialDrive;
    public static Solenoid buttonPresser1;
    public static Solenoid buttonPresser2;
    public static AnalogInput proximityAI;
    public static Victor flagSpinner;
    public static SpeedController lightSubsystemLightPWM;

    public static Servo flipperServo;
    public static Relay wingRelay;

    static Logger logger = EventLogging.getLogger(RobotMap.class, Level.INFO);

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

        lightSubsystemLightPWM = new Spark(5);
		LiveWindow.addActuator("LightSubsystem", "LightPWM", (Spark) lightSubsystemLightPWM);
		lightSubsystemLightPWM.setInverted(false);
       
        driveSubsystemDifferentialDrive = new DifferentialDrive(groupLeft, groupRight);
        driveSubsystemDifferentialDrive.setName("DriveSubsystem", "Drive");
        driveSubsystemDifferentialDrive.setSafetyEnabled(true);
        driveSubsystemDifferentialDrive.setExpiration(0.1);
        driveSubsystemDifferentialDrive.setMaxOutput(1.0);
        //new code

        CANDeviceFinder canDeviceFinder = new CANDeviceFinder();
        logger.info ("CANDEVICEfinder found {}", canDeviceFinder.getDeviceList());


        if (canDeviceFinder.isPCMPresent(0)) {
            buttonPresser1 = new Solenoid(7);
            buttonPresser2 = new Solenoid(6);
        }
        
        flipperServo = new Servo(9);
        wingRelay = new Relay(1);
        flagSpinner = new Victor(8);
        flagSpinner.setName("FlagSpinner", "RightA");
        flagSpinner.setInverted(false);
        //we put the proximity sensor on channel 0
        proximityAI = new AnalogInput(0);
    }


}
