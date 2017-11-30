package org.usfirst.frc.team78.robot.subsystems;

import org.usfirst.frc.team78.robot.Robot;
import org.usfirst.frc.team78.robot.RobotMap;
import org.usfirst.frc.team78.robot.commands.DriveWithJoysticks;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */


public class Chassis extends Subsystem {

	public CANTalon rightFront = new CANTalon(RobotMap.RIGHT_FRONT);
	public CANTalon rightBack = new CANTalon(RobotMap.RIGHT_BACK);
	public CANTalon leftFront = new CANTalon(RobotMap.LEFT_FRONT);
	public CANTalon leftBack = new CANTalon(RobotMap.LEFT_BACK);
	
	public boolean shiftState;
	public boolean canShift = true;
	
	DoubleSolenoid shifter = new DoubleSolenoid(RobotMap.SHIFTER_SOLENOID_HIGH, RobotMap.SHIFTER_SOLENOID_LOW);
	
	public void motorInit(){
		rightBack.changeControlMode(TalonControlMode.Follower);
		rightBack.set(rightFront.getDeviceID());
		leftBack.changeControlMode(TalonControlMode.Follower);
		leftBack.set(leftFront.getDeviceID());
		
		setLowGear();
	}
	
	public void setSpeed(double left, double right){
		
		if(right < 0){
			right = (right*right) * -1;
		}else if(left < 0){
			left = (left * left) * -1;
		}else{
			right = right*right;
			left = left * left;
		} 
		
		rightFront.set(right);
    	leftFront.set(-left);	
    }

	public void driveWithJoysticks(){
		double left = Robot.oi.getDriverLeftStick(); //Multiply each by 0.45 and uncomment if statement for Granny Speed
    	double right = Robot.oi.getDriverRightStick();
    	setSpeed(left, right);
    	
	}
	
	public void stopAllDrive(){
    	setSpeed(0,0);
    }
	
	public void setHighGear() {
		shifter.set(DoubleSolenoid.Value.kReverse);
		shiftState = false;
	}
	
	public void setLowGear() {
		shifter.set(DoubleSolenoid.Value.kForward);
		shiftState = true;
	}
	
	public void toggleShift() {
		if(shiftState) {
			setHighGear();
		} else if (!shiftState) {
			setLowGear();
		}
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWithJoysticks());
    }
}