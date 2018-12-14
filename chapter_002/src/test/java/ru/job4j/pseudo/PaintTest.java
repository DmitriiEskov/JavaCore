package ru.job4j.pseudo;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for the Paint class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 14.12.2018
 * @version 1.0
 */
public class PaintTest {

    /**
     * Tests when we a square needs to be drawn.
     */
    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("+++++")
                                .append("+   +")
                                .append("+   +")
                                .append("+++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
        System.setOut(stdout);
    }

    /**
     * Tests when we a square needs to be drawn.
     */
    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                 .append("   ^   ")
                                 .append("  ^^^  ")
                                 .append(" ^^^^^ ")
                                 .append("^^^^^^^")
                                 .append(System.lineSeparator())
                                 .toString()
                )
        );
        System.setOut(stdout);
    }
}