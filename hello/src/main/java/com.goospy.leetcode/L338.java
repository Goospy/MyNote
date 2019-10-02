package com.goospy.leetcode;

import com.goospy.util.ArrayUtil;
import com.goospy.util.ListUtil;

import java.util.Random;

public class L338 {

    public static void main(String[] args) {
        new Random().nextInt();
        ArrayUtil.showArray(new L338().countBits(5));
    }

    public int[] countBits(int num) {
        if(0 == num) {
            return new int[]{};
        }
        int[] result = new int[num + 1];

        int count = 1, bits = 1;
        for(int i = 1; i <= num; i++) {
            int temp = count;
            while(temp <= num) {
                result[temp] = bits;
                temp = temp << 1;
            }
            count = (count << 1) + 1;
            bits++;
        }
        return result;
    }

}
