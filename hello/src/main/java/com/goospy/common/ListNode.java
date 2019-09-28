package com.goospy.common;

/**
 * Created by Goospy on 2019/9/20.
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) { val = x; }

    public void show() {
        ListNode n = next;
        while(null != n) {
            System.out.print(n.val + " ");
            n = n.next;
        }
    }
}
