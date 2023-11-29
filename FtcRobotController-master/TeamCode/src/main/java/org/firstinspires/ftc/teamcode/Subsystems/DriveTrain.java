package org.firstinspires.ftc.teamcode.Subsystems;

import org.firstinspires.ftc.teamcode.BotHardware;

public class DriveTrain {

    //TODO: method to move the robot by mecanum wheels robot-centeric. meaning, a method which it's parameters are turn, forward and side. by those parameters the robot will move.

    static BotHardware botHardware = BotHardware.getInstance();

    /**
     * robotCentricDrive will set the robots motors to the right power to create a movement vector
     * based on the parameters you give it
     *
     * @param y represents the y component of the movement vector, demands double between 1 and -1.
     * @param x represents the x component of the movement vector, demands double between 1 and -1,
     * @param t represents how mush of the movement vector will be allocated to torque, demands double between 1 and -1
     */

    public static void robotCentricDrive(double x, double y, double t) {
        //the denominator is put in place to scale down all the motors so the power value of the motors is allways between -1 and 1.
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(t), 1);        /* now the reasons for the following 4 lines of code are only vector based,
         * so i've decided i just wont explain.
         * here's a link to a thing:
         * https://gm0.org/en/latest/docs/software/tutorials/mecanum-drive.html
         */
        double leftFrontWheel = (y + x + t) / denominator;
        double leftRearWheel = (y - x + t) / denominator;
        double rightFrontWheel = (y - x - t) / denominator;
        double rightRearWheel = (y + x - t) / denominator;
        botHardware.setDrivePower(leftRearWheel, rightRearWheel, rightFrontWheel, leftFrontWheel);
    }

    /**
     * Moving the robot using space-centric.
     * Doing it by rotating the plane using x2 = x cos(a) - y sin(a), y2 = x sin(a) + y cos(a).
     * @param y represents the y component of the movement vector, demands double between 1 and -1.
     * @param x represents the x component of the movement vector, demands double between 1 and -1.
     * @param t represents how mush of the movement vector will be allocated to torque, demands double between 1 and -1.
     * @param IMUAngle represents rotation angle of the robot.
     */
    public static void spaceCentricMoving(double x, double y, double t, double IMUAngle) {
        double newRotatedX = x * Math.cos(-IMUAngle) - y * Math.sin(-IMUAngle); //Calculated the needed x rotation
        double newRotatedY = x * Math.sin(-IMUAngle) + y * Math.cos(-IMUAngle); //Calculated the needed y rotation
        robotCentricDrive(newRotatedX, newRotatedY, t); //Driving the robot
    }

}
