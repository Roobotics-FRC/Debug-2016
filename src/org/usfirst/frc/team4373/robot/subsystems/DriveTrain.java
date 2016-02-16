package org.usfirst.frc.team4373.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team4373.robot.OI;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team4373.robot.dashboard.RooDashboard;

/**
 * THIS IS ROODIAGNOSTIC
 */
public class DriveTrain extends PIDSubsystem {
    private CANTalon left1, left2, right1, right2;
    private double pidOutput = 0;
    private boolean right1Enabled = false;
    private boolean right2Enabled = false;
    private boolean left1Enabled = false;
    private boolean left2Enabled = false;

    public DriveTrain(double p, double i, double d) {
        super("DriveTrain", p, i, d);
        getPIDController().setContinuous(false);
        this.left1 = new CANTalon(RobotMap.LEFT_DRIVE_MOTOR_1);
        this.left2 = new CANTalon(RobotMap.LEFT_DRIVE_MOTOR_2);
        this.right1 = new CANTalon(RobotMap.RIGHT_DRIVE_MOTOR_1);
        this.right2 = new CANTalon(RobotMap.RIGHT_DRIVE_MOTOR_2);
        OI.getOI().resetGyro();
        setSetpoint(0.0D);
        enable();
    }

    public void setRight1Enabled(boolean enabled) {
        right1Enabled = enabled;
    }
    public void setRight2Enabled(boolean enabled) {
        right2Enabled = enabled;
    }
    public void setLeft1Enabled(boolean enabled) {
        left1Enabled = enabled;
    }
    public void setLeft2Enabled(boolean enabled) {
        left2Enabled = enabled;
    }

    public void setLeft(double power) {
        if (left1Enabled) this.left1.set(-power);
        if (left2Enabled) this.left2.set(power);
    }

    public void setRight(double power) {
        if (right1Enabled) this.right1.set(power);
        if (right2Enabled) this.right2.set(-power);
    }

    public void setBoth(double power) {
        power = -power;
        setLeft(power);
        setRight(power);
    }

    @Override
    protected double returnPIDInput() {
        return 0;}

    @Override
    protected void usePIDOutput(double output) {
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    }

    public double getPidOutput() {
        return pidOutput;
    }
}
