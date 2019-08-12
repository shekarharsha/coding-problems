package com.shekar.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeNumbers {

    public static void main(String[] args) {

        ArrayList<Integer> out = sieve(20);
        out.forEach(System.out::println);
    }

    public static ArrayList<Integer> sieve(int A) {

        ArrayList<Integer> out = new ArrayList<>();

        Boolean[] primes = new Boolean[A+1];
        Arrays.fill(primes, true);

        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i <= Math.sqrt(A); i++) {
            if(primes[i]) {
                for (int j = 2; i*j <= A; j++) {
                    primes[i*j] = false;
                }
            }
        }

        for(int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                out.add(i);
            }
        }

        return out;

    }
}
