package org.usfirst.frc.team78.robot.subsystems;

import org.usfirst.frc.team78.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	
	public CANTalon wrist = new CANTalon(RobotMap.WRIST);
	public CANTalon shoulder = new CANTalon(RobotMap.SHOULDER);
	
	DoubleSolenoid handSolenoid = new DoubleSolenoid(RobotMap.HAND_SOLONOID_OPEN, RobotMap.HAND_SOLONOID_CLOSE);
	
    public void wristUp(){
    	wrist.set(0.78);    	
    }
    public void wristDown(){
    	wrist.set(-0.78);    	
    }
    public void stopWrist(){
    	wrist.set(0);
    }
    
    public void shoulderUp(){
    	shoulder.set(-0.5);
    }
    public void shoulderDown(){
    	shoulder.set(0.5);
    }
    public void stopShoulder(){
    	shoulder.set(0);
    }
    
    public void openHand(){
		handSolenoid.set(DoubleSolenoid.Value.kReverse);
	
	}
	
	public void closeHand(){
		handSolenoid.set(DoubleSolenoid.Value.kForward);
	
	}
    
    public void initDefaultCommand() {
       
    }
}

