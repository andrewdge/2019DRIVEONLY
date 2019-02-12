package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public final class Controls {
    //private constructor
    private Controls(){}

    // values are port #s
    // Joystick Axis
	private static final int JOYSTICK_AXIS_X = 0;
	private static final int JOYSTICK_AXIS_Y = 1;
	private static final int JOYSTICK_AXIS_Z = 2;
	
	// Joystick Buttons
	private static final int JOYSTICK_BUTTON_1 = 1;
	private static final int JOYSTICK_BUTTON_2 = 2;
	private static final int JOYSTICK_BUTTON_3 = 3;
	private static final int JOYSTICK_BUTTON_4 = 4;
	private static final int JOYSTICK_BUTTON_5 = 5;
	private static final int JOYSTICK_BUTTON_6 = 6;
	private static final int JOYSTICK_BUTTON_7 = 7;
	private static final int JOYSTICK_BUTTON_8 = 8;
	private static final int JOYSTICK_BUTTON_9 = 9;
	private static final int JOYSTICK_BUTTON_10 = 10;
	private static final int JOYSTICK_BUTTON_11 = 11;
	
	// Xbox Axis
	private static final int XBOX_AXIS_LTHUMB_X = 0;
	private static final int XBOX_AXIS_LTHUMB_Y = 1;
	private static final int XBOX_AXIS_LTRIGGER = 2;
	private static final int XBOX_AXIS_RTRIGGER = 3;
	private static final int XBOX_AXIS_RTHUMB_X = 4;
	private static final int XBOX_AXIS_RTHUMB_Y = 5;
	
	// Xbox Buttons
	private static final int XBOX_BUTTON_A = 1;
	private static final int XBOX_BUTTON_B = 2;
	private static final int XBOX_BUTTON_X = 3;
	private static final int XBOX_BUTTON_Y = 4;
	private static final int XBOX_BUTTON_LBUMPER = 5;
	private static final int XBOX_BUTTON_RBUMPER = 6;
	private static final int XBOX_BUTTON_BACK = 7;
	private static final int XBOX_BUTTON_START = 8;
	private static final int XBOX_BUTTON_LTHUMB = 9;
	private static final int XBOX_BUTTON_RTHUMB = 10;
	
	// Xbox POV
	private static final int XBOX_POV_CENTER = -1;
	private static final int XBOX_POV_UP = 0;
	private static final int XBOX_POV_UPRIGHT = 45;
	private static final int XBOX_POV_RIGHT = 90;
	private static final int XBOX_POV_DOWNRIGHT = 135;
	private static final int XBOX_POV_DOWN = 180;
	private static final int XBOX_POV_DOWNLEFT = 225;
	private static final int XBOX_POV_LEFT = 270;
	private static final int XBOX_POV_UPLEFT = 315;
	
	// 0 +- the number. this value will be ignored from values passed through the deadband method
    private final static double deadband = 0.1;

    //joysticks
    private static Joystick joystickDriveLeft = new Joystick(0);
    private static Joystick joystickDriveRight = new Joystick(1);
	private static Joystick xboxController = new Joystick(2);
	
	public static boolean getLeftCamTrigger(){
		return joystickDriveRight.getRawButton(JOYSTICK_BUTTON_1);
	}

	
	public static boolean getRightCamTrigger(){
		return joystickDriveLeft.getRawButton(JOYSTICK_BUTTON_1);
	}
	

	
    
    //deadband with a value of .15
    private static double deadband(double rawValue){
        if(Math.abs(rawValue) < .15) return 0.0;
        else return rawValue;
    }

    

    //Drive Controls
    //-joystick because joysticks are flightsticks, pushing forward goes backwards due to stick underneath
    public static double driveLeftThrottle(){
        return deadband(-joystickDriveLeft.getRawAxis(JOYSTICK_AXIS_Y));
    }

    public static double driveRightThrottle(){
        return deadband(-joystickDriveRight.getRawAxis(JOYSTICK_AXIS_Y));
    }

    /*
    //elevator controls
    public static double elevator(){
        return deadband(-xboxController.getRawAxis(XBOX_AXIS_LTHUMB_Y));
    }

    //gripper grip controls
    public static boolean gripperGripOpen(){
        return xboxController.getRawButton(XBOX_BUTTON_LBUMPER);
    }
    public static boolean gripperGripClose(){
        return xboxController.getRawButton(XBOX_BUTTON_RBUMPER);
    }

	//gripper rotate control
	public static double gripperRotatePositionControl(){
		return deadband(-xboxController.getRawAxis(XBOX_AXIS_RTHUMB_Y));
    }
    */

}