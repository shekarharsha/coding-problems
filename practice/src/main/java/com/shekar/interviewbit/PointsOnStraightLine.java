package com.shekar.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;

public class PointsOnStraightLine {

    public static void main(String[] args) {



    }

    public static int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {

        HashMap<Float, Integer> slopeBasedCounts = new HashMap<>();
        int maxPoints = 0;

        if (a.size() == 1) {
            return 1;
        }

        for (int i = 0; i < a.size(); i++) {
            for (int j = i+1; j < a.size(); j++) {

                float slope = 0;
                if ((a.get(j) - a.get(i)) != 0)
                    slope = Math.abs((b.get(j) - b.get(i))/(a.get(j) - a.get(i)));
                else {
                    slope = Float.MAX_VALUE;
                }

                int count = slopeBasedCounts.getOrDefault(slope, 0);
                count++;
                slopeBasedCounts.put(slope, count);
                maxPoints = Math.max(maxPoints, count);
            }
        }

        return maxPoints;
    }


}
