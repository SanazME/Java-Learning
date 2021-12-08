package com.sanaz;

import java.util.Scanner;

public class Main {

    //For example, this code allows a user to read a number from System.in:
    private static Scanner scanner = new Scanner(System.in);

    /*
    * As another example, this code allows long types to be assigned from entries in a file myNumbers:

      Scanner sc = new Scanner(new File("myNumbers"));
      while (sc.hasNextLong()) {
          long aLong = sc.nextLong();
      }
    * */

    public static int[] getIntegers(int number){
        System.out.println("Enter " + number + " integer values.\r");
        int[] values = new int[number];

        for (int i=0; i < values.length; i++){
            values[i] = scanner.nextInt();
        }

        return values;
    }

    public static double getAverage(int[] arr){
        int sum = 0;

        for (int i=0; i < arr.length; i++){
            sum += arr[i];
        }
        return (double) sum / (double) arr.length;
    }

    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);

        for (int i=0; i < myIntegers.length; i++){
            System.out.println(myIntegers[i]);
        }

        System.out.println(getAverage(myIntegers));

    }
}
