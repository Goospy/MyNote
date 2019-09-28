package com.goospy.sort;

/**
 * Created by Goospy on 2018/1/13.
 */
public class InsertSort {

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] orig = {3, 5, 7, 12, 2, 4};
        SortUtil.show(orig);
        insertSort.sort(orig);
        SortUtil.show(orig);
    }

    public void sort(int[] array) {
        int length = array.length;
        for(int i = 1; i < length; i++) {
            for(int j = i; j > 0 && array[j] < array[j - 1]; j --) {
                SortUtil.exch(array, j, j - 1);
            }
        }
    }

}
