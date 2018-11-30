package ru.job4j.loop;

/**
 * Class for calculating a factorial.
 *
 * @author Dmitrii Eskov (dmitryhope@yahoo.com)
 * @version 1.0
 * @since 19.07.2018
 */
public class Factorial {

    /**
     * Calculating a factorial.
     * @param n - factorial
     * @return factorial
     */
    public int calc(int n) {
        int sum = 1;
        for (int index = 1; index <= n; index++) {
            sum *= index;
        }
        return sum;
    }
}