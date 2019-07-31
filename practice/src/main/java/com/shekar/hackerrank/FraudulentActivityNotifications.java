package com.shekar.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FraudulentActivityNotifications {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();

        int[] input = new int[n];

        for(int i = 0; i < n; i++){
            input[i] = sc.nextInt();
        }

        FraudulentActivityNotifications fraudulentActivityNotifications = new FraudulentActivityNotifications();
        System.out.println(fraudulentActivityNotifications.activityNotifications(input, d));
    }

    private int activityNotifications(int[] expenditure, int d) {
        int noti = 0;

        ArrayList<Integer> tillDateTransactions = new ArrayList<>();
        for(int i = 0; i < d; i++) {
            tillDateTransactions.add(expenditure[i]);
        }

        Collections.sort(tillDateTransactions);

        for (int i = d; i < expenditure.length; i++) {
            if (expenditure[i] >= 2*median(tillDateTransactions)) {
                noti++;
            }
            tillDateTransactions =
                    insertNewTransaction(tillDateTransactions, expenditure[i]);
        }


        return noti;
    }

    private ArrayList<Integer> insertNewTransaction(ArrayList<Integer> tillDateTransactions,
                                                   int newTransaction) {
        List<Integer> newList = tillDateTransactions.subList(1, tillDateTransactions.size());

        for(int i = newList.size()-1; i >= 0; i--) {
            if(newList.get(i) < newTransaction) {
                newList.add(i+1, newTransaction);
                return new ArrayList<>(newList);
            }
        }
        newList.add(0, newTransaction);
        return new ArrayList<>(newList);

    }

    private int median(ArrayList<Integer> in) {
        int median = 0;
        int mid = in.size() / 2;
        if ((in.size() % 2) == 0) {
            median = (in.get(mid) + in.get(mid+1))/2;
        } else {
            median = in.get(mid);
        }

        return median;
    }

}
