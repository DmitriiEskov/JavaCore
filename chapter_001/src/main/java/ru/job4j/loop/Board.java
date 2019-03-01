package ru.job4j.loop;

/**
 * Class for making a board.
 *
 * @author Dmitrii Eskov (dmitryhope@yahoo.com)
 * @version 1.0
 * @since 21.07.2018
 */
public class Board {

    /**
     * Making a board.
     * @param width - width
     * @param height - height
     * @return a board
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}