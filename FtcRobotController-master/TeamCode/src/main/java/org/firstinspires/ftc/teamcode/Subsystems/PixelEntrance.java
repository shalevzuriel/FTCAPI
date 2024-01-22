package org.firstinspires.ftc.teamcode.Subsystems;

import org.firstinspires.ftc.teamcode.BotHardware;

public class PixelEntrance {
    static BotHardware botHardware = BotHardware.getInstance();

    /**
     * this method will activate the pixelMotor if the state is true.
     * @param state boolean param that while true - pixelMotor will on. else - pixelMotor will off.
     */
    public static void pixelMotorOn (boolean state) {
        if(state) {
            botHardware.getPixelEntranceMotor().setPower(1);
        }
        else {
            botHardware.getPixelEntranceMotor().setPower(0);
        }
    }
}
