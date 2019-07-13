package com.shekar.courseera.algorithms1;

public class WeightedQuickUnion {

    private int[] id;
    private int[] size;

    public WeightedQuickUnion(int N) {
        id = new int[N];
        size = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {

        int i = root(p);
        int j = root(q);

        if(size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
    }

    public boolean connected(int p, int q) {

        if(root(p) == root(q)) {
            return true;
        }
        return false;
    }

    private int root(int p) {
        while (id[p] != p) {
            id[p] = id[id[p]]; // Path Compression
            p = id[p];
        }

        return p;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
