package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for Factorial class.
 */
public class FactorialTest {

    /**
     * Test for calculating a factorial (5).
     */
    @Test
    public void whenFactorialIsFiveThenOneHundredAndTwenty() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        assertThat(result, is(120));
    }

    /**
     * Test for calculating a factorial (0).
     */
    @Test
    public void whenFactorialIsZeroThenOne() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        assertThat(result, is(1));
    }
}