package com.sanaz;
/*
* -Write a method called reverse() with an int array as a parameter.

-The method should not return any value. In other words, the method is allowed to modify the array parameter.

-In main() test the reverse() method and print the array both reversed and non-reversed.

-To reverse the array, you have to swap the elements, so that the first element is swapped with the last element and so on.

-For example, if the array is {1, 2, 3, 4, 5}, then the reversed array is {5, 4, 3, 2, 1}.


Tip:
	-Create a new console project with the name ÅeReverseArrayChallengeÅf
* */

import java.util.Arrays;

public class Main {

    private static void reverse(int[] arr){
        int size = arr.length;
        int stopIdx = size / 2;

        System.out.println("Array before: " + Arrays.toString(arr));

        int tmp;
        for (int i=0; i < stopIdx; i++){
            tmp = arr[i];
            arr[i] = arr[size - i - 1];
            arr[size - i -1] = tmp;
        }

        System.out.println("Array after: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr1= {1,2,3};
        reverse(arr1);
    }
}
