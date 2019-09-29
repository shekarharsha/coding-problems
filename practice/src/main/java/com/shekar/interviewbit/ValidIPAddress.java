package com.shekar.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ValidIPAddress {

    HashMap<Integer, List<List<Integer>>> combinations = new HashMap<>();


    public static void main(String[] args) {


    }

    public ArrayList<String> validIpAddresses(String A) {

        combinations.put(11,
                Arrays.asList(
                        Arrays.asList(2, 3, 3, 3),
                        Arrays.asList(3, 2, 3, 3),
                        Arrays.asList(3, 3, 2, 3),
                        Arrays.asList(3, 3, 3, 2)));



        ArrayList<String> out = new ArrayList<>();




        return out;
    }


}
