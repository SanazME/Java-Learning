package com.sanaz;

import java.util.Arrays;

public class ReverseArray {

    public static void reverse(int[] arr){
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


}
