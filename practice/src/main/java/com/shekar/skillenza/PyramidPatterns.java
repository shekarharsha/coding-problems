package com.shekar.skillenza;

import java.util.Scanner;

public class PyramidPatterns {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] splitLine = line.split(" ");
            String seq = splitLine[0];
            int height = Integer.parseInt(splitLine[1]);
            int direction = Integer.parseInt(splitLine[2]);

            int totalChars = ((height)*(2 + (height - 1) * 2))/2;

            StringBuilder sb = new StringBuilder();
            for ( int i = 0, j = 0; i < totalChars; i++, j = (j+1)%seq.length()) {
                sb.append(seq.charAt(j));
            }

            String finalSeq = sb.toString();

            int startPoint = 0;
            String[] strings = new String[height];
            if (direction == 1) {

                for (int n = 1; n <= height; n++) {
                    int Ti = 1 + (n - 1) * 2;
                    strings[n-1] = finalSeq.substring(startPoint, startPoint + Ti);
                    startPoint += Ti;
                }

                int Tn = 1 + (height - 1) * 2;
                for (int i = 0, j = 0; i < height; i++, j++) {
                    int spacing = Tn/2 - i + strings[i].length();
                    if (j % 2 == 0) {
                        System.out.println(String.format("%" + spacing + "s", strings[i]));
                    } else {
                        System.out.println(String.format("%" + spacing + "s", reverse(strings[i])));
                    }
                }
            } else {

                for (int n = height; n > 0; n--) {
                    int Ti = 1 + (n - 1) * 2;
                    strings[n-1] = finalSeq.substring(startPoint, startPoint + Ti);
                    startPoint += Ti;
                }

                int Tn = 1 + (height - 1) * 2;
                for (int i = height, j = 0; i > 0; i--, j++) {
                    int spacing = Tn/2 - (i-1) + strings[i-1].length();
                    if (j % 2 == 0) {
                        System.out.println(String.format("%" + spacing + "s", strings[i-1]));
                    } else {
                        System.out.println(String.format("%" + spacing + "s", reverse(strings[i-1])));
                    }
                }
            }
        }
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >=0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
