package org.firstinspires.ftc.teamcode.teleop;

import androidx.core.view.KeyEventDispatcher;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.drivetrain.BasicDrive;
import org.firstinspires.ftc.teamcode.teleop.subsystem.Collector;
import org.firstinspires.ftc.teamcode.teleop.subsystem.Shooter;
import org.firstinspires.ftc.teamcode.teleop.subsystem.Whisk;

import java.util.ArrayList;

public class BrainSTEMRobot {
    private final Telemetry telemetry;
    HardwareMap map;
    public BasicDrive drive;
    Collector collector;
    Shooter shooter;
    Whisk whisk;
    public DcMotor frontLeft, frontRight, backLeft, backRight;
    public BrainSTEMRobot(HardwareMap map, Telemetry telemetry) {
        this.map = map;
        this.telemetry = telemetry;
        frontLeft = map.get(DcMotor.class, "FL");
        frontRight = map.get(DcMotor.class, "FR");
        backLeft = map.get(DcMotor.class, "BL");
        backRight = map.get(DcMotor.class, "BR");
    }
}
