package ru.job4j.list;

import java.util.Comparator;

/**
 * Class for the implementation of the Comparator interface for comparing two words.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 29.01.2019
 * @version 1.0
 */
public class ListCompare implements Comparator<String> {

    /**
     * Overriding the compare method from the Comparator interface.
     * @param left - a word to be compared
     * @param right - a word to be compared
     * @return 0 - if they equals each other, a positive integer - if left is greater than the right,
     * a negative integer - if right is greater than the left
     */
    @Override
    public int compare(String left, String right) {
        int result = Integer.compare(left.length(), right.length());
        char[] leftChar = left.toCharArray();
        char[] rightChar = right.toCharArray();
        int x = 0;
        int lim = Math.min(left.length(), right.length());
        while (x < lim) {
            if (leftChar[x] != rightChar[x]) {
                result = Character.compare(leftChar[x], rightChar[x]);
                break;
            }
            x++;
        }
        return result;
    }
}