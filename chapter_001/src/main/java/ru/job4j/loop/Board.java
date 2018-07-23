package ru.job4j.loop;

/**
 * Board.
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
     * @return String
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int index = 0; index <= height; index++) {
            for (int indexTwo = 0; indexTwo <= width; indexTwo++) {
                if ((index + indexTwo) % 2 == 0) {
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