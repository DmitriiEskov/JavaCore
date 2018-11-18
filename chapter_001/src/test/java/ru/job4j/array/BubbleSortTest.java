package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for BubbleSort class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 19.11.2018
 */
public class BubbleSortTest {

    /**
     * Testing an array with 5 elements to sort.
     */
    @Test
    public void whenSortArrayWithFiveElementsThenSortedArray() {
        BubbleSort bubble = new BubbleSort();
        int[] second = new int[] {5, 4, 3, 1, 1};
        int[] first = bubble.sort(second);
        int[] result = new int[] {1, 1, 3, 4, 5};
        assertThat(first, is(result));
    }

    /**
     * Testing an array with 10 elements to sort.
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubble = new BubbleSort();
        int[] second = new int[] {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] first = bubble.sort(second);
        int[] result = new int[] {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(first, is(result));
    }

    /**
     * Testing an array with 30 elements to sort.
     */
    @Test
    public void whenSortArrayWithThirtyElementsThenSortedArray() {
        BubbleSort bubble = new BubbleSort();
        int[] second = new int[] {30, 15, 28, 27, 4, 25, 24, 23, 22,
                21, 20, 19, 18, 17, 16, 29, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 26, 3, 2, 1, 0};
        int[] first = bubble.sort(second);
        int[] result = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
                18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        assertThat(first, is(result));
    }
}