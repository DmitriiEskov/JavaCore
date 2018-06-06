package ru.job4j.max;

/**
 * Max of two numbers.
 *
 * @author Dmitrii Eskov (dmitryhope@yahoo.com)
 * @version 1.0
 * @since 06.06.2018
 */
public class Max {

    /**
     * @param first - 1-st number
     * @param second - 2-d number
     * @return max
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}