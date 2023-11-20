package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcontroller.external.samples.RobotHardware;

import java.text.SimpleDateFormat;
import java.util.Date;

@TeleOp
public class MyFIRSTOpMode extends LinearOpMode {

    BotHardware botHardware = new BotHardware(this);

    @Override
    public void runOpMode() throws InterruptedException
    {
        botHardware.init();

        waitForStart();
        while (opModeIsActive())
        {
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1.1;
            double rx = gamepad1.right_stick_x;

            botHardware.driveRobotMecanum(y, x, rx);
            telemetry.addData("drive", y);
            telemetry.addData("side", x);
            telemetry.addData("rotate", rx);
            telemetry.update();
        }
    }
}
