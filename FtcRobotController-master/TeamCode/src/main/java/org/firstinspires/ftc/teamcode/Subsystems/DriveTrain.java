package org.firstinspires.ftc.teamcode.Subsystems;

import org.firstinspires.ftc.teamcode.BotHardware;

public class DriveTrain {

    //TODO: method to move the robot by mecanum wheels robot-centeric. meaning, a method which it's parameters are turn, forward and side. by those parameters the robot will move.

    static BotHardware botHardware = BotHardware.getInstance();


    public static void spaceCentricMoving(double x, double y, double rx, double IMUAngle) {
        /*double radius = Math.min(vector.getRadius(), 1);
        double angle = vector.getAngle();*/
        //double angle = Math.atan(y/x)
        double newx = Math.min(x*Math.cos(IMUAngle)-y*Math.sin(IMUAngle),1);
        double newy = Math.min(x*Math.sin(IMUAngle)+y*Math.cos(IMUAngle),1);
        robotCentric(newx, newy, rx);
    }

    public static void robotCentric(double x, double y, double rx) {

    double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
    double frontLeftPower = (y + x + rx) / denominator;
    double backLeftPower = (y - x + rx) / denominator;
    double frontRightPower = (y - x - rx) / denominator;
    double backRightPower = (y + x - rx) / denominator;

    botHardware.setDrivePower(backLeftPower,backRightPower,frontRightPower, frontLeftPower);
    }
}
