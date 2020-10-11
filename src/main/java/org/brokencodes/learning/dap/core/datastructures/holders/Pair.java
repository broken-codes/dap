package org.brokencodes.learning.dap.core.datastructures.holders;

import java.util.Objects;

/**
 * {@link Pair} data structure is a holder for two elements at a time. The elements can be of same or different
 * data types.
 *
 * @param <ONE>
 * @param <TWO>
 */
public class Pair<ONE, TWO> {

    private ONE one;

    private TWO two;

    /**
     * Create an instance of {@link Pair}. Both elements are required for creating instance of a pair.
     *
     * @param one First element of the {@link Pair}
     * @param two Second element of the {@link Pair}
     */
    public Pair(ONE one, TWO two) {
        this.one = one;
        this.two = two;
    }

    public ONE getOne() {
        return one;
    }

    public void setOne(ONE one) {
        this.one = one;
    }

    public TWO getTwo() {
        return two;
    }

    public void setTwo(TWO two) {
        this.two = two;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return one.equals(pair.one) &&
                two.equals(pair.two);
    }

    @Override
    public int hashCode() {
        return Objects.hash(one, two);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "one=" + one +
                ", two=" + two +
                '}';
    }

}
