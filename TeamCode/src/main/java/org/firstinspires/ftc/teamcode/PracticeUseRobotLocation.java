package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class PracticeUseRobotLocation extends OpMode {
    PracticeRobotLocation robotLocation = new PracticeRobotLocation(0);

    public final int thisIsFinal = 2;

    @Override
    public void init() {
        robotLocation.setAngle(0);
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            robotLocation.turn(0.1);
        }
        else if (gamepad1.b) {
            robotLocation.turn(-0.1);
        }
        if (gamepad1.dpad_left) {
            robotLocation.changeX(-0.1);
        }
        else if (gamepad1.dpad_right) {
            robotLocation.changeX(0.1);
        }
        else if (gamepad1.dpad_up) {
            robotLocation.changeY(0.1);
        }
        else if (gamepad1.dpad_down) {
            robotLocation.changeY(-0.1);
        }

        telemetry.addData("location", robotLocation);
        telemetry.addData("heading", robotLocation.getHeading());
        telemetry.addData("Angle:", robotLocation.getAngle());
    }
}