package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
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
     * The default output to the console.
     */
    private final PrintStream stdout = System.out;

    /**
     * The buffer for a result.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * Reassigns the output stream.
     */
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Reassigns the output stream back.
     */
    @After
    public void backOutput() {
        System.setOut(stdout);
    }

    /**
     * Tests when we a square needs to be drawn.
     */
    @Test
    public void whenDrawSquare() {
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
    }

    /**
     * Tests when a triangle needs to be drawn.
     */
    @Test
    public void whenDrawTriangle() {
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
    }
}