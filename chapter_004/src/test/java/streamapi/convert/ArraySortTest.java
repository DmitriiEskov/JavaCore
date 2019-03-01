package streamapi.convert;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing the "ArraySort" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 18.02.2019
 */
public class ArraySortTest {

    /**
     * Tests when it needs to remove all odd numbers, square each number and
     * to sum all elements up inside the Integer array.
     */
    @Test
    public void whenFilterIntegerArrayThenResult() {
        Integer[] test = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer result = new ArraySort().sort(test);
        assertThat(result, is(120));
    }

    /**
     * Tests when it needs to remove all odd numbers, square each number and
     * to sum all elements up inside the Integer array.
     */
    @Test
    public void whenFilterIntegerArrayThenResult2() {
        Integer[] test = {120, 15, 70};
        Integer result = new ArraySort().sort(test);
        assertThat(result, is(19300));
    }
}