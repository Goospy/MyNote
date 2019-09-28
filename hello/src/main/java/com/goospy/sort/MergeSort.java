package com.goospy.sort;

/**
 * Created by Goospy on 2018/1/13.
 */
public class MergeSort {

    private int[] tmp;

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] orig = {3, 5, 7, 12, 2, 4};
        SortUtil.show(orig);
        mergeSort.tmp = new int[orig.length];
        mergeSort.sortL2H(orig);
        SortUtil.show(orig);
    }

    public void sortL2H(int[] array) {
        int length = array.length;
        for(int size = 1; size < length; size+= size) {
            for(int lo = 0; lo < length - size; lo +=size*2) {
                merge(array, lo, lo + size - 1, Math.min(lo + size*2 - 1, length - 1));
            }
        }
    }

    public void sortH2L(int[] array, int lo, int hi) {
        if(lo >= hi) {
            return ;
        }

        int mid = lo + (hi - lo)/2;
        sortH2L(array, lo, mid);
        sortH2L(array, mid + 1, hi);
        merge(array, lo, mid, hi);
    }

    public void merge(int[] array, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for(int k = lo; k <= hi; k++) {
            tmp[k] = array[k];
        }

        for(int k = lo; k <= hi; k++) {
            if(i > mid) {
                array[k] = tmp[j++];
            } else if(j > hi) {
                array[k] = tmp[i++];
            } else if(tmp[j] < tmp[i]) {
                array[k] = tmp[j++];
            } else {
                array[k] = tmp[i++];
            }
        }
    }

}
