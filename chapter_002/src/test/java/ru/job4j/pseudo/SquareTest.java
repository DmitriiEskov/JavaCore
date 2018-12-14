package ru.job4j.pseudo;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for the Square class implementation.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 14.12.2018
 * @version 1.0
 */
public class SquareTest {

    /**
     * Tests when we want a square to be drawn.
     */
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("+++++")
                                .append("+   +")
                                .append("+   +")
                                .append("+++++")
                                .toString()
                )
        );
    }
}