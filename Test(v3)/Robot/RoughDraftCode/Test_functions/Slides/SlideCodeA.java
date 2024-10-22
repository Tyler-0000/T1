package org.firstinspires.ftc.teamcode.Robot.RoughDraftCode.Test_functions.Slides;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
//For slides
@TeleOp(name = "Linear Slide TeleOp")
public class SlideCodeA extends LinearOpMode {

    private DcMotor slideMotor;

    @Override
    public void runOpMode() {
        // Initialize the slide motor
        slideMotor = hardwareMap.get(DcMotor.class, "slideMotor");

        // Set motor direction if needed
        // slideMotor.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        // Main control loop
        while (opModeIsActive()) {
            // Control the slide with Y and A buttons
            if (gamepad1.y) {
                // Move the slide up
                slideMotor.setPower(1.0); // Adjust speed as needed
            } else if (gamepad1.a) {
                // Move the slide down
                slideMotor.setPower(-1.0); // Adjust speed as needed
            } else {
                // Stop the slide when no input
                slideMotor.setPower(0);
            }

            // Optional telemetry
            telemetry.addData("Slide Power", slideMotor.getPower());
            telemetry.update();
        }

        // Stop the slide motor when op mode is stopped
        slideMotor.setPower(0);
    }
}