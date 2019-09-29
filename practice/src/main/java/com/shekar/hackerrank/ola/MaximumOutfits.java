package com.shekar.hackerrank.ola;

import java.util.Arrays;
import java.util.List;

public class MaximumOutfits {


    public static void main(String[] args) {

        List<Integer> outfits = Arrays.asList(2, 3, 5, 1, 1, 2, 1);

        System.out.println(getMaximumOutfits(outfits, 5));
        System.out.println(getMaximumOutfits(Arrays.asList(2, 1, 1, 1, 1, 1, 1, 1), 6));
        System.out.println(getMaximumOutfits(Arrays.asList(10, 10, 10), 3));


    }

    public static int getMaximumOutfits(List<Integer> outfits, int money) {

        int maxOutfits = 0;
        int currentCount = 0;

        int currentSum = 0;
        int start = 0;
        int current = 0;

        while (start < outfits.size() && current < outfits.size()) {

            currentSum += outfits.get(current);

            if (currentSum <= money) {
                currentCount++;
                current++;
            } else {
                currentSum = 0;
                current = start = start + 1;
                if (currentCount >= maxOutfits) {
                    maxOutfits = currentCount;
                }
                currentCount = 0;
            }
        }

        return maxOutfits;

    }


}
