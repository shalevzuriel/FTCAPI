package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BHI260IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

public class BotHardware {


    private static BotHardware instance;
    private LinearOpMode myOpMode = null;   // gain access to methods in the calling OpMode.

    // Define Motor and Servo objects  (Make them private so they can't be accessed externally)
    private DcMotor leftRearDrive = null;
    private DcMotor rightRearDrive  = null;
    private DcMotor leftFrontDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor armMotor = null;

    private DcMotor pixelEntranceMotor = null;

    // Define Sensors. Notice they are REVROBOTICS sensors.
    private Rev2mDistanceSensor mDistanceSensor = null;
    private RevColorSensorV3 colorSensor = null;
    private RevTouchSensor touchSensor =null;
    private IMU imu;


    // Define a constructor that allows the OpMode to pass a reference to itself.
    private BotHardware() {
    }


    /**
    * method to create/get the singleton instance of BotHardware.
    * if the instance wasn't constructed- a new one will be constructed using the private constructor and then returned.
    * if there is an instance - the method will only return the existing instance.
    * @return the BotHardware singleton instance.
    */
    public static BotHardware getInstance() {
        // create the instance only if it's null
        if (instance == null) {
            instance = new BotHardware();
        }
        return instance;
    }

    /**
     * Initialize all the robot's hardware.
     * This method must be called ONCE when the OpMode is initialized.
     * <p>
     * All of the hardware devices are accessed via the hardware map, and initialized.
     */
    public void init(LinearOpMode myOpMode)    {

        // Define and Initialize Motors (note: need to use reference to actual OpMode).
        leftRearDrive = myOpMode.hardwareMap.get(DcMotor.class, "left_drive_rear"); //port 1
        rightRearDrive = myOpMode.hardwareMap.get(DcMotor.class, "right_drive_rear"); //port 3
        leftFrontDrive = myOpMode.hardwareMap.get(DcMotor.class, "left_drive_front"); //port 0
        rightFrontDrive = myOpMode.hardwareMap.get(DcMotor.class, "right_drive_front"); //port 2

        pixelEntranceMotor = myOpMode.hardwareMap.get(DcMotor.class, "pixel_entrance");
        armMotor = myOpMode.hardwareMap.get(DcMotor.class, "arm_motor");
        //define and Initialize Sensors

        mDistanceSensor = myOpMode.hardwareMap.get(Rev2mDistanceSensor.class, "distance_sensor");
        colorSensor = myOpMode.hardwareMap.get(RevColorSensorV3.class, "color_sensor");
        touchSensor = myOpMode.hardwareMap.get(RevTouchSensor.class, "touch_sensor");

        //setting the logo facing directions as back and the usb facing directions as left (just as it is connected to the robot).
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.BACKWARD;
        RevHubOrientationOnRobot.UsbFacingDirection  usbDirection  = RevHubOrientationOnRobot.UsbFacingDirection.LEFT;
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);

        // Now initialize the IMU with this mounting orientation
        // This sample expects the IMU to be in a REV Hub and named "imu".
        imu = myOpMode.hardwareMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(orientationOnRobot));
        imu.resetYaw();

        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        leftRearDrive.setDirection(DcMotor.Direction.REVERSE);
        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);

        // If there are encoders connected, switch to RUN_USING_ENCODER mode for greater accuracy
        // leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Define and initialize ALL installed servos.

        myOpMode.telemetry.addData(">", "Hardware Initialized");
        myOpMode.telemetry.update();
    }

    /**
     *  Pass the requested wheel motor powers to the appropriate hardware drive motors.
     * @param leftRearWheel left rear wheel power
     * @param rightRearWheel right rear wheel power
     * @param rightFrontWheel right front wheel power
     * @param leftFrontWheel left front wheel power
     */
    public void setDrivePower(double leftRearWheel, double rightRearWheel, double rightFrontWheel, double leftFrontWheel) {
        // Output the values to the motor drives.
        leftRearDrive.setPower(leftRearWheel);
        rightRearDrive.setPower(rightRearWheel);
        leftFrontDrive.setPower(leftFrontWheel);
        rightFrontDrive.setPower(rightFrontWheel);
    }


    /**
    * Method to set power for the arm motor
    * @param armPower the power value for the arm motor. value between -1 and 1.
    */
    public void setArmPower(double armPower)
    {
        armMotor.setPower(armPower);
    }

    //Getter methods for sensors

    /**
    * Getter method for distance sensor.
    *@return distance sensor
    */
    public Rev2mDistanceSensor get2mDistanceSensor(){
      return mDistanceSensor;
    }

    /**
    * Getter method for color sensor.
    *@return color sensor
    */
    public RevColorSensorV3 getColorSensor(){
      return colorSensor;
    }

    /**
    * Getter method for touch sensor.
    *@return touch sensor
    */
    public RevTouchSensor getTouchSensor() {
      return touchSensor;
    }

    /**
    * Getter method for IMU.
    *@return IMU
    */
    public IMU getIMU(){
      return imu;
    }

    /**
    * Getter method for pixel entrance mecanism motor.
    *@return pixel entrance mecanism motor
    */
    public DcMotor getPixelEntranceMotor(){
        return pixelEntranceMotor;
    }
}

