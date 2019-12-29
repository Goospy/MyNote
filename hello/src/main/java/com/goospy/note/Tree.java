package com.goospy.note;

import com.goospy.common.DataBuilder;
import com.goospy.common.TreeNode;
import com.goospy.util.ListUtil;

import java.util.*;

public class Tree {

    public static void main(String[] args) {
        Integer[] t = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode node = DataBuilder.getTreeNode(t);
        Tree tree = new Tree();
        ListUtil.showList(tree.preOrder(node));
        ListUtil.showList(tree.inorderTraversal(node));
        ListUtil.showList(tree.posOrderUnRecursion1(node));
        ListUtil.showList(tree.posOrderUnRecursion2(node));
        ListUtil.showList(tree.bfs(node));
    }

    /**
     * 前序遍历
     * @param treeNode
     * @return
     */
    public List<Integer> preOrder(TreeNode treeNode) {
        if(null == treeNode) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if(null != node.right) {
                stack.push(node.right);
            }

            if(null != node.left) {
                stack.push(node.left);
            }
        }
        return result;
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
           if(root != null) {
               stack.push(root);
               root = root.left;
           } else {
               root = stack.pop();
               list.add(root.val);
               root = root.right;
           }

        }
        return list;
    }

    /**
     * 双栈后序遍历
     * @param treeNode
     * @return
     */
    public List<Integer> posOrderUnRecursion1(TreeNode treeNode) {
        if(null == treeNode) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(treeNode);

        while(!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);

            if(null != node.left) {
                stack1.push(node.left);
            }

            if(null != node.right) {
                stack1.push(node.right);
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }
        return result;
    }

    /**
     * 后序遍历
     * @param treeNode
     * @return
     */
    public List<Integer> posOrderUnRecursion2(TreeNode treeNode) {
        if(null == treeNode) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        TreeNode pre = treeNode;

        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if(null != node.left && pre != node.left && pre != node.right) {
                stack.push(node.left);
            } else if(null != node.right && pre != node.right) {
                stack.push(node.right);
            } else {
                result.add(stack.pop().val);
                pre = node;
            }
        }

        return result;
    }

    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    public List<Integer> bfs(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        List<Integer> result = new ArrayList<>();

        while(!deque.isEmpty()) {
            TreeNode node = deque.poll();
            result.add(node.val);

            if(null != node.left) {
                deque.add(node.left);
            }

            if(null != node.right) {
                deque.add(node.right);
            }
        }

        return result;
    }
}
