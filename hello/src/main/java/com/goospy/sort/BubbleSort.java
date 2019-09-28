package com.goospy.sort;

/**
 * Created by Goospy on 2018/12/2.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {3, 6, 2, 1, 9, 4};
        for(int i = 0; i < array.length; i++) {
            int minIndex = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex == i) {
                continue;
            }
            SortUtil.exch(array, minIndex, i);
        }
        SortUtil.show(array);

        int[] array1 = {3, 6, 2, 1, 9, 4};
        for(int i = 0; i < array1.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array1.length - 1; j++) {
                if(array1[j] > array1[j + 1]) {
                    isSorted = false;
                    SortUtil.exch(array1, j, j + 1);
                }
            }
            if(isSorted) {
                break;
            }
        }
        SortUtil.show(array1);

        int[] array2 = {3, 6, 2, 1, 9, 4};
        for(int i = 1; i < array2.length; i++) {
            int value = array2[i];
            int j = i - 1;
            for(; j >= 0; j--) {
                if(array2[j] > value) {
                    //SortUtil.exch(array2, j, j + 1);
                    array2[j + 1] = array2[j];
                } else {
                    break;
                }
            }
            array2[j + 1] = value;
        }
        SortUtil.show(array2);

        int[] array3 = {3, 6, 2, 1, 9, 4};
        qs(array3, 0, array3.length - 1);
        SortUtil.show(array3);
    }

    private static void qs(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int mid = quickSort(array, left, right);
        qs(array, left, mid - 1);
        qs(array, mid + 1, right);
    }

    private static int quickSort(int[] array, int left, int right) {
        int mid = left + (right - left) >> 1;
        int povit = array[mid];

        int low = left, high = right;
        while(low < high) {
            while(array[low] < povit && low < high) low++;
            if(low == high) {
                return high;
            }
            SortUtil.exch(array, low, mid);
            mid = low + 1;

            while(array[high] > povit && high > low) high--;
            if(low == high) {
                return low;
            }
            SortUtil.exch(array, high, mid);
            mid = high - 1;
        }

        return mid;
    }

}
