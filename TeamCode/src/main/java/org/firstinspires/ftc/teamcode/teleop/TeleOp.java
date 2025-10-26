package org.firstinspires.ftc.teamcode.teleop;

import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="TeleOp", group="Tele")
public class TeleOp extends LinearOpMode {

    public void runOpMode() throws InterruptedException {
        telemetry = new MultipleTelemetry(telemetry);

        BrainSTEMRobot robot = new BrainSTEMRobot(hardwareMap, telemetry);


        waitForStart();

        while (opModeIsActive()) {
            robot.update();
            updateDrive(robot);
            updateDriver1(robot);

            telemetry.update();
        }
    }

    private void updateDriver1(BrainSTEMRobot robot) {
        driver1CollectorControls(robot);
    }

    private void updateDrive(BrainSTEMRobot robot) {
        robot.drive.drive.setDrivePowers(new PoseVelocity2d(
                new Vector2d(
                        -gamepad1.left_stick_y,
                        -gamepad1.left_stick_x
                ),
                -gamepad1.right_stick_x
        ));
    }
    private void driver1CollectorControls(BrainSTEMRobot robot){

        if (gamepad1.left_bumper) {
            robot.collector.setOut();
        } else if (gamepad1.right_bumper) {
            robot.collector.setIn();
        }
        else {
            robot.collector.setOff();
        }
    }
}
