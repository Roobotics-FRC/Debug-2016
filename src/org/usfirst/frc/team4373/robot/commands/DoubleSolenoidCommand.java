package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.input.hid.RooJoystick;
import org.usfirst.frc.team4373.robot.subsystems.RooDoubleSolenoid;

/**
 * THIS IS ROODIAGNOSTIC
 */
public class DoubleSolenoidCommand extends CommandBase {

    private RooDoubleSolenoid solenoid;
    private RooJoystick joystick;

    public DoubleSolenoidCommand() {
        super();
        this.joystick = this.oi.getJoystick();
        this.solenoid = Robot.solenoid;
        requires(this.solenoid);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (joystick.getRawButton(RobotMap.SOLENOID_BUTTON_FORWARD)) {
            solenoid.setForward();
        } else if (joystick.getRawButton(RobotMap.SOLENOID_BUTTON_REVERSE)) {
            solenoid.setReverse();
        } else if (joystick.getRawButton(RobotMap.SOLENOID_BUTTON_STOP)) {
            solenoid.stop();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
