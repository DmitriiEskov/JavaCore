package ru.job4j.pseudo;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for the Triangle class implementation.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 14.12.2018
 * @version 1.0
 */
public class TriangleTest {

    /**
     * Tests when we want a square to be drawn.
     */
    @Test
    public void whenDrawSquare() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("   ^   ")
                                .append("  ^^^  ")
                                .append(" ^^^^^ ")
                                .append("^^^^^^^")
                                .toString()
                )
        );
    }
}