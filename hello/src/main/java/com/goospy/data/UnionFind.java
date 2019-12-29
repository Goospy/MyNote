package com.goospy.data;

/**
 * Created by Goospy on 2019/10/9 in Hong Xin Jin Fu
 */
public class UnionFind {

    private int[] roots;

    public UnionFind(int n) {
        for(int i = 0; i < n; i++) {
            roots[n] = i;
        }
    }

    private int findRoot(int i) {
        int root = i;
        while(root != roots[root]) {
            root = roots[root];
        }
        while(i != root) {
            int temp = roots[i];
            roots[i] = root;
            i = temp;
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public void union(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        roots[pRoot] = qRoot;
    }
}
