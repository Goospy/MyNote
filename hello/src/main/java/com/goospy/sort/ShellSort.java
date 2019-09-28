package com.goospy.sort;

/**
 * Created by Goospy on 2018/1/13.
 */
public class ShellSort {

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] orig = {3, 5, 7, 12, 2, 4};
        SortUtil.show(orig);
        shellSort.sort(orig);
        SortUtil.show(orig);
    }

    public void sort(int[] array) {
        int length = array.length;
        int h = 1;
        while(h <length/3) {
            h = h*3 + 1;
        }
        while(h >= 1) {
            for(int i = h; i < length; i++) {
                for(int j = i; j >= h && array[j] < array[j - h]; j-= h) {
                    SortUtil.exch(array, j, j - h);
                }
            }

            h = h/3;
        }
    }

}
