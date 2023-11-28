package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.BotHardware;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

        import org.firstinspires.ftc.teamcode.BotHardware;

//IMPORTANT INFORMATION the x-y-z is set on as if you set the hub on the table so you can read the label
@TeleOp(group = "examples")
public class imu extends LinearOpMode {

    BotHardware botHardware = BotHardware.getInstance();
    //for knowing how much the robot has turned
    private Orientation lastAngle = new Orientation();
    private double currentAngle = 0.0;

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



    }
    public void imuTelemetry(){
     telemetry.addData("X", "%.2f",getAbsoluteAngleX());//front to back
     telemetry.addData("Y", "%.2f",getAbsoluteAngleY());//left to right
     telemetry.addData("Z", "%.2f",getAbsoluteAngleZ());//top to bottom
     telemetry.update();
    }

    public void resetAngle(){
        lastAngle = botHardware.getIMU().getAngularOrientation();

    }
    // gets the angle of the robot
    public double getAbsoluteAngleX(){
        return botHardware.getIMU().getAngularOrientation(AxesReference.INTRINSIC,
                AxesOrder.XYZ, AngleUnit.DEGREES).firstAngle;
    }
    public double getAbsoluteAngleY(){
        return botHardware.getIMU().getAngularOrientation(AxesReference.INTRINSIC,
                AxesOrder.XYZ, AngleUnit.DEGREES).secondAngle;
    }
    public double getAbsoluteAngleZ(){
        return botHardware.getIMU().getAngularOrientation(AxesReference.INTRINSIC,
                AxesOrder.XYZ, AngleUnit.DEGREES).thirdAngle;
    }
}
