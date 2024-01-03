package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.BotHardware;

@Autonomous(name = "Autonomous" )
public class Autonomous_opmode extends LinearOpMode {
    BotHardware botHardware = BotHardware.getInstance();

    @Override
    public void runOpMode() throws InterruptedException {
        botHardware.init(this);
        waitForStart();

    }
}

 class SampleMecanumDrive {
     private static SampleMecanumDrive  instance;

         public static SampleMecanumDrive getInstance(){
             // create the instance only if it's null
             if (instance == null) {
                 instance = new SampleMecanumDrive ();
             }
             return instance;
         }


 }