package com.shekar;

import java.util.Arrays;
import java.util.Stack;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        System.out.println("Hello World!!");

        String test = "Harsha";

        System.out.println(test.substring(0,0));

        Stack<String> stack = new Stack<>();
        stack.push("Harsha");

        for (String s : stack) {
            System.out.println(s);
        }

    }
}
