/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Classes;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Controls;

/**
 * Add your docs here.
 */
public class Cameras {

  UsbCamera frontcam;
  UsbCamera backcam;
  VideoSink server;
  boolean prevTrigger = false;
  public boolean toggle;

  public Cameras(){
      // create camera server
    CameraServer cs = CameraServer.getInstance();

    // create usb cameras
    frontcam = cs.startAutomaticCapture("frontcam", 0);
    backcam = cs.startAutomaticCapture("backcam", 1);

    // add cameras to server
    cs.addCamera(frontcam);
    cs.addCamera(backcam);

    // settings for cam 0
    frontcam.setResolution(320, 240);
    frontcam.setFPS(15);

    // settings for cam 1
    backcam.setResolution(320, 240);
    backcam.setFPS(15);

    // start with cam 0
    server = cs.getServer();
    server.setSource(frontcam);
  }

  public void detectToggle(){
      if(Controls.getCamTrigger()){
          toggle = !toggle;
      }
  }

  public void toggleCamera() {
    if (toggle) {
      server.setSource(frontcam);
      SmartDashboard.putString("Camera", "FRONT");
    } else {
      server.setSource(backcam);
      SmartDashboard.putString("Camera", "BACK");
    }
    toggle = !toggle;
  }
    
}
