package frc.robot;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

public final class IO{
    private IO(){}

    //CAN
    public static final int motorDriveLeftTop = 1;
    public static final int motorDriveLeftBottom = 2;
    public static final int motorDriveRightTop = 3;
    public static final int motorDriveRightBottom = 4;
    
    

    //PWM
    
    

    //analog
    

    //digital
    public static final int limitSwitchElevatorBottom = 0;
    public static final int limitSwitchElevatorTop = 1;
    public static final int encoderDriveLeftA = 2;
    public static final int encoderDriveLeftB = 3;
    public static final int encoderDriveRightA = 4;
    public static final int encoderDriveRightB = 5;

    //USB
    public static final SerialPort.Port gyro = SerialPort.Port.kUSB;

}