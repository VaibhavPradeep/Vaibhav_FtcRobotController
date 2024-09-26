package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "first_linearteleop_servos")
public class FirstLinearTeleopServos extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        //initialiation goes here
        Servo servoOne;
        servoOne = hardwareMap.get(Servo.class, "Servo_one");
        //servos can be differed in range with this function, onyl samller
        servoOne.scaleRange(0.2, 0.8);
        //gets position
        servoOne.getPosition();

        //continous servos, foes 360 degrees
        CRServo servoTwo;
        servoTwo = hardwareMap.get(CRServo.class, "Servo_two");
        // works like a motor in this way, 0-1 range
        servoTwo.setPower(1);


        waitForStart();

        while(opModeIsActive()) {
            // 0-1 position, either sides of the servo, also used in initialization
            servoOne.setPosition(0);
        }
    }
}
