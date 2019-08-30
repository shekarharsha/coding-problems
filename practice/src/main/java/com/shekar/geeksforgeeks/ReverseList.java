package com.shekar.geeksforgeeks;

public class ReverseList {


    public static void main(String[] args) {

        ReverseList reverseList = new ReverseList();
        reverseList.solveProblem();

    }

    public void solveProblem() {

        Node root = new Node(10);
        root.next = new Node(20);
        root.next.next = new Node(30);
        root.next.next.next = new Node(40);

        printList(root);

        root = reverse(root);

        System.out.println("====== After reversing the list =====");
        
        printList(root);

    }

    public Node reverse(Node root) {
        return reverse(root, null, root);
    }

    private Node reverse(Node node, Node prev, Node root) {

        if (node == null) {
            root = prev;
            return root;
        }

        root = reverse(node.next, node, root);
        node.next = prev;

        return root;
    }

    private void printList(Node node) {

        while(node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
