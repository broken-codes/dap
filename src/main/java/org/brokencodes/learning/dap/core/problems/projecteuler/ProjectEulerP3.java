package org.brokencodes.learning.dap.core.problems.projecteuler;

import org.brokencodes.learning.dap.core.problems.ISolve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <p>Largest prime factor</p>
 * <p>
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * </p>
 * <p>
 * <u>Reference:</u>
 * <a href="https://projecteuler.net/problem=3">https://projecteuler.net/problem=3</a>
 * </p>
 * <p>Answer: </p>
 */
public class ProjectEulerP3 implements ISolve {

    private static final Long LARGEST_PRIME_FACTOR_OF = 600851475143L;

    @Override
    public void solve() {
        long numberToFactorize = 10;
        int largestPrimeFactor = largestPrimeFactorBruteForce(numberToFactorize);
    }

    /**
     * SOLUTION: 01 - Brute force
     * <p>
     * In this brute force approach, we will start from sqrt(n) and move back. If we have found a factor of n then we
     * check if the factor is prime or not.
     *
     * @param numberToFactorize number whoes largest prime factor is required
     * @return largest prime factor else -1 if the number itself is a prime
     */
    public int largestPrimeFactorBruteForce(long numberToFactorize) {
        int sqrt = (int) (Math.sqrt(numberToFactorize) + 1);
        for (int i = sqrt; i > 1; i -= 2) {
            if (numberToFactorize % i == 0) {
                if (isPrime(i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * SOLUTION: 02 - Uses Sieve of Eratosthenes
     * <p>
     * This solution generates primes between 2 and sqrt(number). Then we can iterate from the last number to the 2 and
     * check if any number is a factor of the given number. If a number is found, this is the largest prime factor.
     *
     * @param numberToFactorize number whoes largest prime factor is required
     * @return largest prime factor else -1 if the number itself is a prime
     */
    public int largestPrimeFactorByPrimeNumberGeneration(long numberToFactorize) {
        final List<Integer> primes = new ArrayList<>(Arrays.asList(2, 3));
        IntStream.range(4, ((int) Math.sqrt(numberToFactorize)) + 1)
                .filter(number ->
                        primes.stream()
                                .anyMatch(i -> number % i == 0)
                )
                .forEach(primes::add);

        for (int i = primes.size() - 1; i > 0; --i) {
            if (numberToFactorize % primes.get(i) == 0) {
                return primes.get(i);
            }
        }
        return -1;
    }


    /**
     * Check if the given number if prime using bruteforce. We are still trying to cover only half of the total numbers
     * in the range of 2
     */
    private boolean isPrime(int i) {
        int sqrt = (int) Math.sqrt(i);
        for (int j = 3; j < sqrt; j += 2) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

}
