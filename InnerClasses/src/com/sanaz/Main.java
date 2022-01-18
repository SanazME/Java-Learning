package com.sanaz;

public class Main {

    public static void main(String[] args) {
        Gearbox gearbox = new Gearbox(6);
        gearbox.addGear(1, 5.3);
        gearbox.addGear(2, 10.6);
        gearbox.addGear(3, 15.9);
        gearbox.operateClutch(true);
        gearbox.changeGear(1);
        gearbox.operateClutch(false);
        System.out.println(gearbox.wheelSpeed(1000));
        gearbox.changeGear(2);
        System.out.println(gearbox.wheelSpeed(3000));
        gearbox.operateClutch(true);
        gearbox.changeGear(3);
        gearbox.operateClutch(false);
        System.out.println(gearbox.wheelSpeed(6000));
    }

}
