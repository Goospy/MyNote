package com.goospy.sort;

/**
 * Created by Goospy on 2018/1/13.
 */
public class SortUtil {

    public static void exch(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }

    public int[] test() {
        return new int[]{1, 2};
    }

    public static void show(int[] array) {
        for(int a: array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {2, 9, 1, 3, 0, 5};
        qs(a, 0, a.length - 1);
        show(a);
    }

    public static void qs(int[] a, int low, int high) {
        if(low < high) {
            int idx = getIdx(a, low, high);
            qs(a, low, idx - 1);
            qs(a, idx + 1, high);
        }
    }

    public static int getIdx(int[] a, int low, int high) {
        int temp = a[low];
        while(low < high) {
            while(low < high && a[high] > temp) high--;
            a[low] = a[high];

            while(low < high && a[low] < temp) low++;
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }
}
