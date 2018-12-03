package ru.job4j.array;

/**
 * Class for filling in an array with sorted values taken from two other sorted arrays WITHOUT sorting values inside the array.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 03.12.2018
 */
public class FillArray {

    /**
     * Filling in an array with sorted values taken from two sorted arrays in the following way:
     * 1. Filling in values into the result array from the first one.
     * 2. Filling in values into the result array from the second one.
     *
     * @param first  - the first sorted array
     * @param second - the second sorted array
     * @return result - the array that contains sorted values from both first and second arrays
     */
    public int[] fill(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int count = 0;
        for (int i = 0; i < first.length; i++) {
            if (count < second.length && first[i] >= second[count]) {
                result[i + count] = second[count++];
                while (count < second.length) {
                    if (first[i] >= second[count]) {
                        result[i + count] = second[count++];
                    } else {
                        break;
                    }
                }
            }
            result[i + count] = first[i];
        }
        while (count < second.length) {
            result[first.length + count] = second[count++];
        }
        return result;
    }
}