package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp
public class PracticeOpMode extends OpMode {
    PracticeProgrammingBoard1 programmingBoard1 = new PracticeProgrammingBoard1();
    PracticeProgrammingBoard2 programmingBoard2 = new PracticeProgrammingBoard2();
    PracticeProgrammingBoard3and4 board = new PracticeProgrammingBoard3and4();

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

        telemetry.addData("Pot Angle", board.getPotAngle());
        telemetry.addData("Amount red", board.getAmountRed());
        telemetry.addData("amount blue", board.getAmountBlue());
        telemetry.addData("Distance (CM)", board.getDistance(DistanceUnit.CM));
        telemetry.addData("Distance (IN)", board.getDistance(DistanceUnit.INCH));

        if (board.getDistance(DistanceUnit.CM) > 10) {
            board.setMotorSpeed(0.5);
        }
        else {
            board.setMotorSpeed(0);
            telemetry.addLine("no movement");
        }

    }
}
