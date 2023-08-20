package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class ClawStates {
    Servo claw;
    ElapsedTime timer;
    public static double opened=0.7;
    public static double closed=0.5;

    public enum State {

        OPENED(opened),
        CLOSED(closed),
        OPENING(opened),
        CLOSING(closed);
        double poz;
        State(double poz) {
            this.poz = poz;
        }
    }
    State currentState = State.OPENED;
    public ClawStates(HardwareMap hm){
        claw=hm.get(Servo.class,"claw");
        timer.startTime();
    }

    public void update(){
        if(timer.milliseconds()>=500&&currentState==State.OPENING)
        {
            currentState=State.OPENED;
        }
        else if(timer.milliseconds()>=500&&currentState==State.CLOSING)
        {
            currentState=State.CLOSED;
        }
        claw.setPosition(currentState.poz);
    }
    public void setState(State newState){
        currentState = newState;
        timer.reset();
    }
    double getPoz(){
        return currentState.poz;
    }
    public void changeState()
    {
        if(currentState==State.OPENED) {
            setState(State.CLOSING);
        }
        if(currentState==State.CLOSED) {
            setState(State.OPENING);
        }
    }

}
