package org.brokencodes.learning.dap.core.problems.projecteuler;

import lombok.extern.slf4j.Slf4j;
import org.brokencodes.learning.dap.core.commons.FibonacciSequenceGenerator;
import org.brokencodes.learning.dap.core.problems.ISolve;

import java.util.stream.LongStream;

/**
 * <h1>Even Fibonacci numbers</h1>
 * <p>
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2,
 * the first 10 terms will be:
 * <code>
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * </code>
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the
 * even-valued terms.
 * </p>
 * <p>
 * <u>Reference:</u>
 * <a href="https://projecteuler.net/problem=2">https://projecteuler.net/problem=2</a>
 * </p>
 * <p>Answer: 4613732</p>
 */
@Slf4j
public class ProjectEulerP2 implements ISolve {

    @Override
    public void solve() {
        long sum = LongStream.generate(new FibonacciSequenceGenerator())
                .filter(i -> i % 2 == 0)
                .takeWhile(i -> i < 4000000)
                .sum();

        log.info("Sum of even Fibonacci numbers less than 4 millions is: {}", sum);
    }

}
