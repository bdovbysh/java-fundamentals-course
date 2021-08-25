package com.bobocode.fp;

import com.bobocode.util.ExerciseNotCompletedException;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * {@link PrimeNumbers} provides an API to work with prime numbers. It is using a stream of prime numbers.
 * <p>
 * See {@link OOSumOfPrimes} for a reference
 */
public class PrimeNumbers {
    private PrimeNumbers() {
    }

    /**
     * Calculates the sum on first n prime numbers.
     * E.g. if n = 5, the result should be 2 + 3 + 5 + 7 + 11 = 28
     *
     * @param n the number of first prime numbers
     * @return the sum of n prime numbers
     */
    public static int sum(int n) {
        return IntStream.iterate(2, i -> i + 1)
                .filter(PrimeNumbers::isPrime)
                .limit(n)
                .sum();
    }

    /**
     * Collects n first prime numbers.
     *
     * @return a list of collected prime numbers
     */
    public static List<Integer> collect(int n) {
       return IntStream.iterate(1, i -> i + 1)
               .filter(i -> IntStream.range(2, i).noneMatch(j -> i % j == 0))
               .limit(n)
               .boxed()
               .collect(Collectors.toList());
    }
    /**
     * Find a prime number by index and then applies a provided consumer passing found prime number
     *
     * @param idx      the position of a prime number (index)
     * @param consumer a logic that should be applied to the found prime number
     */
    public static void processByIndex(int idx, IntConsumer consumer) {
        IntStream.iterate(1, i -> i + 1)
                .filter(PrimeNumbers::isPrime)
                .skip(idx - 1)
                .limit(1)
                .forEach(consumer);
    }

    private static boolean isPrime(Integer n) {
        return IntStream.range(2, n).noneMatch(i -> n % i == 0);
    }
}
