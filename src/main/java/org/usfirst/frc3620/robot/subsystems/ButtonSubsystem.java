package org.usfirst.frc3620.robot.subsystems;



import org.slf4j.Logger;
import org.usfirst.frc3620.logger.EventLogging;
import org.usfirst.frc3620.logger.EventLogging.Level;
import org.usfirst.frc3620.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class ButtonSubsystem extends Subsystem {
    Logger logger = EventLogging.getLogger(getClass(), Level.INFO);
    
    private final Solenoid buttonPresser1 = RobotMap.buttonPresser1;
    private final Solenoid buttonPresser2 = RobotMap.buttonPresser2;


    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
     //   setDefaultCommand();
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    }

    public void buttonPresserOut() {
        if (buttonPresser1 != null) {
            buttonPresser1.set(true);
            buttonPresser2.set(true);
        } else {
            logger.info ("no PCM, but buttonbPressorOut");
        }
    }

    public void buttonPresserIn() {
        if (buttonPresser1 != null) {
            buttonPresser1.set(false);
            buttonPresser2.set(false);
        } else {
            logger.info ("no PCM, but buttonbPressorOut");
        }

    }


}