package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class AutonomousIMU extends LinearOpMode {
    // Motors
    private DcMotor frontLeft, frontRight, backLeft, backRight;

    // IMU sensor
    private BNO055IMU imu;
    private Orientation angles;

    @Override
    public void runOpMode() {
        // Initialize motors
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        // Reverse motors if necessary
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);

        // Initialize IMU
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        // Wait for the start button
        waitForStart();

        // Autonomous actions using IMU methods
        driveForward(0.5, 2000);      // Drive forward for 2 seconds
        turnToAngle(90);              // Turn right to 90 degrees
        strafeRight(0.5, 1500);       // Strafe right for 1.5 seconds
        turnToAngle(180);             // Turn to 180 degrees
        driveBackward(0.5, 1000);     // Drive backward for 1 second
        strafeLeft(0.5, 1000);        // Strafe left for 1 second
        turnToAngle(0);               // Turn back to 0 degrees (facing forward)
    }

    // Method to turn the robot to a specific angle using the IMU (yaw)
    public void turnToAngle(double targetAngle) {
        double error;
        double Kp = 0.01; // Proportional constant for tuning
        double motorPower;

        do {
            // Get current yaw (firstAngle corresponds to yaw)
            double currentYaw = imu.getAngularOrientation().firstAngle;

            // Calculate the error between the target angle and current yaw
            error = targetAngle - currentYaw;

            // Adjust motor power proportionally to the error
            motorPower = Kp * error;

            // Set motor power to turn the robot (negative power on left side, positive on right side)
            frontLeft.setPower(-motorPower);
            frontRight.setPower(motorPower);
            backLeft.setPower(-motorPower);
            backRight.setPower(motorPower);

            telemetry.addData("Current Yaw", currentYaw);
            telemetry.addData("Target Angle", targetAngle);
            telemetry.addData("Error", error);
            telemetry.update();
        } while (Math.abs(error) > 1 && opModeIsActive());  // Exit loop when error is within 1 degree
    }

    // Method to drive forward for a specified time
    public void driveForward(double power, long time) {
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);

        sleep(time);  // Drive forward for the specified duration
        stopMotors();
    }

    // Method to drive backward for a specified time
    public void driveBackward(double power, long time) {
        frontLeft.setPower(-power);
        frontRight.setPower(-power);
        backLeft.setPower(-power);
        backRight.setPower(-power);

        sleep(time);  // Drive backward for the specified duration
        stopMotors();
    }

    // Method to strafe left for a specified time (mecanum wheels)
    public void strafeLeft(double power, long time) {
        frontLeft.setPower(-power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(-power);

        sleep(time);  // Strafe left for the specified duration
        stopMotors();
    }

    // Method to strafe right for a specified time (mecanum wheels)
    public void strafeRight(double power, long time) {
        frontLeft.setPower(power);
        frontRight.setPower(-power);
        backLeft.setPower(-power);
        backRight.setPower(power);

        sleep(time);  // Strafe right for the specified duration
        stopMotors();
    }

    // Method to stop all motors
    public void stopMotors() {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }
}
