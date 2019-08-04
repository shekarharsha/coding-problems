package com.shekar.codesignal;

import java.util.HashMap;

public class CryptArithmetic {

    public static void main(String[] args) {

        String[] crypt = {"SEND", "MORE", "MONEY"};
        char[][] solution = {{'O', '0'},
                {'M', '1'},
                {'Y', '2'},
                {'E', '5'},
                {'N', '6'},
                {'D', '7'},
                {'R', '8'},
                {'S', '9'}};

        CryptArithmetic cryptArithmetic = new CryptArithmetic();
        System.out.println(cryptArithmetic.isCryptSolution(crypt, solution));


    }

    private boolean isCryptSolution(String[] crypt, char[][] solution) {

        boolean isCrypt = false;
        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < solution.length; i++) {
            map.put(solution[i][0], solution[i][1]);
        }

        String[] mappedWords = new String[crypt.length];
        int k = 0;
        for (String word : crypt) {
            StringBuilder sb = new StringBuilder();
            for (Character c : word.toCharArray()) {
                sb.append(map.get(c));
            }
            mappedWords[k++] = sb.toString();
            if (mappedWords[k-1].length() > 1 && mappedWords[k-1].charAt(0) == '0') {
                return false;
            }
        }

        if (convertStringToNumber(mappedWords[0]) + convertStringToNumber(mappedWords[1])
                    == convertStringToNumber(mappedWords[2])) {
            isCrypt = true;
        }

        return isCrypt;
    }

    private long convertStringToNumber(String word) {
        long returnVal = 0;
        int N = word.length() - 1;
        for (int i = 0; i <= N; i++) {
            returnVal += Character.getNumericValue(word.charAt(i)) * Math.pow(10, N-i);
        }

        return returnVal;
    }

}
