package com.goospy.leetcode;

import com.goospy.common.DataBuilder;
import com.goospy.common.TreeNode;

/**
 * Created by Goospy on 2019/10/6 in Hong Xin Jin Fu
 */
public class L124 {

    private int maxPath = Integer.MIN_VALUE;

    public static void main(String[] args) {
        L124 l124 = new L124();
        TreeNode root = DataBuilder.getTreeNode(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1});
        System.out.println(l124.maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        getMaxPath(root);
        return maxPath;
    }

    private int getMaxPath(TreeNode root) {
        if(null == root) {
            return 0;
        }

        int left = Math.max(getMaxPath(root.left), 0);
        int right = Math.max(getMaxPath(root.right), 0);

        int rootSum = left + right + root.val;
        if(maxPath < rootSum) {
            maxPath = rootSum;
        }

        return root.val + Math.max(0, Math.max(left, right));
    }

}
