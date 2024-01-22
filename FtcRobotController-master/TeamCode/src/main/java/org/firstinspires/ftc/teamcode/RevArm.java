package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class RevArm {

    static RevBotHardware revRobot = RevBotHardware.getInstance();

    public static void homePosition(boolean press) {
        if (press){
            revRobot.getArmLeft().setTargetPosition(revRobot.armHomePosition);
            revRobot.getArmRight().setTargetPosition(revRobot.armHomePosition);
            revRobot.getArmLeft().setPower(0.9);
            revRobot.getArmRight().setPower(0.9);
            revRobot.getArmRight().setMode(DcMotor.RunMode.RUN_TO_POSITION);
            revRobot.getArmRight().setMode(DcMotor.RunMode.RUN_TO_POSITION);

            revRobot.getWrist().setPosition(revRobot.wristUpPosition);
        }
    }

    public static void grabPosition(boolean press) {
        if (press) {
            revRobot.getArmLeft().setTargetPosition(revRobot.armGrabPosition);
            revRobot.getArmRight().setTargetPosition(revRobot.armGrabPosition);
            revRobot.getArmLeft().setPower(0.9);
            revRobot.getArmRight().setPower(0.9);
            revRobot.getArmRight().setMode(DcMotor.RunMode.RUN_TO_POSITION);
            revRobot.getArmRight().setMode(DcMotor.RunMode.RUN_TO_POSITION);

            revRobot.getWrist().setPosition(revRobot.wristDownPosition);
        }
    }

    public static void backDropPosition(boolean press) {
        if (press) {
            revRobot.getArmLeft().setTargetPosition(revRobot.armBackDropPosition);
            revRobot.getArmRight().setTargetPosition(revRobot.armBackDropPosition);
            revRobot.getArmLeft().setPower(0.9);
            revRobot.getArmRight().setPower(0.9);
            revRobot.getArmRight().setMode(DcMotor.RunMode.RUN_TO_POSITION);
            revRobot.getArmRight().setMode(DcMotor.RunMode.RUN_TO_POSITION);

            revRobot.getWrist().setPosition(revRobot.wristUpPosition);
            // setGripperPosition(true);
        }
    }

    public static void gripper(boolean press) {
        if(press){
            if (revRobot.isGripperOpen)
            {
                setGripperPosition(false);
            }
            else
            {
                setGripperPosition(true);
            }
        }
    }
    public static void setGripperPosition(boolean open)
    {
        if (open)
        {
            revRobot.getGripper().setPosition(revRobot.gripperOpenPosition);
            revRobot.isGripperOpen = true;
        }
        else {
            revRobot.getGripper().setPosition(revRobot.gripperClosedPosition);
            revRobot.isGripperOpen = false;
        }
    }
}

