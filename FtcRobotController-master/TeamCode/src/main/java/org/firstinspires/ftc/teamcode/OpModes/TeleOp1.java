package org.firstinspires.ftc.teamcode.OpModes;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.teamcode.BotHardware;
import org.firstinspires.ftc.teamcode.Subsystems.DriveTrain;


@TeleOp
public class TeleOp1 extends LinearOpMode {

    BotHardware botHardware = BotHardware.getInstance();

    @Override
    public void runOpMode() throws InterruptedException
    {
        botHardware.init(this);

        waitForStart();
        while (opModeIsActive())
        {
            //TODO Get values from controller that are necessary either for driving or moving the arm
            double leftStickX = -gamepad1.left_stick_x;
            double leftStickY = -gamepad1.left_stick_y;
            double rightStickX = gamepad1.right_stick_x;
            double rightStickY = gamepad1.right_stick_y;

            DriveTrain.spaceCentricMoving(leftStickX,leftStickY, rightStickX, 0);
            botHardware.setDrivePower(0,0,0,0);
            //TODO Put the values from the controller into the relevant methods

            //TODO update telemetrygit 


        }
    }
}
