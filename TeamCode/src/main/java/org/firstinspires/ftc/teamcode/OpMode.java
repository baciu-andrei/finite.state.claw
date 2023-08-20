package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class OpMode extends LinearOpMode {

    public void runOpMode() throws InterruptedException {



        ClawStates claw = new ClawStates(hardwareMap);
        claw.setState(ClawStates.State.OPENING);
        claw.update();

        boolean wasAPressed = false;

        while(opModeIsActive()) {
            if (gamepad1.a&&!wasAPressed) {
                claw.changeState();
            }
            wasAPressed = gamepad1.a;
            claw.update();

        }
    }
}
