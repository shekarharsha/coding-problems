package com.shekar.hackerrank.fivetran;

public class ProcessTree {


    public static void main(String[] args) {


        System.out.println(findParent(34));
        System.out.println(findParent(3));
        System.out.println(findParent(38));
        System.out.println(findParent(49));
        System.out.println(findParent(11));
        System.out.println(findParent(2));
    }

    public static int findParent(int processNumber) {
        // Write your code here
        double ans = (-1 + Math.sqrt(1 - 4 * ((-(processNumber-1)) * 2)))/2;
        return (int)Math.ceil(ans);
    }
}
