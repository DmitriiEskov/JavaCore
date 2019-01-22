package ru.job4j.list;

import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing the "ConvertList2Array" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 22.01.2019
 * @version 1.0
 */
public class ConvertList2ArrayTest {

    /**
     * Tests when it needs to convert a List into an array with 3 rows. 3 x 3
     */
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    /**
     * Tests when it needs to convert a List into an array with 3 rows. 3 x 3.
     */
    @Test
    public void when9ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertThat(result, is(expect));
    }

    /**
     * Tests when it needs to convert a List into an array with 2 rows. 2 x 6.
     */
    @Test
    public void when12ElementsThen12() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 3, 7),
                2
        );
        int[][] expect = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 3, 7}
        };
        assertThat(result, is(expect));
    }

    /**
     * Tests when it needs to convert a List into an array with 1 row. 1 x 1.
     */
    @Test
    public void when13ElementsThen13() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 3, 7, 0),
                1
        );
        int[][] expect = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 3, 7, 0},
        };
        assertThat(result, is(expect));
    }

    /**
     * Tests when it needs to convert a List into an array with 6 rows. 4 x 6.
     */
    @Test
    public void when20ElementsThen24() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20),
                6
        );
        int[][] expect = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20},
                {0, 0, 0, 0}
        };
        assertThat(result, is(expect));
    }
}