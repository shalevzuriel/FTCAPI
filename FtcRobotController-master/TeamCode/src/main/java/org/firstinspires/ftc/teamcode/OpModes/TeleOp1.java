package org.firstinspires.ftc.teamcode.OpModes;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.BotHardware;

@TeleOp
public class TeleOp1 extends LinearOpMode {

    BotHardware botHardware = new BotHardware(this);

    @Override
    public void runOpMode() throws InterruptedException
    {
        botHardware.init();

        waitForStart();
        while (opModeIsActive())
        {
            //TODO Get values from controller that are necessary either for driving or moving the arm
            float leftStickX = gamepad1.left_stick_x;
            float leftStickY = gamepad1.left_stick_y;
            float rightStickX = gamepad1.right_stick_x;
            float rightStickY = gamepad1.right_stick_y;

            //TODO Put the values from the controller into the relevant methods
            
            //TODO update telemetrygit 
        }
    }
}
