package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Controls;
import frc.robot.Robot;

public class DefaultDriveCommand extends Command{
  //reference to main robot object(robot.java)
  private Robot robot;

  //constructor
  public DefaultDriveCommand(){}

  public DefaultDriveCommand(Robot robotInstance){
    robot = robotInstance;
    requires(robot.driveSubsystem);
  }

  protected void execute(){
    if(robot.isOperatorControl()){ // only drive with joysticks on teleop mode

      robot.driveSubsystem.tankDrive(Controls.driveLeftThrottle(), Controls.driveRightThrottle());

    }else robot.driveSubsystem.stopMotors();
    
  }

  protected boolean isFinished(){
    return false;
  }
}