package com.shekar;

import java.math.BigInteger;
import java.util.*;

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

        System.out.println();

        List<String> items = new ArrayList<>();
        items.add("Harsha");
        items.add("Anvitha");
        items.add("Atharva");
        items.add("Usha");
        items.add("Shekar");


        Collections.sort(items, (o1, o2) -> {
            if (o1.compareTo(o2) < 1) return 1;
            else if (o1.compareTo(o2) > 1) return -1;
            return 0;
        });

        items.stream().forEach(System.out::println);


        HashMap<Float, ArrayList<Integer>> map = new HashMap<>();

        int[][] arr = new int[3][3];

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = i+j;
            }
        }

        System.out.println(arr);


        BigInteger A = new BigInteger("1234567890000000");

        System.out.println(A.intValue());




    }
}
