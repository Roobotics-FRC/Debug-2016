package org.usfirst.frc.team4373.robot.dashboard;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4373.robot.OI;
import org.usfirst.frc.team4373.robot.Robot;

/**
 * THIS IS ROODIAGNOSTIC
 */
public class RooDashboard extends SmartDashboard {
    private static RooDashboard dashboard = null;

    public RooDashboard() {
        super();
    }

    public static RooDashboard getDashboard() {
        if (dashboard == null) {
            dashboard = new RooDashboard();
        }
        return dashboard;
    }

    public static void execute() {
        putNumber("Intake Power", 0);
        putBoolean("Left Motor 1", false);
        putBoolean("Left Motor 2", false);
        putBoolean("Right Motor 1", false);
        putBoolean("Right Motor 2", false);
    }

    public static void tick() {
        putNumber("Joystick twist", OI.getOI().getJoystick().getTwist());
        putNumber("Joystick magnitude", OI.getOI().getJoystick().getMagnitude());
        putNumber("Gyro angle", OI.getOI().getAngle());
        putNumber("Ultrasonic", OI.getOI().getDistance());
        putNumber("Acceleration X", OI.getOI().getAccelerometer().getX());
        putNumber("Acceleration Y", OI.getOI().getAccelerometer().getY());
        putNumber("Velocity X", OI.getOI().getAccelerometer().getCurrentXVelocity());
        putNumber("Velocity Y", OI.getOI().getAccelerometer().getCurrentYVelocity());
        putNumber("Position X", OI.getOI().getAccelerometer().getCurrentXPosition());
        putNumber("Position Y", OI.getOI().getAccelerometer().getCurrentYPosition());
        putNumber("Solenoid State", Robot.solenoid.getPosition());
        putBoolean("Limit Switch 0", Robot.limitSwitch0.get());
        putBoolean("Limit Switch 1", Robot.limitSwitch1.get());
    }
}
