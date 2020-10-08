package org.brokencodes.learning.dap.core.commons;

import java.util.function.LongSupplier;

/**
 * Generates a stream of Fibonacci sequences.
 */
public class FibonacciSequenceGenerator implements LongSupplier {

    long current = 1;

    long previous = 0;

    @Override
    public long getAsLong() {
        long result = current;
        current += previous;
        previous = result;
        return result;
    }

}
