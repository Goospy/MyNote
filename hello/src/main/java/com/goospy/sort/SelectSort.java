package com.goospy.sort;

/**
 * Created by Goospy on 2018/1/13.
 */
public class SelectSort {

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] orig = {3, 5, 7, 12, 2, 4};
        SortUtil.show(orig);
        selectSort.sort(orig);
        SortUtil.show(orig);
    }

    public void sort(int[] array) {
        int length = array.length;
        for(int i = 0; i < length; i++) {
            int min = i;
            for(int j = i + 1; j < length; j ++) {
                if(array[min] > array[j]) {
                    min = j;
                }
            }
            if(min != i) {
                SortUtil.exch(array, min, i);
            }
        }
    }

}
