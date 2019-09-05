package com.shekar.goldmansachs;

public class LongestUniformString {

    public static void main(String[] args) {

        /* Prints the start index and the longest uniform string */
        longestUniformString("aabbbbbbccDAaa");
        longestUniformString("");
        longestUniformString("1000011111111");
        longestUniformString("o");
        longestUniformString("0111110");
        longestUniformString("abcdef");
        longestUniformString("11111000");
    }

    public static void longestUniformString(String input) {

        int longestLength = 0;
        int startIndex = -1;

        int currentCount = 1;
        int currentStart = -1;

        for (int i = 0; i < input.length() - 1; i++) {

            if(input.charAt(i) == input.charAt(i+1)) {
                currentCount++;
                if (currentStart == -1) {
                    currentStart = i;
                }
                if ((i+1) == (input.length() - 1)) {
                    if (currentCount > longestLength) {
                        longestLength = currentCount;
                        startIndex = currentStart;
                    }
                }
            } else {
                if (currentCount > longestLength) {
                    longestLength = currentCount;
                    startIndex = currentStart;
                }
                currentCount = 1;
                currentStart = -1;
            }
        }

        if (startIndex == -1 && input.length() > 0) {
            longestLength = 1;
            startIndex = 0;
        }

        System.out.println(startIndex + " " + longestLength);
    }
}
