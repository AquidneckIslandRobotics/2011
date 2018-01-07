package org.usfirst.frc.team78.robot.subsystems;

import org.usfirst.frc.team78.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 *
 */
public class Arm extends Subsystem {
	
	public TalonSRX wrist = new TalonSRX(RobotMap.WRIST);
	public TalonSRX shoulder = new TalonSRX(RobotMap.SHOULDER);
	
	public AnalogInput shoulderPot = new AnalogInput(RobotMap.SHOULDER_POT);
	public AnalogInput wristPot = new AnalogInput(RobotMap.WRIST_POT);
	
	DoubleSolenoid handSolenoid = new DoubleSolenoid(RobotMap.HAND_SOLONOID_OPEN, RobotMap.HAND_SOLONOID_CLOSE);
	
    public void wristUp(){
    	wrist.set(ControlMode.PercentOutput, 0.78);    	
    }
    public void wristDown(){
    	wrist.set(ControlMode.PercentOutput, -0.78);    	
    }
    public void stopWrist(){
    	wrist.set(ControlMode.PercentOutput, 0);
    }
    
    public void shoulderUp(){
    	shoulder.set(ControlMode.PercentOutput, -0.5);
    }
    public void shoulderDown(){
    	shoulder.set(ControlMode.PercentOutput, 0.5);
    }
    public void stopShoulder(){
    	shoulder.set(ControlMode.PercentOutput, 0);
    }
    
    public void openHand(){
		handSolenoid.set(DoubleSolenoid.Value.kReverse);
	
	}
	
	public void closeHand(){
		handSolenoid.set(DoubleSolenoid.Value.kForward);
	
	}
    
	
	public double getShoulder(){
		return wristPot.getAverageVoltage();
		
	}
	
    public void initDefaultCommand() {
       
    }
}

