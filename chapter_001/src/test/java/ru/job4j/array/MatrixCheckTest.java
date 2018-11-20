package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for MatrixCheck class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 20.11.2018
 */
public class MatrixCheckTest {

    /**
     * Testing when each value of a diagonal is true.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Testing when some values of diagonals is false instead of true.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Testing when two diagonals of a square double array do not have a common element.
     */
    @Test
    public void whenDiagonalsNotHaveCommonElementAndIsTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {false, true},
                {true, false}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Testing when two diagonals of a square double array do not have a common element.
     */
    @Test
    public void whenDiagonalsNotHaveCommonElementAndIsFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, false},
                {true, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}