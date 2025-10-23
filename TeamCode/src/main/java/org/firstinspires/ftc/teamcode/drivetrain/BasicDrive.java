package org.firstinspires.ftc.teamcode.drivetrain;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Basic Drive", group="Drive")
public class BasicDrive extends LinearOpMode {

    private DcMotor frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor;
    private double driveSpeed = 0.50;  // Default speed multiplier

    @Override
    public void runOpMode() {
        // Initialize motors
        frontLeftMotor = hardwareMap.get(DcMotor.class, "fl");
        frontRightMotor = hardwareMap.get(DcMotor.class, "fr");
        backLeftMotor = hardwareMap.get(DcMotor.class, "bl");
        backRightMotor = hardwareMap.get(DcMotor.class, "br");

        // Set motor directions (adjust based on your robot)
        frontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        // Set motor modes
        setMotorModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        while (opModeIsActive()) {
            // Controller Input Mapping
            // Left stick: Forward/backward and strafe
            // Right stick: Rotation
            double y = -gamepad1.left_stick_y;  // Forward/backward
            double x = gamepad1.left_stick_x;   // Strafing
            double rx = gamepad1.right_stick_x; // Rotation

            // Mecanum drive calculations
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            // Apply speed multiplier
            frontLeftPower *= driveSpeed;
            frontRightPower *= driveSpeed;
            backLeftPower *= driveSpeed;
            backRightPower *= driveSpeed;

            // Set motor powers
            frontLeftMotor.setPower(frontLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backLeftMotor.setPower(backLeftPower);
            backRightMotor.setPower(backRightPower);

            // Telemetry
            updateTelemetry();
        }
    }

    private void setMotorModes(DcMotor.RunMode mode) {
        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);
        backLeftMotor.setMode(mode);
        backRightMotor.setMode(mode);
    }

    private void updateTelemetry() {
        telemetry.addData("Speed Multiplier", driveSpeed);
        telemetry.addData("Controls", "Left Stick: Move/Strafe | Right Stick: Rotate");
        telemetry.addData("LBumper", "Precision Mode");
        telemetry.addData("RBumper", "Turbo Mode");
        telemetry.update();
    }
}
