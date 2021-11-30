package com.sanaz;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal(1, 1, 5, 5, "Animal");
        Dog dog = new Dog(6, 10, "Yorki", 2, 4, 1, 20, "long silky");

        // we use base class methods like eat and move in Dog object
        dog.eat();

    }
}
