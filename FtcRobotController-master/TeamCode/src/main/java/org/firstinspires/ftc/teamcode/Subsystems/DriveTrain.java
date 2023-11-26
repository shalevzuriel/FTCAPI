package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

public class DriveTrain {

    //TODO: method to move the robot by mecanum wheels robot-centeric. meaning, a method which it's parameters are turn, forward and side. by those parameters the robot will move.













































    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor rearRight;
    DcMotor rearLeft;
    public void power(Vector vector, float IMUAngle){
        float radius = vector.getRadius();
        float angle = vector.getAngle();
        float movingAngle = angle - IMUAngle + 45;

        frontRight.setPower(radius * Math.cos(movingAngle));
        frontLeft.setPower(radius * Math.sin(movingAngle));
        rearRight.setPower(-(radius * Math.cos(movingAngle)));
        rearLeft.setPower(-(radius * Math.sin(movingAngle)));
    }

}
