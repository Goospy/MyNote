package com.goospy.leetcode;

import java.util.*;

/**
 * Created by Goospy on 2019/10/2 in Hong Xin Jin Fu
 */
public class L380 {

    private Map<Integer, Integer> indexMap = new HashMap<>();

    private List<Integer> data = new ArrayList<>();

    private Random random = new Random();

    public static void main(String[] args) {
        L380 l380 = new L380();
        l380.insert(0);
        l380.remove(0);
        l380.insert(-1);
        l380.remove(0);
        l380.getRandom();
    }

    /** Initialize your data structure here. */
    public L380() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(null != indexMap.get(val)) {
            return false;
        }

        data.add(val);
        indexMap.put(val, data.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer idx = indexMap.get(val);
        if(null == idx) {
            return false;
        }

        indexMap.remove(val);
        if(data.size() == 1) {
            data.remove(0);
            return true;
        }
        int lastVal = data.get(data.size() - 1);
        data.set(idx, lastVal);
        data.remove(data.size() - 1);
        indexMap.put(lastVal, idx);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return data.get(random.nextInt(data.size()));
    }

}
