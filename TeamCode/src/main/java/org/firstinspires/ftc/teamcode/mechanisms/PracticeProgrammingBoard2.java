package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class PracticeProgrammingBoard2 {
    private DigitalChannel touchSensor;

    public void init(HardwareMap hwMap) {
        touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor");
        touchSensor.setMode(DigitalChannel.Mode.INPUT);
    }

    public boolean getTouchSensorState() { // reverses touch sensor since originally the touch sensor would be true if not touched and false if touched
        if (!touchSensor.getState()) {
            return true;
        }
        return false;
    }

    public boolean isTouchSensorReleased()  {
        getTouchSensorState();
        if (getTouchSensorState() == false) {
            return true;
        }
        return false;
    }
}
