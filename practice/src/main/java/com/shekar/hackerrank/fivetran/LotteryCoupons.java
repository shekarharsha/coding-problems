package com.shekar.hackerrank.fivetran;

public class LotteryCoupons {


    public static void main(String[] args) {

        System.out.println(lotteryCoupons(3));
        System.out.println(lotteryCoupons(22));

    }

    public static int lotteryCoupons(int n) {
        // Write your code here

        int[] counts = new int[n+1];
        int max = 0;
        int maxCount = 0;

        for (int i = 1; i <= n; i++) {

            int sum = sumOfDigits(i);
            counts[sum]++;
        }

        for (int count : counts) {
            if (count > max) {
                max = count;
                maxCount = 1;
            } else if (count == max) {
                maxCount++;
            }
        }

        return maxCount;
    }

    private static int sumOfDigits(int number) {

        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            number = number/10;
            sum += digit;
        }

        return sum;
    }
}
