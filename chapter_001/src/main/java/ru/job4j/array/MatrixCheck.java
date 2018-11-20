package ru.job4j.array;

/**
 * Class for checking if diagonals of a square double array filled in with all true or false.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 20.11.2018
 */
public class MatrixCheck {

    /**
     * Checking if diagonals of a square double array filled in with all true or false.
     * @param data - a value of a double array
     * @return result - true/false
     */
    public boolean mono(boolean[][] data) {
            boolean result = true;
            for (int a = 0; a < data.length; a++) {
            if (data[a][a] != data[0][0]) {
                return false;
                }
                if (data[data.length - 1][0] != data[data.length - 1 - a][a]) {
                    return false;
                }
        }
            return result;
        }
}