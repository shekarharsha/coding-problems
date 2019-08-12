package com.shekar.interviewbit;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class PrimeSum {


    public static void main(String[] args) {

        Instant start = Instant.now();
        ArrayList<Integer> out = primesum(12);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));
        out.forEach(System.out::println);

    }

    /*public static ArrayList<Integer> primesum(int A) {

        ArrayList<Integer> primesTillA = sieve(A);
        ArrayList<Integer> out = new ArrayList<>(2);

        Integer[] primesTillAarr = new Integer[primesTillA.size()];
        primesTillAarr = primesTillA.toArray(primesTillAarr);

        for (Integer i : primesTillAarr) {
            if (Arrays.binarySearch(primesTillAarr, (A-i)) >= 0) {
                out.add(i);
                out.add(A-i);
                break;
            }
        }

        return out;
    }*/

    /*public static ArrayList<Integer> primesum(int A) {

        ArrayList<Integer> out = new ArrayList<>(2);

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
            if (primes[i] && primes[A-i]) {
                out.add(i);
                out.add(A-i);
                break;
            }
        }

        return out;

    }*/

    public static ArrayList<Integer> primesum(int A) {

        ArrayList<Integer> out = new ArrayList<>(2);

        for (int i = 2; i <= A/2; i++) {

            if(isPrime(i) && isPrime(A-i)) {
                out.add(i);
                out.add(A-i);
                break;
            }
        }

        return out;

    }

    private static boolean isPrime(int num) {

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;

    }

}
