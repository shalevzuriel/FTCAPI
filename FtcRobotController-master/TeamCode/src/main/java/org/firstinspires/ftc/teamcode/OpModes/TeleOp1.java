package org.firstinspires.ftc.teamcode.OpModes;


import com.qualcomm.hardware.bosch.BHI260IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.teamcode.BotHardware;


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
            telemetry.addData("x", botHardware.getIMU().getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES));
            telemetry.update();
            //TODO Put the values from the controller into the relevant methods

            //TODO update telemetrygit 
        }
    }
}
