package ru.job4j.array;

/**
 * Class for filling in a double array with a multiplication table.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 20.11.2018
 */
public class Matrix {

    /**
     * Filling in a double array with a multiplication table.
     * @param size - size of an array
     * @return table - a filled in array
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int a = 0; a < table.length; a++) {
            for (int b = 0; b < table.length; b++) {
                table[a][b] = (a + 1) * (b + 1);
            }
        }
        return table;
    }
}