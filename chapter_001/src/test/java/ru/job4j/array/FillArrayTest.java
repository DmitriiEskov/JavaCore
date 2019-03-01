package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for FillArray class.
 *
 * @author  Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 03.12.2018
 */
public class FillArrayTest {

    /**
     * Testing when the first array contains 3 sorted elements and the second one contains 5 sorted elements.
     * We need to get the third array with 8 sorted elements.
     */
    @Test
    public void whenTwoArraysWithSizesThreeAndFive() {
        int[] first = {0, 3, 8};
        int[] second = {2, 5, 10, 12, 15};
        int[] result = {0, 2, 3, 5, 8, 10, 12, 15};
        FillArray fillArray = new FillArray();
        int[] third = fillArray.fill(first, second);
        assertThat(third, is(result));
    }

    /**
     * Testing when the first array contains 5 sorted elements and the second one also contains 5 sorted elements.
     * We need to get the third array with 10 sorted elements.
     */
    @Test
    public void whenTwoArraysWithSizesFiveAndFive() {
        int[] first = {0, 3, 8, 10, 12};
        int[] second = {2, 5, 10, 12, 15};
        int[] result = {0, 2, 3, 5, 8, 10, 10, 12, 12, 15};
        FillArray fillArray = new FillArray();
        int[] third = fillArray.fill(first, second);
        assertThat(third, is(result));
    }

    /**
     * Testing when the first array contains 5 sorted elements and the second one contains 3 sorted elements.
     * We need to get the third array with 8 sorted elements.
     */
    @Test
    public void whenTwoArraysWithSizesFiveAndThree() {
        int[] first = {0, 3, 8, 10, 12};
        int[] second = {2, 5, 10};
        int[] result = {0, 2, 3, 5, 8, 10, 10, 12};
        FillArray fillArray = new FillArray();
        int[] third = fillArray.fill(first, second);
        assertThat(third, is(result));
    }

    /**
     * Testing when the first array contains 8 sorted elements and the second one contains 5 sorted elements.
     * We need to get the third array with 13 sorted elements.
     */
    @Test
    public void whenTwoArraysWithSizesEightAndFive() {
        int[] first = {0, 2, 3, 5, 8, 10, 10, 12};
        int[] second = {0, 3, 8, 10, 12};
        int[] result = {0, 0, 2, 3, 3, 5, 8, 8, 10, 10, 10, 12, 12};
        FillArray fillArray = new FillArray();
        int[] third = fillArray.fill(first, second);
        assertThat(third, is(result));
    }

    /**
     * Testing when the first array contains 9 sorted elements and the second one contains 4 sorted elements.
     * We need to get the third array with 13 sorted elements.
     */
    @Test
    public void whenTwoArraysWithSizesNineAndFour() {
        int[] first = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] second = {0, 0, 0, 0};
        int[] result = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        FillArray fillArray = new FillArray();
        int[] third = fillArray.fill(first, second);
        assertThat(third, is(result));
    }

    /**
     * Testing when the first array contains 9 sorted elements and the second one contains 9 sorted elements.
     * We need to get the third array with 18 sorted elements.
     */
    @Test
    public void whenTwoArraysWithSizesTenAndTen() {
        int[] first = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] second = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9};
        FillArray fillArray = new FillArray();
        int[] third = fillArray.fill(first, second);
        assertThat(third, is(result));
    }

    /**
     * Testing when the first array contains 7 sorted elements and the second one contains 8 sorted elements.
     * We need to get the third array with 15 sorted elements.
     */
    @Test
    public void whenTwoArraysWithBigSizes() {
        int[] first = {100, 2000, 3400, 44000, 55434, 66055, 77000};
        int[] second = {5, 6, 7, 8, 145, 234, 3300000, 42222222};
        int[] result = {5, 6, 7, 8, 100, 145, 234, 2000, 3400, 44000, 55434, 66055, 77000, 3300000, 42222222};
        FillArray fillArray = new FillArray();
        int[] third = fillArray.fill(first, second);
        assertThat(third, is(result));
    }
}