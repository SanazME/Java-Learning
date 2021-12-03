package com.sanaz;

public class Main {

    public static void main(String[] args) {
        Motherboard motherboard = new Motherboard("X12", "someManufacturer", 4, 5, "BIOX");

        Case myCase = new Case("model", "man", "power", new Dimensions(23, 10, 5));

        Monitor monitor = new Monitor("model", "man", 23, new Resolution(33, 22));

	    PC myPc = new PC(motherboard, myCase, monitor);

        // To access a method of a class
        myPc.powerUp();
    }
}
