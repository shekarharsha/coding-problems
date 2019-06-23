package com.shekar.gaylelaakman;

public class UniqueElements {

    public static void main(String[] args) {

        UniqueElements uniqueElements = new UniqueElements();
        uniqueElements.solveProblem();
    }

    private void solveProblem() {
        System.out.println(checkUniqueCharsInString("Harsh"));
    }

    private boolean checkUniqueCharsInString(String input) {

        boolean allChars[] = new boolean[128];

        for(char c : input.toCharArray()) {
            if(allChars[c]) {
                return false;
            } else {
                allChars[c] = true;
            }
        }

        return true;

    }


}
