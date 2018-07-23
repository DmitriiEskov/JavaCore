package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for Board.
 *
 * @author Dmitrii Eskov (dmitryhope@yahoo.com)
 * @version $Id$
 * @since 21.07.2018
 */
public class BoardTest {

    /**
     * Test for 3 x 3 Board.
     */
    @Test
    public void when3x3() {
        Board board = new Board();
        // starting with 0 x 0.
        String rsl = board.paint(2, 2);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("X X%s X %sX X%s", ln, ln, ln)
        ));
    }

    /**
     * Test for 5 x 4 Board.
     */
    @Test
    public void when5x4() {
        Board board = new Board();
        String rsl = board.paint(4, 3);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("X X X%s X X %sX X X%s X X %s", ln, ln, ln, ln)
        ));
    }
}