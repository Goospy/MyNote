package com.goospy.util;

public class ArrayUtil {

    public static void showArray(int[] arr) {
        for(int a: arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void showArray(int[][] arr) {
        for(int[] a: arr) {
            showArray(a);
        }
    }

}
