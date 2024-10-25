package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.IMU;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

public class PracticeAutoTurn {
    public DcMotor frontLeft;
    public DcMotor backLeft;
    public DcMotor frontRight;
    public DcMotor backRight;

    IMU imu;
    IMU.Parameters parameters;
    YawPitchRollAngles angles;

    TeleOp opMode;

    public double getAngleDifference(double angle1, double angle2) {

        return (angle1 - angle2 + 540) % 360 - 180;

    }

    public void turn(double power, double angle, String direction) {
        angles = imu.getRobotYawPitchRollAngles();

        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        int directionMultiplier = -1;

        if (direction.equals("closest")) {

            if (getAngleDifference(angles.getYaw(AngleUnit.DEGREES), angle) < 0) {
                power *= -1;
                directionMultiplier *= -1;
            }

        } else if (direction.equals("left")) {
            power *= -1;
            directionMultiplier *= -1;
        }

        frontLeft.setPower(power);
        backLeft.setPower(power);
        frontRight.setPower(-power);
        backRight.setPower(-power);

        while (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy() && directionMultiplier * getAngleDifference(angles.getYaw(AngleUnit.DEGREES), angle) < 0) {
            angles = imu.getRobotYawPitchRollAngles();
        }

        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void initGyro(HardwareMap hwMap) {
        parameters = new IMU.Parameters(
                new RevHubOrientationOnRobot(
                        RevHubOrientationOnRobot.LogoFacingDirection.UP,
                        RevHubOrientationOnRobot.UsbFacingDirection.LEFT
                )
        );

        imu = hwMap.get(IMU.class, "imu");
        angles = imu.getRobotYawPitchRollAngles();
        imu.initialize(parameters);
    }
}