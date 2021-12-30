package com.sanaz;

public class Main {

    public static void main(String[] args) {
        ITelephone bobPhone;
        bobPhone = new DeskPhone(12324);

        bobPhone.powerOn();
        bobPhone.callPhone(12324);
        bobPhone.answer();
    }
}
