package com.goospy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Goospy on 2019/10/2 in Hong Xin Jin Fu
 */
public class L384 {

    private int[] origin;

    private Random random = new Random();

    public L384(int[] nums) {
        origin = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return Arrays.copyOf(origin, origin.length);
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> list = new ArrayList<>();

        int[] shuffle = new int[origin.length];
        for(int i = 0; i < origin.length; i++) {
            list.add(origin[i]);
        }

        for(int i = 0; i < origin.length; i++) {
            int idx = random.nextInt(origin.length - i);
            shuffle[i] = list.get(idx);
            list.remove(idx);
        }
        return shuffle;
    }

}
