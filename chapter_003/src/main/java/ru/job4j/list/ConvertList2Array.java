package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for converting a List into a Two-Dimensional Array.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 22.01.2019
 * @version 1.0
 */
public class ConvertList2Array {

    /**
     * Converts a List into a Two-Dimensional Array based on a quantity of rows.
     * @param list - an implementation of a List interface
     * @param rows - a quantity of rows
     * @return int[][] - a result array
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows;
        if (list.size() % rows != 0) {
            cells += 1;
        }
        int[][] array = new int[rows][cells];
        int x = 0;
        int y = 0;
        for (int value : list) {
            if (list.indexOf(value) / (x + 1) == cells) {
                x++;
                y = 0;
            }
            array[x][y++] = value;
        }
        return array;
    }

    /**
     * Converts a list of the int[] type into a List of the Integer type.
     * @param list - an implementation of the List interface
     * @return a result List
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] x : list) {
            for (int y : x) {
                result.add(y);
            }
        }
        return result;
    }
}