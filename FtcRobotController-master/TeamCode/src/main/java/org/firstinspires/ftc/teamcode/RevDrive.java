package org.firstinspires.ftc.teamcode;

public class RevDrive {

    static RevBotHardware revRobot = RevBotHardware.getInstance();

    public static void drive(double drive, double turn){

        double max = Math.max(1, Math.abs(drive + turn));

        revRobot.getLeftDrive().setPower((drive + turn) / max);
        revRobot.getRightDrive().setPower((drive - turn) / max);

    }
}
