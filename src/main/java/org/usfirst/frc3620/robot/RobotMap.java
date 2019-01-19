package org.usfirst.frc3620.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

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
    public static Victor driveSubsystemMaxLeftA;
    public static Victor driveSubsystemMaxLeftB;
    public static Victor driveSubsystemMaxRightA;
    public static Victor driveSubsystemMaxRightB;
    public static Encoder driveLeftEncoder;
    public static Encoder driveRightEncoder;


    @SuppressWarnings("deprecation")
	public static void init() {

        driveLeftEncoder = new Encoder(6, 7, false, EncodingType.k4X);
        driveRightEncoder = new Encoder(6, 7, false, EncodingType.k4X);

        Victor driveSubsystemMaxLeftA = new Victor(0);
        driveSubsystemMaxLeftA.setInverted(false);

        Victor driveSubsystemMaxLeftB = new Victor(1);
        driveSubsystemMaxLeftB.setInverted(false);

        Victor driveSubsystemMaxRightA = new Victor(2);
        driveSubsystemMaxRightA.setInverted(false);

        Victor driveSubsystemMaxRightB = new Victor(3);
        driveSubsystemMaxRightB.setInverted(false);

        SpeedControllerGroup groupLeft = new SpeedControllerGroup(driveSubsystemMaxLeftA, driveSubsystemMaxLeftB);
        SpeedControllerGroup groupRight = new SpeedControllerGroup(driveSubsystemMaxRightA, driveSubsystemMaxRightB);

       
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
