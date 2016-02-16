package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team4373.robot.commands.AutonCollisionAvoid;
import org.usfirst.frc.team4373.robot.dashboard.RooDashboard;
import org.usfirst.frc.team4373.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4373.robot.subsystems.Intake;
import org.usfirst.frc.team4373.robot.subsystems.RooDoubleSolenoid;

/**
 * THIS IS ROODIAGNOSTIC
 */
public class Robot extends IterativeRobot {
    private CANTalon talon;
    private RooDashboard db;

    @Override
    public void robotInit() {
        this.talon = new CANTalon(0);
        this.db = RooDashboard.getDashboard();
    }

    public static DigitalInput limitSwitch0 = new DigitalInput(RobotMap.LIMIT_SWITCH_PORT_1);
    public static DigitalInput limitSwitch1 = new DigitalInput(RobotMap.LIMIT_SWITCH_PORT_2);
    public static RooDoubleSolenoid solenoid = new RooDoubleSolenoid(1, 0, 0);
    public static DriveTrain driveTrain = new DriveTrain(1, 0, 0);
    public static Intake intake = new Intake(1, 0, 0);

    @Override
    public void teleopInit() {
        db.execute();
    }

    @Override
    public void teleopPeriodic() {
        this.talon.set(1.0D);
        Scheduler.getInstance().run();
        OI.getOI().tick();
        intake.setIntakePower(db.getNumber("Intake Power"));
        driveTrain.setRight1Enabled(db.getBoolean("Right Motor 1"));
        driveTrain.setRight2Enabled(db.getBoolean("Right Motor 2"));
        driveTrain.setLeft1Enabled(db.getBoolean("Left Motor 1"));
        driveTrain.setLeft2Enabled(db.getBoolean("Left Motor 2"));
    }
}
