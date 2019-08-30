package com.shekar.interviewbit;

import java.util.*;

public class HotelBooking {

    public static void main(String[] args) {

        ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(1, 3, 5));
        ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(9, 9, 8));

        System.out.println(hotel(arrive, depart, 3));

    }

    /*public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

        Collections.sort(arrive);
        Collections.sort(depart);

        int maxTime = Math.max(arrive.get(arrive.size() - 1), depart.get(depart.size() - 1));

        int time[] = new int[maxTime + 1];

        for (int arrival : arrive) {
            time[arrival] += 1;
        }

        for (int departure : depart) {
            time[departure] -= 1;
        }

        for (int i = 1; i < time.length; i++) {
            time[i] += time[i-1];
            if (time[i] > K) {
                return false;
            }
        }

        return true;
    }*/

    public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

        Collections.sort(arrive);
        Collections.sort(depart);

        TreeMap<Integer, Integer> arrDepMap = new TreeMap<>();

        for (Integer arrival : arrive) {
            arrDepMap.put(arrival, arrDepMap.getOrDefault(arrival, 0) + 1);
        }

        for (Integer departure : depart) {
            arrDepMap.put(departure, arrDepMap.getOrDefault(departure, 0) - 1);
        }

        int maxOccupancy = 0;
        for (Integer key : arrDepMap.keySet()) {
            maxOccupancy += arrDepMap.get(key);
            if (maxOccupancy > K) {
                return false;
            }
        }

        return true;
    }




}
