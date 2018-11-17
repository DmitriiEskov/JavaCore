package ru.job4j.array;

/**
 * Class for turning an array over.
 *
 * @author Dmitrii Eskov
 * @version 1.0
 * @since 17.11.2018
 */
public class Turn {

    /**
     * Turning an array over.
     * @param array - an array
     * @return a turned over array
     */
    public int[] back(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}