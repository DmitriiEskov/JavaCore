package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for Check class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 17.11.2018
 */
public class CheckTest {

    /**
     * Testing when all values of an array are true.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Testing when one value of an array is false.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Testing when all values are false.
     */
    @Test
    public void whenDataMonoByFalseThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Testing when one value of an array is true.
     */
    @Test
    public void whenDataNotMonoByFalseThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}