package org.usfirst.frc.team78.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team78.robot.commands.CloseHand;
import org.usfirst.frc.team78.robot.commands.ExampleCommand;
import org.usfirst.frc.team78.robot.commands.OpenHand;
import org.usfirst.frc.team78.robot.commands.ShoulderDown;
import org.usfirst.frc.team78.robot.commands.ShoulderUp;
import org.usfirst.frc.team78.robot.commands.StopShoulder;
import org.usfirst.frc.team78.robot.commands.WristDown;
import org.usfirst.frc.team78.robot.commands.WristUp;
import org.usfirst.frc.team78.robot.commands.StopWrist;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	final static double STICK_DEADZONE = 0.05;
	
	public Button driverA = new JoystickButton(driverStick, 2);
	public Button driverB = new JoystickButton(driverStick, 3);
	public Button driverLB = new JoystickButton(driverStick, 5);
	public Button driverLT = new JoystickButton(driverStick, 7);
	public Button driverRB = new JoystickButton(driverStick, 6);
	public Button driverRT = new JoystickButton(driverStick, 8);
	public static Joystick driverStick = new Joystick(0);
	
	public OI(){
	
		driverLB.whileHeld(new WristUp());
		driverLB.whenReleased(new StopWrist());
		driverLT.whileHeld(new WristDown());
		driverLT.whenReleased(new StopWrist());
		
		driverRB.whileHeld(new ShoulderUp());
		driverRB.whenReleased(new StopShoulder());
		driverRT.whileHeld(new ShoulderDown());
		driverRT.whenReleased(new StopShoulder());
		
		driverA.whenPressed(new OpenHand());
		driverB.whenPressed(new CloseHand());
	}
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
