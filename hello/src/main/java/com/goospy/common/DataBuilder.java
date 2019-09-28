package com.goospy.common;

public class DataBuilder {

    public static void main(String[] args) {
        TreeNode node = getTreeNode(new Integer[]{1, 2, 3, 4, null, 5});
        System.out.println(node.val);
    }

    public static TreeNode getTreeNode(Integer[] tree) {
        TreeNode[] node = new TreeNode[tree.length];
        for(int i = 0; i < tree.length; i++) {
            TreeNode treeNode = get(i, node, tree);
            if(null != treeNode) {
                treeNode.left = get(2*i + 1, node, tree);
                treeNode.right = get(2*i + 2, node, tree);
            }
        }
        return node[0];
    }

    private static TreeNode get(Integer idx, TreeNode[] node, Integer[] tree) {
        if(idx > tree.length - 1 || null == tree[idx]) {
            return null;
        }

        if(node[idx] == null) {
            node[idx] = new TreeNode(tree[idx]);
        }
        return node[idx];
    }

}
