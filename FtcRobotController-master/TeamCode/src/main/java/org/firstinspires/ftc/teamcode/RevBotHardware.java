package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class RevBotHardware {


    // Only instance of the class
    public static RevBotHardware instance;

    /* Declare OpMode members. */
    private LinearOpMode myOpMode = null;   // gain access to methods in the calling OpMode.

    // Define Motor and Servo objects  (Make them private so they can't be accessed externally)
    private DcMotor leftDrive   = null;
    private DcMotor rightDrive  = null;
    private DcMotor armRight = null;
    private DcMotor armLeft = null;
    private Servo wrist = null;
    private Servo gripper = null;

    // Define Drive constants

    public final double armManualMinimum = 0.03;

    public final double gripperClosedPosition = 1.0;
    public final double gripperOpenPosition = 0.5;
    public final double wristUpPosition = 1.0;
    public final double wristDownPosition = 0.0;

    public final int armHomePosition = 0;
    public final int armGrabPosition = 10;
    public final int armBackDropPosition = 600;
    public final int armShutdownThreshold = 5;
    public boolean isGripperOpen = false;


    // Define a constructor that allows the OpMode to pass a reference to itself.
    public RevBotHardware()
    {

    }

    /**
     * method to create/get the singleton instance of BotHardware.
     * if the instance wasn't constructed- a new one will be constructed using the private constructor and then returned.
     * if there is an instance - the method will only return the existing instance.
     * @return the RevBotHardware singleton instance.
     */
    public static RevBotHardware getInstance() {
        // create the instance only if it's null
        if (instance == null) {
            instance = new RevBotHardware();
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
        leftDrive  = myOpMode.hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = myOpMode.hardwareMap.get(DcMotor.class, "right_drive");

        armRight = myOpMode.hardwareMap.get(DcMotor.class, "arm_right");
        armLeft = myOpMode.hardwareMap.get(DcMotor.class, "arm_left");

        // Initialize all servos
        wrist = myOpMode.hardwareMap.get(Servo.class, "wrist");
        gripper = myOpMode.hardwareMap.get(Servo.class, "gripper");

        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        // Zero power behavior is how the motors act is zero power.
        // In this case, the float, meaning they don't brake.
        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        // The change of directions for driving motors is also right for the arm motors
        armLeft.setDirection(DcMotor.Direction.FORWARD);
        armRight.setDirection(DcMotor.Direction.REVERSE);

        armLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Zero power behavior is zero since the arms needs to brake when power isn't applied.
        armLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Running without encoder for manual movements
        armLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        armLeft.setPower(0.0);
        armRight.setPower(0.0);

        myOpMode.telemetry.addData(">", "Hardware Initialized");
        myOpMode.telemetry.update();
    }



    // Getter and setter for leftDrive
    public DcMotor getLeftDrive() {
        return leftDrive;
    }

    public void setLeftDrive(DcMotor leftDrive) {
        this.leftDrive = leftDrive;
    }

    // Getter and setter for rightDrive
    public DcMotor getRightDrive() {
        return rightDrive;
    }

    public void setRightDrive(DcMotor rightDrive) {
        this.rightDrive = rightDrive;
    }

    // Repeat the pattern for other motors and servos

    // Getter and setter for armRight
    public DcMotor getArmRight() {
        return armRight;
    }

    public void setArmRight(DcMotor armRight) {
        this.armRight = armRight;
    }

    // Getter and setter for armLeft
    public DcMotor getArmLeft() {
        return armLeft;
    }

    public void setArmLeft(DcMotor armLeft) {
        this.armLeft = armLeft;
    }

    // Getter and setter for wrist
    public Servo getWrist() {
        return wrist;
    }

    public void setWrist(Servo wrist) {
        this.wrist = wrist;
    }

    // Getter and setter for gripper
    public Servo getGripper() {
        return gripper;
    }

    public void setGripper(Servo gripper) {
        this.gripper = gripper;
    }


}


