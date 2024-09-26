package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class FirstLinearTeleopEncoders extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // init
        // hypothetical ticks per evolution = 500
        // Dcmotorex can have encoder tolerance
        DcMotor motorEncoder;
        motorEncoder = hardwareMap.get(DcMotor.class, "motor encode");
        motorEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        int degrees = 250;

        waitForStart();

        while(opModeIsActive()) {
            //ticks is the encoders units, one revolution, each motor has different ticks per revolution, reverse does negative ticks and vice versa
            motorEncoder.setTargetPosition(degrees);
            motorEncoder.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motorEncoder.setPower(0.5);
            // if it were dcmotor ex, it would be like motorEncoder.setTargetPositionTolerance(3);, if wanted as 3 + or -
        }
    }
}
