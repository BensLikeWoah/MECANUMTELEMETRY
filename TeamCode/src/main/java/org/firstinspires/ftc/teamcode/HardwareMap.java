package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
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
}
