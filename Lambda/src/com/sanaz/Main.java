package com.sanaz;

public class Main {

    public static void main(String[] args) {
        // option 1: define a concrete class
	    new Thread(new CodeToRun()).start();

        // option 2: anonymous class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from the Runnable");
            }
        }).start();

        // option 3. Lambda expression - multiple lines
        new Thread(() -> {
            System.out.println("Printing from the Runnable");
            System.out.println("Line 2");
            System.out.format("This is line %d\n", 3);
        }).start();
    }
}

class CodeToRun implements Runnable{
    @Override
    public void run() {
        System.out.println("Printing from the Runnable");
    }
}
