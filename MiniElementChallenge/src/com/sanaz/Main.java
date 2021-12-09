package com.sanaz;
/*
* -Write a method called readIntegers() with a parameter called count that represents how many integers the user needs to enter.

-The method needs to read from the console until all the numbers are entered, and then return an array containing the numbers entered.

-Write a method findMin() with the array as a parameter. The method needs to return the minimum value in the array.

-In the main() method read the count from the console and call the method readIntegers() with the count parameter.

-Then call the findMin() method passing the array returned from the call to the readIntegers() method.

-Finally, print the minimum element in the array.

Tips:
	-Assume that the user will only enter numbers, never letters
	-For simplicity, create a Scanner as a static field to help with data input
	-Create a new console project with the name ÅeMinElementChallengeÅf
* */


import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static int[] readIntegers(int number){
        int[] arr = new int[number];
        System.out.println("Enter " + number + " of integers:");

        for (int i=0; i < arr.length; i++){
            System.out.println("Enter a number:");
            int input = scanner.nextInt();
            arr[i] =input;
        }
        return arr;
    }

    public static int findMin(int[] arr){
        int minVal = Integer.MAX_VALUE;

        for (int i=0; i < arr.length; i++){
            if (arr[i] < minVal ){
                minVal = arr[i];
            }
        }
        return minVal;
    }

    public static void main(String[] args) {
        System.out.println("Enter count:");
        int count = scanner.nextInt();
	    int[] arr = readIntegers(count);
        int minVal = findMin(arr);

        System.out.println(minVal);
    }
}
