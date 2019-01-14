package org.usfirst.frc3620.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc3620.misc.XBoxConstants;
import org.usfirst.frc3620.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    private Joystick driverJoystick;

    public OI() {
        // here we are initializing the joystick with index 0 (first xbox)
        driverJoystick = new Joystick(0);
        
        // when you press button A the finger moves 170 up
        Button moveFingerUp = new JoystickButton(driverJoystick, XBoxConstants.BUTTON_A);
        
        // when you press button B the finger moves to 0
        Button moveFingerDown = new JoystickButton(driverJoystick , XBoxConstants.BUTTON_B);
       
       // when you press A you move the new finger up
        moveFingerUp.whenPressed(new MoveFingerUp());
      
      // when you press A you move the new finger down
        moveFingerDown.whenPressed(new MoveFingerDown());

        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    }

    public Joystick getDriverJoystick() {
        return driverJoystick;
    }

    public double computeSquareWithDeadband (double position, double deadband) {
        if (Math.abs(position) < deadband) {
            return 0;
        }

    	double rv = position * position;
    	if(position < 0) {
    		rv = -rv;
    	}
    	return rv;
    }

    public double getLeftHorizontalJoystickSquared() {
    	return computeSquareWithDeadband(driverJoystick.getRawAxis(XBoxConstants.AXIS_LEFT_X), 0.2);
    }

    public double getRightVerticalJoystickSquared() {
    	return computeSquareWithDeadband(driverJoystick.getRawAxis(XBoxConstants.AXIS_RIGHT_Y), 0.2);
    }

}