package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
// goes on controller hub, shows in the list of autonomous ot teleop
@TeleOp(name = "First_Teleop")
public class FirstLinearTeleopMotors extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // initialization code in here
        DcMotor motorOne;
        DcMotorEx motorTwo;
        // hardware map is the configuration of each motor in its specific place
        // YOU MUST HAVE THE ONE IN QUOTATIONS MATCH UP TO THE ONE CONFIGURED IN THE CONTROL HUB since they are directly related and must be exact
        motorOne = hardwareMap.get(DcMotor.class, "motor_one");
        motorTwo = hardwareMap.get(DcMotorEx.class, "motor_two");
        // sets direction to forward, can be reverse
        motorOne.setDirection(DcMotorSimple.Direction.FORWARD);
        motorOne.setDirection(DcMotorSimple.Direction.REVERSE);

        // zero power behavior: how a motor behaves after having its power set to zero, can 1) BRAKE immidiately, 2) slowly go to stop (FLOAT)
        motorOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        // setting modes, enocders, wires that track how many times motor has spun, measured in ticks
        // run using encoder, what it does is that it will use encoders to maintain a constant power level
        motorOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // run without encoders: doesnt use encoders to manage power or position
        motorOne.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        // sets ticks back to zero
        motorOne.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorOne.getPower();

        waitForStart();
        while(opModeIsActive()){
            // actual teleop
            // between 1 and -1, - is reverse, 1 is forward
            motorOne.setPower(0.5);
            // only for dcmotorex, can set velocity for motor, more accurate than set power, but uses ticks to maintain speed
            motorTwo.setVelocity(150);
        }
    }
}
