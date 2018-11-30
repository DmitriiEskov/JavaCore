package ru.job4j.array;

import java.util.Arrays;

/**
 * Class for removing duplicates in an array.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 21.11.2018
 */
public class ArrayDuplicate {

    /**
     * Removing duplicates in an array.
     * @param array - an array with duplicates
     * @return array - the array without duplicates
     */
    public String[] remove(String[] array) {
        int i = 0;
        for (int a = 0; a < array.length - i; a++) {
            for (int b = a + 1; b < array.length - i; b++) {
                if (array[a].equals(array[b])) {
                    array[b] = array[array.length - 1 - i];
                    ++i;
                    --b;
                }
            }
        }
        return Arrays.copyOf(array, array.length - i);
    }
}