package ru.job4j.max;

/**
 * Max of numbers.
 *
 * @author Dmitrii Eskov (dmitryhope@yahoo.com)
 * @version 1.0
 * @since 06.06.2018
 */
public class Max {

    /**
     * Returning max of two numbers.
     * @param first - 1-st number
     * @param second - 2-d number
     * @return max of 2
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Returning max of three numbers.
     * @param third - 3-d number
     * @return max of 3
     */
    public int maxOfThree(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}