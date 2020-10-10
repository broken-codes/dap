package org.brokencodes.learning.dap.core.problems.misc;

import lombok.extern.slf4j.Slf4j;
import org.brokencodes.learning.dap.core.datastructures.holders.Pair;
import org.brokencodes.learning.dap.core.problems.ISolve;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * <p>Pair sum equal to given number</p>
 * <p>
 * You are given an array of numbers with or without duplicates. You are also given an integer k. Find all pairs
 * of numbers from the array whose sum is equal to k
 * </p>
 */
@Slf4j
public class MiscP1 implements ISolve {

    @Override
    public void solve() {
        int[] elements = {1, 5, 10, 17, 27, 20, 39, 12, 7, 18, 26, 39, 10, 15, 7};
        int expected = 17;
        final List<Pair<Integer, Integer>> result = getSumPairsBruteForce(elements, expected);

        result.parallelStream()
                .forEach(integerIntegerPair -> log.info("Obtained Pair: {} whose sum is: {}", integerIntegerPair, expected));
    }

    /**
     * SOLUTION: 01 - Brute Force
     *
     * This brute force solution takes each number of the array and tries to find if there is another element with
     * which if this number is summed, leads to the expectedSum.
     *
     * @param elements    an array of {@link Integer}
     * @param expectedSum expected sum of each pair {@link Pair} from elements
     * @return List of {@link Pair} of elements whose sum is equal to the expected sum
     */
    private List<Pair<Integer, Integer>> getSumPairsBruteForce(int[] elements, int expectedSum) {
        List<Pair<Integer, Integer>> pairs = new LinkedList<>();
        for (int i = 0; i < elements.length; i++) {
            for (int j = i + 1; j < elements.length - 1; j++) {
                if (elements[i] + elements[j] == expectedSum) {
                    pairs.add(new Pair<>(elements[i], elements[j]));
                }
            }
        }
        return pairs;
    }

    /**
     * SOLUTION: 02 - Using additional space and utilise O(1) search for {@link HashSet}
     *
     * If there are two numbers whose sum is equal to another number K and we know one of those numbers, we can find
     * the other number by subtracting known number from the expectedSum (call this D). If we are able to quickly test
     * if the difference D exists in the given array (or any other data structure), we can get our {@link Pair}s.
     *
     * @param elements    an array of {@link Integer}
     * @param expectedSum expected sum of each pair {@link Pair} from elements
     * @return List of {@link Pair} of elements whose sum is equal to the expected sum
     */
    private List<Pair<Integer, Integer>> getSumPairsUsingHashSet(int[] elements, int expectedSum) {
        final Set<Integer> cache = new HashSet<>();
        List<Pair<Integer, Integer>> pairs = new LinkedList<>();
        for (int i = 0; i < elements.length; i++) {
            final int diff = expectedSum - elements[i];
            if (cache.contains(diff)) {
                pairs.add(new Pair<>(elements[i], diff));
            }
            cache.add(elements[i]);
        }
        return pairs;
    }
}
