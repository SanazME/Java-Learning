package com.sanaz;

public class Main {

    public static void main(String[] args) {
        // Create a new object of datatype Car (our class)
        Car porsche = new Car();
        Car holden = new Car();

        // Car class has inherited these methods/variables from the Base Java Class
        // porsche.<a list will appear>
        System.out.println(porsche.equals(holden));
        System.out.println(porsche.hashCode());
        System.out.println(porsche.toString());
        System.out.println(porsche.getClass());
        System.out.println("***********************");

        // Set & Get the model
        System.out.println("Model is " + porsche.getModel()); // it shows the default value of String class which is null
        porsche.setModel("4X");
        System.out.println("Model is " + porsche.getModel());
        porsche.setModel("Carrera");
        System.out.println("Model is " + porsche.getModel());
    }
}
