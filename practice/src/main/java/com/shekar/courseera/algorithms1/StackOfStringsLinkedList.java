package com.shekar.courseera.algorithms1;

public class StackOfStringsLinkedList {

    private Node first;

    private class Node {

        public Node(String item) {
            this.item = item;
            next = null;
        }
        String item;
        Node next;
    }

    public void push(String s) {
        Node node = new Node(s);
        if (first == null) {
            first = node;
        } else {
            node.next = first;
            first = node;
        }
    }

    public String pop() throws EmptyStackException {

        if(isEmpty()) {
            throw new EmptyStackException("Stack is empty");
        }

        Node node = first;
        first = first.next;
        String ret = node.item;
        node = null;

        return ret;
    }

    public boolean isEmpty() {
        if (first == null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        StackOfStringsLinkedList stack = new StackOfStringsLinkedList();


        stack.push("Harsha");
        //stack.push("Anvitha");

        try {
            System.out.println(stack.pop());
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(stack.pop());
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }
        System.out.println(stack.isEmpty());
    }

}
