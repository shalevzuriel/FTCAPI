package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class BotHardware {


    private LinearOpMode myOpMode = null;   // gain access to methods in the calling OpMode.

    // Define Motor and Servo objects  (Make them private so they can't be accessed externally)
    private DcMotor leftRearDrive = null;
    private DcMotor rightRearDrive  = null;
    private DcMotor leftFrontDrive = null;
    private DcMotor rightFrontDrive = null;


    // Define a constructor that allows the OpMode to pass a reference to itself.
    public BotHardware(LinearOpMode opmode) {
        myOpMode = opmode;
    }

    /**
     * Initialize all the robot's hardware.
     * This method must be called ONCE when the OpMode is initialized.
     * <p>
     * All of the hardware devices are accessed via the hardware map, and initialized.
     */
    public void init()    {
        // Define and Initialize Motors (note: need to use reference to actual OpMode).
        leftRearDrive = myOpMode.hardwareMap.get(DcMotor.class, "left_drive_rear");
        rightRearDrive = myOpMode.hardwareMap.get(DcMotor.class, "right_drive_rear");
        leftFrontDrive = myOpMode.hardwareMap.get(DcMotor.class, "left_drive_front");
        rightFrontDrive = myOpMode.hardwareMap.get(DcMotor.class, "right_drive_front");

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
     * Calculates the left/right motor powers required to achieve the requested
     * robot motions: Drive (Axial motion) and Turn (Yaw motion).
     * Then sends these power levels to the motors.
     *
     * @param y     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
     * @param Turn      Right/Left turning power (-1.0 to 1.0) +ve is CW
     */
    public void driveRobotMecanum(double y, double x, double rx) {
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);

        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        // Use existing function to drive both wheels.
        setDrivePower(backLeftPower, backRightPower, frontRightPower, frontLeftPower);
    }

    /**
     * Pass the requested wheel motor powers to the appropriate hardware drive motors.
     *
     * @param leftRearWheel     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
     * @param rightRearWheel    Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
     */
    public void setDrivePower(double leftRearWheel, double rightRearWheel, double rightFrontWheel, double leftFrontWheel) {
        // Output the values to the motor drives.
        leftRearDrive.setPower(leftRearWheel);
        rightRearDrive.setPower(rightRearWheel);
        leftFrontDrive.setPower(leftFrontWheel);
        rightFrontDrive.setPower(rightFrontWheel);
    }
}
