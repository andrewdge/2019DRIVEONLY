/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import org.opencv.core.Mat;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.cscore.VideoSink;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Subsystems.DriveSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  //Instantiate Subsystem
  public DriveSubsystem driveSubsystem = new DriveSubsystem(this);

  UsbCamera hdlifecam;
  UsbCamera hpcam;
  VideoSink server;
  boolean prevTrigger = false;
  public boolean toggle;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {

    Thread t = new Thread(() -> {
      
      CameraServer cs = CameraServer.getInstance();

      hdlifecam = cs.startAutomaticCapture("Front Cam", 0);
      hpcam = cs.startAutomaticCapture("Back Cam", 1);

      cs.addCamera(hdlifecam);
      //cs.addCamera(hpcam);

      server = cs.getServer();
      server.setSource(hdlifecam);

      //hdlifecam.setPixelFormat(PixelFormat kMJPEG);

      if (Controls.getCamTrigger()){
        toggle = true;
      }

      if (toggle){
        server.setSource(hpcam);

      } else{
        server.setSource(hdlifecam);
      }
      toggle = !toggle;


    });
    t.start();

    /*
    hdlifecam = CameraServer.getInstance().startAutomaticCapture("Front Cam",0); 
    //hdlifecam.setResolution(320, 240);

    hpcam = CameraServer.getInstance().startAutomaticCapture("Back Cam",1);
    //hpcam.setResolution(320, 240);

    server = CameraServer.getInstance().addServer("Switched Cam");
    hdlifecam.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
    hpcam.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);

    */
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    /*m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);*/
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

    /*
    if (Controls.getCamTrigger() && !prevTrigger){
      System.out.println("Setting Front Cam");
      server.setSource(hdlifecam);
    } else if(!Controls.getCamTrigger() && prevTrigger){
      System.out.println("Setting Back Cam");
      server.setSource(hpcam);
    }

    prevTrigger = Controls.getCamTrigger();

    */
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    Scheduler.getInstance().run();
  }
}
