package org.usfirst.frc.team4373.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.IntakeCommand;

/**
 * THIS IS ROODIAGNOSTIC
 */
public class Intake extends PIDSubsystem {

    private double INTAKE_POWER;
    private CANTalon motor;

    public Intake(double p, double i, double d) {
        super("Intake", p, i, d);
        this.motor = new CANTalon(RobotMap.INTAKE_PORT);
    }

    public void setIntakePower(double power) {
        if (power >= 0 && power <= 1) {
            this.INTAKE_POWER = power;
        } else {
            this.INTAKE_POWER = 0;
        }
    }

    public void turnForward() {
        motor.set(INTAKE_POWER);
    }

    public void turnBackward() {
        motor.set(-INTAKE_POWER);
    }

    public void stop() {
        motor.set(0);
    }

    @Override
    protected double returnPIDInput() {
        return 0;
    }

    @Override
    protected void usePIDOutput(double output) {

    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new IntakeCommand());
    }
}
