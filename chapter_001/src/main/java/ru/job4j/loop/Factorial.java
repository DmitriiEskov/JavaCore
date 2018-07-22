package ru.job4j.loop;

/**
 * Factorial.
 *
 * @author Dmitrii Eskov (dmitryhope@yahoo.com)
 * @version 1.0
 * @since 19.07.2018
 */
public class Factorial {
    private int result = 1;

    /**
     * Calculating a factorial.
     * @param n - factorial
     * @return factorial
     */
    public int calc(int n) {
        for (int index = 1; index <= n; index++) {
            this.result = this.result * index;
        }
        return this.result;
    }
}