package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test for Turn class.
 *
 * @author Dmitrii Eskov
 * @version 1.0
 * @since 17.11.2018
 */
public class TurnTest {

    /**
     * Testing an array with the even amount of elements.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {4, 1, 6, 2};
        int[] result = turner.back(input);
        int[] expect = new int[] {2, 6, 1, 4};
        assertThat(result, is(expect));
    }

    /**
     * Testing an array with the odd amount of elements.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = {5, 8, 9, 10, 17, 23, 43, 31, 41};
        int[] result = turner.back(input);
        int[] expect = {41, 31, 43, 23, 17, 10, 9, 8, 5};
        assertThat(result, is(expect));
    }
}