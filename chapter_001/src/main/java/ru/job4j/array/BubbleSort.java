package ru.job4j.array;

/**
 * Class for sorting an array of numbers in proper permutation.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 19.11.2018
 */
public class BubbleSort {

    /**
     * Sorting an array of numbers in proper permutation.
     * @param array - an array
     * @return a sorted array
     */
    public int[] sort(int[] array) {
            for (int a = 0; a != array.length; a++) {
                for (int b = 0; b < array.length - a - 1; b++) {
                        if (array[b] > array[b + 1]) {
                            int buffer = array[b + 1];
                            array[b + 1] = array[b];
                            array[b] = buffer;
                    }
                }
            }
        return array;
    }
}