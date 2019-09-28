package com.goospy.leetcode;

import com.goospy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L98 {

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    void inOrder(TreeNode root, List<Integer> list) {
        if(null == root) {
            return ;
        }

        inOrder(root.left, list);

        list.add(root.val);

        inOrder(root.right, list);
    }

}
