package org.firstinspires.ftc.teamcode.Subsystems;

import org.firstinspires.ftc.teamcode.BotHardware;

public class DriveTrain {
    BotHardware BH = new BotHardware();
    //TODO: method to move the robot by mecanum wheels robot-centeric. meaning, a method which it's
    // parameters are turn, forward and side. by those parameters the robot will move.
    public void robotCentricDrive(double y, double x, double t){
        /**
         * y represents the desired magnitude for the y component of the movement vector.
         * x represents desired x component of the movement vector.
         * t represents the desired torque.
         */
        BH.setDrivePower(y - x + t, y + x - t, y - x - t, y + x + t);
        //further testing/fine tuning  is required to see whether this method works on our robot.
    }
}
