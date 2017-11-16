package org.usfirst.frc.team78.robot.subsystems;

import org.usfirst.frc.team78.robot.Robot;
import org.usfirst.frc.team78.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */


public class Chassis extends Subsystem {

	public CANTalon rightFront = new CANTalon(RobotMap.RIGHT_FRONT);
	public CANTalon rightBack = new CANTalon(RobotMap.RIGHT_BACK);
	public CANTalon leftFront = new CANTalon(RobotMap.LEFT_FRONT);
	public CANTalon leftBack = new CANTalon(RobotMap.LEFT_BACK);
	
	public void motorInit(){
		rightBack.changeControlMode(TalonControlMode.Follower);
		rightBack.set(rightFront.getDeviceID());
		rightFront.reverseOutput(true);
		leftBack.changeControlMode(TalonControlMode.Follower);
		leftBack.set(leftFront.getDeviceID());
		leftFront.reverseOutput(false);
		
	}

	public void driveWithJoysticks(){
		double left = Robot.oi.getDriverLeftStick(); //Multiply each by 0.45 and uncomment if statement for Granny Speed
    	double right = Robot.oi.getDriverRightStick();
    	
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	driveWithJoysticks();
    }
}