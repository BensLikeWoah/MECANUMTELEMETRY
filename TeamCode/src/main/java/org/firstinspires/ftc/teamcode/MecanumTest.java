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


    public void runOpMode() {
        telemetry.addData("Status", "Initializing");|
        telemetry.update();

        leftTop = hardwareMap.get(DcMotor.class, "LT");
        leftBack = hardwareMap.get(DcMotor.class, "LB");
        rightTop = hardwareMap.get(DcMotor.class, "RT");
        rightBack = hardwareMap.get(DcMotor.class, "RB");

        telemetry.addData("Status", "Motor Direction Set");
        telemetry.update();

        leftTop.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightTop.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.FORWARD);

        telemetry.addData("Status", "Initialized! Code made by Benjamin Streck :)");
        telemetry.update();
        resetRuntime();
        waitForStart();

        while(opModeIsActive()) {
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

            telemetry.addData("Status", "Time Elapsed" + runtime.toString());
            telemetry.addData("Status", "LT POWER" + leftTop.getPower());
            telemetry.addData("Status", "RT POWER" + rightTop.getPower());
            telemetry.addData("Status", "LB POWER" + leftBack.getPower());
            telemetry.addData("Status", "RB POWER" + rightBack.getPower());
            telemetry.update();

        }
    }
}
