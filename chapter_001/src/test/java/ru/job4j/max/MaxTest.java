package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for Max of two numbers.
 *
 * @author Dmitrii Eskov (dmitryhope@yahoo.com)
 * @version 1.0
 * @since 06.06.2018
 */
public class MaxTest {

    /**
     * Test for first and second (first < second).
     */
    @Test
    public void whenFirstLessSecond() {
        Max max = new Max();
        int result = max.max(1, 4);
        assertThat(result, is(4));
    }

    /**
     * Test for first and second (first > second).
     */
    @Test
    public void whenSecondLessFirst() {
        Max max = new Max();
        int result = max.max(2, 1);
        assertThat(result, is(2));
    }
}