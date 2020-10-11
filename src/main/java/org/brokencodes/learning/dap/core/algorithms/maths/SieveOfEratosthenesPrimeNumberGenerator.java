package org.brokencodes.learning.dap.core.algorithms.maths;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.LongStream;

@Component
public class SieveOfEratosthenesPrimeNumberGenerator {

    private List<Long> primes;

    public SieveOfEratosthenesPrimeNumberGenerator() {
        primes = new LinkedList<>();
    }

    public void generatePrimesInOrderTill(long maxPrimeNumberRange) {
        LongStream.range(1, maxPrimeNumberRange + 1)
                .filter(this::isPrime)
                .forEach(i -> primes.add(i));

    }

    public void generateNPrimeNumberInOrder(int primeCount) {

    }

    private boolean isPrime(long number) {
        return primes.stream()
                .filter(i -> i >= 2)
                .noneMatch(i -> number % i == 0);
    }

    public List<Long> getPrimes() {
        return Collections.unmodifiableList(primes);
    }
}
