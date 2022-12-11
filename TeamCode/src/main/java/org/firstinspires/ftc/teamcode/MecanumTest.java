package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="MecanumTestMode", group="B.STRECK TESTING")
public class MecanumTest extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftTop;
    private DcMotor leftBack;
    private DcMotor rightTop;
    private DcMotor rightBack;


    public void init() {
        telemetry.addData("Status", "Initializing");

        leftTop = hardwareMap.get(DcMotor.class, "LT");
        leftBack = hardwareMap.get(DcMotor.class, "LB");
        rightTop = hardwareMap.get(DcMotor.class, "RT");
        rightBack = hardwareMap.get(DcMotor.class, "RB");

        telemetry.addData("Status", "Motor Direction Set");

        leftTop.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightTop.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.FORWARD);

        telemetry.addData("Status", "Initialized! Code made by Benjamin Streck :)");
    }

    public void start() {
        runtime.reset();
        telemetry.addData("Status", "Running...");
    }

    public void loop() {
        double leftTopPower;
        double leftBackPower;
        double rightTopPower;
        double rightBackPower;

        double forwardBack = gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        // double rotate = gamepad1.right_stick_x;

        leftTopPower = forwardBack + strafe;
        rightBackPower = forwardBack + strafe;
        rightTopPower = forwardBack - strafe;
        leftBackPower = forwardBack - strafe;

        leftTop.setPower(leftTopPower);
        rightTop.setPower(rightTopPower);
        leftBack.setPower(leftBackPower);
        rightBack.setPower(rightBackPower);


    }


}
