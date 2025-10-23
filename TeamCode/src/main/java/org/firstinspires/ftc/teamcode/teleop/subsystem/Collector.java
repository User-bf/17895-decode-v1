package org.firstinspires.ftc.teamcode.teleop.subsystem;

import android.text.style.UpdateAppearance;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.teleop.Component;

public class Collector implements Component {
    Telemetry telemetry;
    HardwareMap map;
    UpdateAppearance update;
    public enum CollectorState {
        FORWARD, OFF, REVERSE
    }
    CollectorState collectorState;
    private DcMotor collectorMotor;
    public Collector(HardwareMap map, Telemetry telemetry){
        this.map = map;
        this.telemetry = telemetry;
        collectorMotor = map.get(DcMotor.class, "collector");
        collectorState = CollectorState.OFF;
    }
    public void setCollectorPower(double power){
        collectorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        collectorMotor.setPower(power);
    }
    public void reset () {

    }

    public void update () {
        switch(collectorState){
            case OFF:{
                setCollectorPower(0);
                break;
            }
            case FORWARD:{
                setCollectorPower(0.7);
                break;
            }
            case REVERSE:{
                setCollectorPower(-0.7);
                break;
            }

        }
    }
    public String test () {
        return null;
    }
}
