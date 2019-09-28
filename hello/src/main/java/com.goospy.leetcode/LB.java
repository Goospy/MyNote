package com.goospy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Goospy on 2019/9/24.
 */
public class LB {

    public int[] bonus(int n, int[][] leadership, int[][] operations) {
        Map<Integer, Node> nodeMap = buildShipMap(leadership);
        List<Integer> list = new ArrayList<Integer>();

        int queryCount = 0;

        for(int[] operation: operations) {
            int opcmd = operation[0];
            if(1 == opcmd || 2 == opcmd) {
                Node node = nodeMap.get(operation[1]);
                addCoins(node, operation[2], 2 == opcmd);
            }

            if(3 == opcmd) {
                Node node = nodeMap.get(operation[1]);
                double coins = countCoins(node);
                list.add((int) (coins % 1000000007));
                queryCount++;
            }
        }
        int[] result = new int[queryCount + 1];
        for(int i = 0; i <= queryCount; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private double countCoins(Node root) {
        double res = root.coins;
        if(!root.brans.isEmpty()) {
            for(Node node: root.brans) {
                res += countCoins(node);
            }
        }
        return res;
    }

    private void addCoins(Node root, int coins, boolean branHas) {
        root.coins += coins;
        if(branHas) {
            List<Node> nodes = root.brans;
            if(nodes.isEmpty()) {
                return ;
            }
            for(Node node: nodes) {
                node.coins += coins;
                addCoins(node, coins, true);
            }
        }
    }

    private Map buildShipMap(int[][] leadership) {
        Map<Integer, Node> nodeMap = new HashMap<Integer, Node>();
        for(int[] ships: leadership) {
            Node leader = nodeMap.get(ships[0]);
            if(null == leader) {
                leader = new Node(ships[0]);
                nodeMap.put(ships[0], leader);
            }

            Node bran = nodeMap.get(ships[1]);
            if(null == bran) {
                bran = new Node(ships[1]);
                nodeMap.put(ships[1], bran);
            }

            if(!leader.brans.contains(bran)) {
                leader.brans.add(bran);
            }
        }
        return nodeMap;
    }

}

class Node {
    int n;
    double coins = 0;
    List<Node> brans = new ArrayList<Node>();

    Node(int n) {
        this.n = n;
    }
}