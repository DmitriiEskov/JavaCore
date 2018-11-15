package ru.job4j.array;

/**
 * Class for the classical search for elements of an array by an index.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 15.11.2018
 */
public class FindLoop {

    /**
     * Searching an element of an array by an index.
     * @param data - an array
     * @param el - an index of the array
     * @return rst - the index of the array with the required element
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}