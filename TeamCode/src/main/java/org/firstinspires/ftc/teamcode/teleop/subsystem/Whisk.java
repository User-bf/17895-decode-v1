//package org.firstinspires.ftc.teamcode.teleop.subsystem;
//
//import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
//
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//import org.firstinspires.ftc.robotcore.external.Telemetry;
//import org.firstinspires.ftc.teamcode.teleop.Component;
//import org.firstinspires.ftc.teamcode.util.PIDController;
//
//public class Whisk implements Component {
//    public Whisk() {
//
//    }
//
//    @Override
//    public void reset() {
//
//    }
//
//    @Override
//    public void update() {
//
//    }
//
//    @Override
//    public String test() {
//        return "";
//    }
//
//    public static class Params {
//
//
//        public double WhiskKp = 67;
//        public double WhiskKi = 67;
//        public double WhishKd = 67;
//        public double WhiskKs = 67;
//        public double COLLECT1 = 67;
//        public double COLLECT2 = 67;
//        public double COLLECT3 = 67;
//        public double SHOOT1 = 67;
//        public double SHOOT2 = 67;
//        public double SHOOT3 = 67;
//    }
//    public static Whisk.Params SHOOTER_PARAMS = new Params();
//
//
//        Telemetry telemetry;
//        HardwareMap map;
//        PIDController WhiskController;
//        public DcMotorEx WhiskMotor;
//    public Whisk(HardwareMap hardwareMap, Telemetry telemetry) {
//        WhiskController = new PIDController(PARAMS.liftKp, PARAMS.liftKi, PARAMS.liftKd, telemetry);
//        WhiskController.setInputBounds(0, 1500);
//        WhiskController.setOutputBounds(-0.1, 0.99);
//
//
//    }
//
//
//    public enum WhiskState{
//        COLLECT1,
//        COLLECT2,
//        COLLECT3,
//        SHOOT1,
//        SHOOT2,
//        SHOOT3,
//    }
//    public void setMotorPower(double power) {
//        WhiskMotor.setPower(power);
//    }
//    @Override
//    public void reset() {
//        WhiskMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        WhiskMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//    }
//}
//
