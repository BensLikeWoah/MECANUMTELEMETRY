package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "HardwareTestingMode", group = "B.STRECK TESTING")
public class HardwareTester extends OpMode {

    private final ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftTop = null;
    private DcMotor leftBack = null;
    private DcMotor rightTop = null;
    private DcMotor rightBack = null;

    public void init() {
        telemetry.addData("Status", "Initialization In Progress (1/3)");
        telemetry.update();

        leftTop = hardwareMap.get(DcMotor.class, "LT");
        leftBack = hardwareMap.get(DcMotor.class, "LB");
        rightTop = hardwareMap.get(DcMotor.class, "RT");
        rightBack = hardwareMap.get(DcMotor.class, "RB");

        telemetry.addData("Status", "Initialization In Progress (2/3)");
        telemetry.update();

        leftTop.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightTop.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.FORWARD);

        telemetry.addData("Status", "Initialization Complete (3/3)");
        telemetry.update();
    }

    public void start() {
        runtime.reset();
        telemetry.addData("Status", "Started");
        telemetry.update();
    }

    public void loop() {
        double leftTopPower;
        double leftBackPower;
        double rightTopPower;
        double rightBackPower;

        boolean lt = gamepad1.dpad_up;
        boolean rt = gamepad1.dpad_down;
        boolean lb = gamepad1.dpad_left;
        boolean rb = gamepad1.dpad_right;

        if(lt && rt && rb && lb) {
            telemetry.addData("Status", "Drive Motor Code fine, if broken, check hardware");
            telemetry.update();
        } else {
            telemetry.addData("Status", "Something is wrong with the drive motors! Ouch...");
            telemetry.update();
        }


    }

    public void stop() {
        telemetry.addData("Status", "Thank you for using Ben's HardwareTester! Go 10539 & 333!");
        telemetry.update();
    }

}
