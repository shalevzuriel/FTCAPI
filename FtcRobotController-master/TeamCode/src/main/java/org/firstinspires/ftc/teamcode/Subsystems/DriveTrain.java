package org.firstinspires.ftc.teamcode.Subsystems;

import org.firstinspires.ftc.teamcode.BotHardware;

public class DriveTrain {
    BotHardware BH = BotHardware.getInstance();
    /**
     * robotCentricDrive will set the robots motors to the right power to create a movement vector
     * based on the parameters you give it
     * @param y represents the y component of the movement vector, demands double between 1 and -1.
     * @param x represents the x component of the movement vector, demands double between 1 and -1,
     * @param t represents how mush of the movement vector will be allocated to torque, demands double between 1 and -1
     */
    public void robotCentricDrive(double y, double x, double t){
        //the denominator is put in place to scale down all the motors so the power value of the motors is allways between -1 and 1.
        double denominator = Math.max(y + x + t, 1);
        /* now the reasons for the following 4 lines of code are only vector based,
         * so i've decided i just wont explain.
         * here's a link to a thing:
         * https://gm0.org/en/latest/docs/software/tutorials/mecanum-drive.html
         */
        double leftFrontWheel = (y + x + t) / denominator;
        double leftRearWheel =  (y - x + t) / denominator;
        double rightFrontWheel = (y - x - t) / denominator;
        double rightRearWheel = (y + x - t) / denominator;
        BH.setDrivePower(leftRearWheel, rightRearWheel, rightFrontWheel, leftFrontWheel);
    }
}
