package com.goospy.sort;

import com.goospy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Goospy on 2019/10/2 in Hong Xin Jin Fu
 */
public class QuickSort {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.sort(Integer::compare);

        QuickSort sort = new QuickSort();
        int[] a = {2, 7, 1, 4, 9};
        sort.qs(a, 0, a.length - 1);
        ArrayUtil.showArray(a);
    }

    public void qs(int[] a, int low, int high) {
        if(low >= high) {
            return;
        }

        int pov = getPov(a, low, high);
        qs(a, low, pov - 1);
        qs(a, pov + 1, high);
    }

    public int getPov(int[] a, int low, int high) {
        int temp = a[low];

        while(low < high) {
            while(low < high && a[high] >= temp) high--;
            a[low] = a[high];

            while(low < high && a[low] <= temp) low++;
            a[high] = a[low];
        }

        a[low] = temp;
        return low;
    }

}
