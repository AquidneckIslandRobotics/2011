package org.usfirst.frc.team78.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

import org.usfirst.frc.team78.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	final static double STICK_DEADZONE = 0.05;
	
	public static Joystick driverStick = new Joystick(0);
	
	public double getDriverLeftStick(){
		double stick = driverStick.getY();
		if(Math.abs(stick) < STICK_DEADZONE) return 0;
		else return -stick;
	}
	
	public double getDriverRightStick() {
		double stick = driverStick.getThrottle();
		if (Math.abs(stick) < STICK_DEADZONE) return 0;
		else return -stick;
	}
	
}
