package org.brokencodes.learning.dap.core.problems.projecteuler;

import lombok.extern.slf4j.Slf4j;
import org.brokencodes.learning.dap.core.problems.ISolve;

import java.util.stream.IntStream;

/**
 * <p>Multiples of 3 and 5</p>
 * <p>
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these
 * multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.
 * </p>
 * <p>
 * <u>Reference:</u>
 * <a href="https://projecteuler.net/problem=1">https://projecteuler.net/problem=1</a>
 * </p>
 * <p>Answer: 233168</p>
 */
@Slf4j
public class ProjectEulerP1 implements ISolve {

    @Override
    public void solve() {
        int sum = getSum(1, 1000);
        log.info("Sum of multiples of 3 or 5 is: {}", sum);
    }

    private int getSum(int start, int endExclusive) {
        return IntStream.range(start, endExclusive)
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .sum();
    }


}
