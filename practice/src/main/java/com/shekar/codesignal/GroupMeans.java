package com.shekar.codesignal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

public class GroupMeans {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] inp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                inp[i][j] = sc.nextInt();
            }
        }

        GroupMeans groupMeans = new GroupMeans();
        int[][] out = groupMeans.computeMeans(inp);


        for (int i = 0; i < out.length; i++) {
            for(int j = 0; j < out[i].length; j++) {
                System.out.print(out[i][j] + " ");
            }
            System.out.printf("\n");
        }

    }

    private int[][] computeMeans(int[][] arr) {

        float[] means = new float[arr.length];

        for(int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[0].length; j++) {
                sum += arr[i][j];
            }
            means[i] = (float)sum/arr[0].length;
        }

        HashMap<Float, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < means.length; i++) {
            /* if (map.containsKey(means[i])) {
                map.get(means[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(means[i], list);
            } */
            ArrayList<Integer> list = map.getOrDefault(means[i], new ArrayList<>());
            list.add(i);
            map.put(means[i], list);

        }

        int[][] out = new int[map.keySet().size()][];
        int k = 0;
        for(ArrayList<Integer> list : map.values()) {
            IntStream intStream = list.stream().mapToInt(value -> value.intValue());
            out[k++] = intStream.toArray();
        }

        Arrays.sort(out, (o1, o2) -> o1[0] - o2[0]);

        return out;
    }

}
