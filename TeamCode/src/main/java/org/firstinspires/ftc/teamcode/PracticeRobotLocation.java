package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

public class PracticeRobotLocation {
    double angle;
    double x;
    double y;

    public PracticeRobotLocation(double angle) {
        this.angle = angle;
    }

    public double getHeading() {
        double angle = this.angle;
        while(angle > 180) {
            angle -= 360;
        }
        while(angle < -180) {
            angle += 360;
        }
        return angle;
    }

    @Override
    public String toString() {
        return "RobotLocation: angle (" + angle + ")";
    }

    public void turn(double angleChange) {
        angle += angleChange;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }

    public double getX() {
        return x;
    }

    public void changeX(double change) {
        x += change;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void changeY(double change) {
        y += change;
    }

    public void setY(double y) {
        this.y = y;
    }
}
