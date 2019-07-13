package com.shekar.courseera.algorithms1;

import java.util.Iterator;
import java.util.function.Consumer;

public class Stack<T> implements Iterable<T>{

    private Node first;

    private class Node {

        public Node(T item) {
            this.item = item;
            next = null;
        }
        T item;
        Node next;
    }

    public void push(T item) {
        Node node = new Node(item);
        if (first == null) {
            first = node;
        } else {
            node.next = first;
            first = node;
        }
    }

    public T pop() throws EmptyStackException {

        if(isEmpty()) {
            throw new EmptyStackException("Stack is empty");
        }

        Node node = first;
        first = first.next;
        T ret = node.item;
        node = null;

        return ret;
    }

    public boolean isEmpty() {
        if (first == null) {
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T ret = current.item;
            current = current.next;
            return ret;
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {

        }
    }

    public static void main(String[] args) {

        Stack<Integer> integerStack = new Stack<>();

        integerStack.push(1);
        integerStack.push(2);

        try {
            System.out.println(integerStack.pop());
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }

        Stack<String> stringStack = new Stack<>();

        stringStack.push("Harsha");
        stringStack.push("Atharva");

        for(String s : stringStack) {
            System.out.println(s);
        }

        System.out.println(stringStack.isEmpty());

    }
}
