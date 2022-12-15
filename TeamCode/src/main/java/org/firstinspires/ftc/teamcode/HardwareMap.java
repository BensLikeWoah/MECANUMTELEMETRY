package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcontroller.external.samples.RobotHardware;


public class HardwareMap {

    private LinearOpMode benOpMode = null;

    private DcMotor leftTop = null;
    private DcMotor rightTop = null;
    private DcMotor leftBack = null;
    private DcMotor rightBack = null;

    private DcMotor linearSlide = null;
    private DcMotor slideTurret = null;

    private Servo intakeArm = null;
    private Servo intakeClaw = null;
    private Servo outtakeArm = null;
    private Servo outtakeClaw = null;

    public static final double CLAW_OPEN = 0.5;
    public static final double CLAW_CLOSED = 1.0;
    public static final double ARM_DOWN = 0.0;
    public static final double ARM_UP = 1.0;

    public RobotHardware (LinearOpMode opmode) { benOpMode = opmode;}

    public void init() {
        /** initializing DcMotors */
        leftTop = benOpMode.hardwareMap.get(DcMotor.class, "LT");
        rightTop = benOpMode.hardwareMap.get(DcMotor.class, "RT");
        leftBack = benOpMode.hardwareMap.get(DcMotor.class, "LB");
        rightBack = benOpMode.hardwareMap.get(DcMotor.class, "RB");
        linearSlide = benOpMode.hardwareMap.get(DcMotor.class, "LS");
        slideTurret = benOpMode.hardwareMap.get(DcMotor.class, "ST");

        benOpMode.telemetry.addData("Status", "Motors initialized, pending direction set...");
        benOpMode.telemetry.update();

        /** direction set for DcMotors */
        leftTop.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightTop.setDirection(DcMotor.Direction.FORWARD);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        linearSlide.setDirection(DcMotor.Direction.FORWARD);
        slideTurret.setDirection(DcMotor.Direction.FORWARD);

        benOpMode.telemetry.addData("Status", "Motor directions set, pending servo init...");
        benOpMode.telemetry.update();

        /** initializing Servos */
        intakeArm = benOpMode.hardwareMap.get(Servo.class, "IA");
        intakeClaw = benOpMode.hardwareMap.get(Servo.class, "IC");
        outtakeArm = benOpMode.hardwareMap.get(Servo.class, "OA");
        outtakeClaw = benOpMode.hardwareMap.get(Servo.class, "OC");

        benOpMode.telemetry.addData("Status", "Servos initialized, pending position set...");
        benOpMode.telemetry.update();

        /** Servo Pos. Set */
        intakeArm.setPosition(ARM_UP);
        outtakeArm.setPosition(ARM_DOWN);
        intakeClaw.setPosition(CLAW_OPEN);
        outtakeClaw.setPosition(CLAW_CLOSED);

        benOpMode.telemetry.addData("Status", "Initialization complete, ready to start.");
        benOpMode.telemetry.update();
    }

    public void DriveBot() {
        double leftTopPower;
        double leftBackPower;
        double rightTopPower;
        double rightBackPower;

        double forwardBack = gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double rotate = gamepad1.right_stick_x;

        double max = Math.max(Math.abs(forwardBack) + Math.abs(strafe) + Math.abs(rotate), 1);

        leftTopPower = forwardBack + strafe + rotate;
        rightBackPower = forwardBack + strafe - rotate;
        rightTopPower = forwardBack - strafe - rotate;
        leftBackPower = forwardBack - strafe + rotate;

        if(max > 1.0) {
            leftTopPower /= max;
            leftBackPower /= max;
            rightTopPower /= max;
            rightBackPower /= max;
        }

        leftTop.setPower(leftTopPower);
        rightTop.setPower(rightTopPower);
        leftBack.setPower(leftBackPower);
        rightBack.setPower(rightBackPower);

        benOpMode.telemetry.addData("Status", "LT POWER" + leftTop.getPower());
        benOpMode.telemetry.addData("Status", "RT POWER" + rightTop.getPower());
        benOpMode.telemetry.addData("Status", "LB POWER" + leftBack.getPower());
        benOpMode.telemetry.addData("Status", "RB POWER" + rightBack.getPower());
        benOpMode. telemetry.update();
    }
}
