package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class PracticeProgrammingBoard3and4 {
    private DigitalChannel touchSensor;
    private DcMotor motor;
    private double ticksPerRotation;
    Servo servo;
    private AnalogInput pot;
    private ColorSensor colorSensor;
    private DistanceSensor distanceSensor;

    public void init(HardwareMap hwMap) {
        touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor");
        touchSensor.setMode(DigitalChannel.Mode.INPUT);
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRotation = motor.getMotorType().getTicksPerRev();
        servo = hwMap.get(Servo.class,"servo");
        pot = hwMap.get(AnalogInput.class, "pot");

        colorSensor = hwMap.get(ColorSensor.class, "sensor_color_distance");
        distanceSensor = hwMap.get(DistanceSensor.class, "sensor_color_distance");

    }

    public boolean isTouchSensorPressed() {
        return !touchSensor.getState();
    }

    public void setMotorSpeed(double speed) {
        motor.setPower(speed);
    }

    public double getMotorRotations() {
        return motor.getCurrentPosition() / ticksPerRotation;
    }

    public void setMotorZeroPowerBehavior(DcMotor.ZeroPowerBehavior zeroBehavior) {
        motor.setZeroPowerBehavior(zeroBehavior);
    }

    // range example
    double output = Range.scale(25, 0, 100, 0.0, 1.0);
    /* Potentiometers abbreviate as pot, and they have a .getVoltage() to get current voltage, and a .getMaxVoltage() to get maximum
     *possible voltage, which normal range is 0 to 270
     *the range function will look between the second and third numbers, and the first number will be in between it, then the 2 and 3
     *numbers will be scaled to the 4 and 5th, and keep the first in its ration, so 25 being 1/4 of the way from 0 to 100, will also be
     *  1/4 of the way from 0 to 1, so it will be 0.25
     */
    public double getPotAngle(){
        return Range.scale(pot.getVoltage(), 0, pot.getMaxVoltage(), 0, 270);
    }

    public double getPotRange() {
        return Range.scale(pot.getVoltage(), 0, pot.getMaxVoltage(), 0, 1.0);
    }

    // detects red blue or green from a number scale of 0 to 255 or .argb(), which is ints of a=alpha, r=red, b=blue, g=green of aarrggbb
    public int getAmountRed(){
        return colorSensor.red();
    }

    public int getAmountBlue () {
        return colorSensor.blue();
    }

    public double getDistance(DistanceUnit du){
        return distanceSensor.getDistance(du);
    }

}
