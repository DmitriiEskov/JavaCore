package ru.job4j.array;

/**
 * Class for creating a sorted array based on the given two sorted arrays.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 06.12.2018
 */
public class FillArray {

    /**
     * Filling in an array with sorted values taken from two other sorted arrays.
     * This method does not sort itself!
     *
     * @param a  - the first sorted array
     * @param b - the second sorted array
     * @return result - the array that contains sorted values from both first and second arrays
     */
    public int[] fill(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = a.length - 1, j = b.length - 1, k = result.length;
        while (k > 0) {
            result[--k] = (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];
        }
        return result;
    }
}