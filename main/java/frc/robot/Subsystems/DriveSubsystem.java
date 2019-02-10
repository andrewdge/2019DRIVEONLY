package frc.robot.Subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.IO;
import frc.robot.Robot;
import frc.robot.Commands.DefaultDriveCommand;



public class DriveSubsystem extends Subsystem {
  private Robot robot;

  //constructor
  public DriveSubsystem(){}

  public DriveSubsystem(Robot robotInstance){
    robot = robotInstance;
  }

  
  public void initDefaultCommand() {
    setDefaultCommand(new DefaultDriveCommand(robot));
  }

  //Instantiate IO 
  
  
  
  private final WPI_VictorSPX leftSlave = new WPI_VictorSPX(IO.motorDriveLeftTop);
  private final WPI_VictorSPX leftMaster = new WPI_VictorSPX(IO.motorDriveLeftBottom);
  private final WPI_VictorSPX rightSlave = new WPI_VictorSPX(IO.motorDriveRightTop);
  private final WPI_VictorSPX rightMaster = new WPI_VictorSPX(IO.motorDriveRightBottom);

  SpeedControllerGroup left = new SpeedControllerGroup(leftMaster, leftSlave);
  SpeedControllerGroup right = new SpeedControllerGroup(rightMaster, rightSlave);
  
  
  DifferentialDrive drive = new DifferentialDrive(left, right);

  

  //drive motors using left and right speeds
  public void tankDrive(double leftSpeed, double rightSpeed){
    drive.tankDrive(leftSpeed, rightSpeed);
  }

  //stop motors
  public void stopMotors(){
    drive.stopMotor();
  }

}
