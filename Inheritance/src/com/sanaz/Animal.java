package com.sanaz;

public class Animal {

    private int brain, body, size, weight;
    private String name;

    public Animal(int brain, int body, int size, int weight, String name) {
        this.brain = brain;
        this.body = body;
        this.size = size;
        this.weight = weight;
        this.name = name;
    }

    public int getBrain() {
        return brain;
    }

    public int getBody() {
        return body;
    }

    public int getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void eat(){
        System.out.println("Animal.eat() is called!");
    }

    public void move(){

    }
}
