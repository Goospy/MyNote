package com.goospy.note;

import com.goospy.util.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Combination {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        Combination combination = new Combination();
        combination.subSets(arr).stream().forEach(ListUtil::showList);
    }

    public List<List<Integer>> subSets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        backTrace(result, new ArrayList<>(), arr, 0);
        return result;
    }

    private void backTrace(List<List<Integer>> result, List<Integer> list, int[] arr, int start) {
        result.add(new ArrayList<>(list));
        for(int i = start; i < arr.length; i++) {
            if(i > start && arr[i] == arr[i - 1]) continue;
            list.add(arr[i]);
            backTrace(result, list, arr, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
