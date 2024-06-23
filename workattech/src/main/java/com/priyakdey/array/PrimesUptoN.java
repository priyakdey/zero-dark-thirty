package com.priyakdey.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 * @since 24-06-2024
 */
public class PrimesUptoN {

    // Given a number, let’s say 10. Can you tell all the divisors of the number?
    //
    // For 10, there are 4 divisors (1, 2, 5 & 10).
    // Let’s take 5, it has 2 divisors (1 & 5).
    //
    // A Prime number is a number that has exactly two divisors → 1 and itself.
    // Note: 1 is not a prime number.
    //
    // Divisors of Numbers:
    //         2 → 1, 2
    //         3 → 1, 3
    //         5 → 1, 5
    //         7 → 1, 7
    //
    // Given a number, find all the prime numbers from 1 to that number.

    List<Integer> primesUptoN(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        boolean[] sieve = new boolean[n + 1];
        sieve[0] = true;
        sieve[1] = true;

        for (int i = 2; i < sieve.length; i++) {
            if (!sieve[i]) {
                for (int j = 2; i * j < sieve.length; j++) {
                    sieve[i * j] = true;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < sieve.length; i++) {
            if (!sieve[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

}
