package com.sanaz;
// Create a program using arrays that sorts a list of integers in descending order.
// Descending order is highest value to lowest.
// In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
// ultimately have an array with 106,81,26, 15, 5 in it.
// Set up the program so that the numbers to sort are read in from the keyboard.
// Implement the following methods - getIntegers, printArray, and sortIntegers
// getIntegers returns an array of entered integers from keyboard
// printArray prints out the contents of the array
// and sortIntegers should sort the array and return a new array containing the sorted numbers
// you will have to figure out how to copy the array elements from the passed array into a new
// array and sort them and return the new sorted array.

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static int[] getIntegers(int number) {
        int[] arr = new int[number];
        System.out.println("Enter " + number + " of integers: \r");

        for (int i=0; i < arr.length; i++){
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static void printArray(int[] arr){
        for (int i=0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static int[] sortIntegers(int[] arr){
        int[] sortedArr = new int[arr.length];

        // Creating a copy of arr
        for (int i=0; i < arr.length; i++ ) {
            sortedArr[i] = arr[i];
        }

        // Sorting
        for (int i=0; i < sortedArr.length; i++){
            for (int j=i+1; j < sortedArr.length; j++){
                int tmp;
                if (sortedArr[j] > sortedArr[i]){
                    tmp = sortedArr[i];
                    sortedArr[i] = sortedArr[j];
                    sortedArr[j] = tmp;
                }
            }
        }
        return sortedArr;
    }

    public static void main(String[] args) {
        // create an array
        int[] myIntegers = getIntegers(5);

        // print an array
        printArray(myIntegers);

        // Sort an array
        int[] sortedArr = sortIntegers(myIntegers);
        printArray(sortedArr);
    }


}
