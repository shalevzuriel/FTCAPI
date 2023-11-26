package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.BotHardware;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

        import org.firstinspires.ftc.teamcode.BotHardware;

@TeleOp
public class imu extends LinearOpMode {

    BotHardware botHardware = BotHardware.getInstance();

    @Override
    public void runOpMode() throws InterruptedException
    {
        botHardware.init(this);
        while (!isStarted()){
            imuTelemetry();
        }
        waitForStart();
        while (opModeIsActive()){
            imuTelemetry();
        }
        {
            //TODO Get values from controller that are necessary either for driving or moving the arm

            //TODO Put the values from the controller into the relevant methods

            //TODO update telemetrygit
        }
    }
    public void initImu(){


    }
    public void imuTelemetry(){

    }
}
