package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class PracticeTouchSensorOpMode extends OpMode {
    PracticeProgrammingBoard1 programmingBoard1 = new PracticeProgrammingBoard1();
    PracticeProgrammingBoard2 programmingBoard2 = new PracticeProgrammingBoard2();

    @Override
    public void init() {
        programmingBoard1.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("is sensor touched:", programmingBoard1.getTouchSensorState());
        if (programmingBoard2.isTouchSensorReleased() == true) {
            telemetry.addLine("Pressed");
        }
        else {
            telemetry.addLine("not pressed");
        }
    }
}
