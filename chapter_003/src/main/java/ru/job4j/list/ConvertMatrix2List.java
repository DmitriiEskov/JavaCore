package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for converting a two-dimensional array into an ArrayList.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 23.01.2019
 * @version 1.0
 */
public class ConvertMatrix2List {

    /**
     * Converts a two-dimensional array into an ArrayList.
     * @param array - a two-dimensional array
     * @return an ArrayList
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int cell : row) {
                list.add(cell);
            }
        }
        return list;
    }
}