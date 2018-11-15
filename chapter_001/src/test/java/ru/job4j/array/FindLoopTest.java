package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for FindLoop class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 15.11.2018
 */
public class FindLoopTest {

    /**
     * Testing an array if a value '5' exists inside of it.
     */
    @Test
    public void whenArrayHasLength5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    /**
     * Testing an array if a value '29' exists inside of it.
     */
    @Test
    public void whenArrayHasLength29Then2() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 29};
        int value = 29;
        int result = find.indexOf(input, value);
        int expect = 2;
        assertThat(result, is(expect));
    }
}