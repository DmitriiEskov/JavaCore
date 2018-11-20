package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * Test for MatrixCheck class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 21.11.2018
 */
public class ArrayDuplicateTest {

    /**
     * Testing a small array of words.
     */
    @Test
    public void firstWhenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] duplicates = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] noDuplicates = {"Привет", "Мир", "Супер"};
        String[] result = array.remove(duplicates);
        assertThat(result, arrayContainingInAnyOrder(noDuplicates));
    }

    /**
     * Testing the big array of words.
     */
    @Test
    public void secondWhenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] duplicates =  {"Привет", "Мир", "Привет", "Супер", "Мир", "Привет", "Привет", "Мир", "Мир", "Супер",
                "Супер", "Супер", "Супер", "Супер", "Супер", "Супер", "Привет", "Привет", "Мир", "Мир", "Привет", "Мир",
                "Привет", "Супер", "Мир", "Привет", "Привет", "Мир", "Мир", "Супер", "Супер", "Супер", "Супер", "Бум-бум",
                "Супер", "Супер", "Супер", "Привет", "Привет", "Мир", "Мир", "Привет", "Мир", "Привет", "Супер", "Мир",
                "Привет", "Привет", "Мир", "Мир", "Супер", "Супер", "Супер", "Супер", "Супер", "Супер", "Супер", "Привет",
                "Привет", "Мир", "Мир", "Привет", "Мир", "Привет", "Супер", "Мир", "Привет", "Привет", "Мир", "Мир", "Супер",
                "Супер", "Супер", "Супер", "Супер", "Супер", "Супер", "Привет", "Привет", "Мир", "Мир", "Бум-бум", "Бум-бум",
                "Бум-бум", "Бум-бум", "Сюрприз", "Сюрприз", "Сюрприз"};
        String[] noDuplicates = {"Привет", "Мир", "Супер", "Бум-бум", "Сюрприз"};
        String[] result = array.remove(duplicates);
        assertThat(result, arrayContainingInAnyOrder(noDuplicates));
    }

    /**
     * Testing a small array of numbers.
     */
    @Test
    public void thirdWhenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] duplicates = {"1", "2", "3", "3", "6"};
        String[] noDuplicates = {"1", "2", "3", "6"};
        String[] result = array.remove(duplicates);
        assertThat(result, arrayContainingInAnyOrder(noDuplicates));
    }
}