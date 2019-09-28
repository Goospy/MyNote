package com.goospy.leetcode;

import com.goospy.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Goospy on 2019/9/20.
 */
public class L1171 {

    public static void main(String[] args) {
        int[] res = new int[1];

        L1171 test = new L1171();
        ListNode node = test.removeZeroSumSublists(new ListNode(1));
        while(null != node) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        if(null == head) {
            return head;
        }

        ListNode th = new ListNode(0);
        th.next = head;

        int sum = 0;
        ListNode temp = head;
        Map<Integer, ListNode> nodeMap = new HashMap<Integer, ListNode>();
        nodeMap.put(0, th);
        while(null != temp) {
            sum += temp.val;
            ListNode last = nodeMap.get(sum);
            if(null != last) {
                last.next = temp.next;
                temp = last.next;
            } else {
                nodeMap.put(sum, temp);
                temp = temp.next;
            }
        }

        return th.next;
    }

}
