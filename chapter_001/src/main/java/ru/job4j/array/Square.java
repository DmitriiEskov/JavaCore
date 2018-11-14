package ru.job4j.array;

/**
 * Class for filling in a massive with squared numbers.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 14.11.2018
 */
public class Square {

    /**
     * Filling in a massive with squared numbers.
     * @param bound argument
     * @return rst (massive with the result)
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        int result = 1;
        for (int rstNew : rst) {
            rstNew = (int) Math.pow(result, 2);
            rst[result - 1] = rstNew;
            ++result;
        }
        return rst;
    }
}