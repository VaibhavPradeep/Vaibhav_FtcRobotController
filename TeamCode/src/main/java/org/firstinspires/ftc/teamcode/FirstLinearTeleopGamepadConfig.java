package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "FirstLinearTeleopGamepadConfig")
public class FirstLinearTeleopGamepadConfig extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        double joystick;
        //init
        boolean pressed;
        boolean isDown = true;
        boolean lastCycle = false, currCycle = false;
        DcMotor motorThree;
        motorThree = hardwareMap.get(DcMotor.class, "m3");
        Servo servoRandom;
        servoRandom = hardwareMap.get(Servo.class, "sr");

        waitForStart();
        while(opModeIsActive()) {
            // there are 2 gamepads, 1 for ususally drivetrain and other for functions
            //buttons are true or false,
            pressed = gamepad1.a;
            //also
            if(gamepad1.b) {
               motorThree.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            }
            // alos has floats as inputs like trigger or joysticks value from 0-1, depedning on how far its pressed
            // ON Y AXIS JOYSTICK, DOWN IS POSITIVE, UP IS NEGATIVE, MULTIPLY BY NEGATIVE 1 USUALLY
            joystick = gamepad1.left_stick_y;
            motorThree.setPower(gamepad1.left_stick_x);

            //soometimes, when make buttons makes servos go somehwere, it goes in milliseocnds, so it jitters since inputs in and out, solution to add 2 other variables
            lastCycle = currCycle;
            currCycle = gamepad1.a;
            if(currCycle && !lastCycle) {
                isDown = !isDown;
                if(isDown) {
                    servoRandom.setPosition(0);
                }else{
                    servoRandom.setPosition(1);
                }
            }
        }

    }
}
