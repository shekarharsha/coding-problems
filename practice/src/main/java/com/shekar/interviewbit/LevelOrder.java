package com.shekar.interviewbit;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        ArrayList<ArrayList<Integer>> out = levelOrder(root);

        out.stream().forEach(System.out::println);

    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {

        ArrayList<ArrayList<Integer>> out = new ArrayList<>();

        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode marker = new TreeNode(Integer.MIN_VALUE);
        q.add(A);
        q.add(marker);

        ArrayList<Integer> levelNodes = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node == marker) {
                out.add(levelNodes);
                levelNodes = new ArrayList<>();
                if (!q.isEmpty())
                    q.add(marker);
            } else {
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                levelNodes.add(node.value);
            }
        }

        return out;
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
