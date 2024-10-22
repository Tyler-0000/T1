package org.firstinspires.ftc.teamcode.Robot.RoughDraftCode.Test_functions.Arm;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name = "ArmA")
public class ArmCodeA extends LinearOpMode {

    private Servo armServo;

    @Override
    public void runOpMode() {
        // Initialize the servo
        armServo = hardwareMap.get(Servo.class, "armServo");

        // Set initial position (optional)
        armServo.setPosition(0.0); // Lower the arm initially

        waitForStart();

        // Main control loop
        while (opModeIsActive()) {
            // Move the servo based on bumper input
            if (gamepad1.left_bumper) {
                armServo.setPosition(1.0); // Raise the arm
            } else if (gamepad1.right_bumper) {
                armServo.setPosition(0.0); // Lower the arm
            }

            // Optional telemetry to monitor servo position
            telemetry.addData("Servo Position", armServo.getPosition());
            telemetry.update();
        }
    }
}