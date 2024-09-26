package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class FirstTimer extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        ElapsedTime timer = new ElapsedTime();


        waitForStart();
        while(opModeIsActive()){
            // can be measured in millinsecond, nanoseconds or seconds
            double seconds = timer.seconds();
            double milliseconds = timer.milliseconds();
            double nanoseconds = timer.nanoseconds();

            // resets to zero
            timer.reset();

        }
    }
}
