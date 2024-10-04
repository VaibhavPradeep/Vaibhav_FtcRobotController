package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class MotorGamepadOpMode1and2 extends OpMode {
    PracticeProgrammingBoard3and4 board = new PracticeProgrammingBoard3and4();
    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void loop() {
        double motorSpeed = gamepad1.left_stick_y;

        board.setMotorSpeed(motorSpeed);

        telemetry.addData("Motor speed", motorSpeed);
        telemetry.addData("motor roataions", board.getMotorRotations());
        if (gamepad1.a) {
            board.setMotorZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        else if (gamepad1.b) {
            board.setMotorZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }

    }
}
