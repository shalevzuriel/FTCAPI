package org.firstinspires.ftc.teamcode.Subsystems;

import org.firstinspires.ftc.teamcode.BotHardware;

public class DriveTrain {
    BotHardware BH = BotHardware.getInstance();
    /**
     * robotCentricDrive will set the robots motors to the right power to create a movement vector
     * based on the parameters you give it
     * @param y represents the y component of the movement vector, demands double between 1 and -1.
     * @param x represents the x component of the movement vector, demands double between 1 and -1,
     * @param t represnts how mush of the movement vector will be allocated to torque, demands double between 1 and -1
     */
        public void robotCentricDrive(double y, double x, double t){

            double denominator = Math.max(y + x + t, 1);

        BH.setDrivePower((y - x + t) / denominator, (y + x - t) / denominator, (y - x - t) / denominator, (y + x + t) / denominator);
        //further testing/fine tuning  is required to see whether this method works on our robot.
    }
}
