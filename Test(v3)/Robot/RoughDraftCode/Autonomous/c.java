package org.firstinspires.ftc.teamcode.Robot.RoughDraftCode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//Made similar to TeleOp d
@Autonomous(name = "c")
public class c extends LinearOpMode {

    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

    @Override
    public void runOpMode() {
        initializeMotors();
        waitForStart();

        moveForward(2.0); // Move forward for 2 seconds
        turn(true, 1.0);  // Turn left for 1 second
        moveForward(2.0); // Move forward for another 2 seconds
        turn(false, 1.0); // Turn right for 1 second
        stopMotors();     // Stop the motors
    }

    // Method to initialize the motors
    private void initializeMotors() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontleft");
        frontRight = hardwareMap.get(DcMotor.class, "frontright");
        backLeft = hardwareMap.get(DcMotor.class, "backleft");
        backRight = hardwareMap.get(DcMotor.class, "backright");

        // Set motor directions if needed
        // frontLeft.setDirection(DcMotor.Direction.REVERSE);
        // backLeft.setDirection(DcMotor.Direction.REVERSE);
    }

    // Method to move forward for a specified duration
    private void moveForward(double seconds) {
        double power = 0.5; // Adjust speed as needed
        setMotorPowers(power);

        // Wait for the specified duration
        sleep((long) (seconds * 1000));
    }

    // Method to turn left or right for a specified duration
    private void turn(boolean left, double seconds) {
        double power = 0.5; // Adjust speed as needed
        if (left) {
            // Set powers for turning left
            frontLeft.setPower(-power);
            backLeft.setPower(-power);
            frontRight.setPower(power);
            backRight.setPower(power);
        } else {
            // Set powers for turning right
            frontLeft.setPower(power);
            backLeft.setPower(power);
            frontRight.setPower(-power);
            backRight.setPower(-power);
        }

        // Wait for the specified duration
        sleep((long) (seconds * 1000));
    }

    // Method to stop the motors
    private void stopMotors() {
        setMotorPowers(0);
    }

    // Helper method to set the power for all motors
    private void setMotorPowers(double power) {
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
    }
}
