package org.firstinspires.ftc.teamcode.OpModes;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.BotHardware;
import org.firstinspires.ftc.teamcode.Subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.Subsystems.PixelEntrance;

@TeleOp
public class TeleOp1 extends LinearOpMode {

    BotHardware botHardware = BotHardware.getInstance();

    @Override
    public void runOpMode() throws InterruptedException
    {
        botHardware.init(this);

        boolean isPixelOn = false;

        waitForStart();
        while (opModeIsActive())
        {

            //TODO Get values from controller that are necessary either for driving or moving the arm
            double leftStickX = gamepad1.left_stick_x;
            double leftStickY = -gamepad1.left_stick_y;
            double rightStickX = gamepad1.right_stick_x;
            double rightStickY = gamepad1.right_stick_y;

            //Resetting the YAW(rotation)
            if (gamepad1.share)
            {
                botHardware.getIMU().resetYaw();
            }

            //Getting IMU rotation
            double IMUAngleRads = botHardware.getIMU().getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

            if (gamepad1.a)
            {
                isPixelOn = !isPixelOn;
            }

            PixelEntrance.pixelMotorOn(isPixelOn);
            DriveTrain.spaceCentricMoving(leftStickX,leftStickY, rightStickX, IMUAngleRads); //Print
            telemetry.addData("Angle", Math.toDegrees(IMUAngleRads)); //Prints out the angle.
            telemetry.update();
            //TODO Put the values from the controller into the relevant methods

            //TODO update telemetrygit

        }
    }
}
