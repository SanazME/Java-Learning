package com.sanaz;

public class Tesla extends Car {
    private int batteries;
    private boolean navigation;

    public Tesla(int batteries, boolean navigation) {
        super("Tesla", "AWD", 4, 4, 6, false);
        this.batteries = batteries;
        this.navigation = navigation;
    }

    public void accelerate(int rate){
        int newSpeed = getCurrentSpeed() + rate;

        if (newSpeed ==0){
            stop();
            changeGear(1);
        } else if (newSpeed > 0 && newSpeed <= 10){
            changeGear(1);
        } else if (newSpeed > 10  && newSpeed <= 20){
            changeGear(2);
        } else if (newSpeed < 20 && newSpeed <= 30){
            changeGear(3);
        } else {
            changeGear(4);
        }

        if (newSpeed > 0) {
            changeVelocity(newSpeed, getCurrentDirection());
        }
    }



}
