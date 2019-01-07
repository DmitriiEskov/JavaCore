package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Test for the ValidateInput class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 13.12.2018
 * @version 1.0
 */
public class ValidateInputTest {

    /**
     * The buffer for a result.
     */
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();

    /**
     * The default output to the console.
     */
    private final PrintStream out = System.out;

    /**
     * Reassigns the output stream.
     */
    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    /**
     * Reassigns the output stream back.
     */
    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    /**
     * Tests if a letter was put in (not a number!).
     */
    @Test
    public void whenInvalidInput() {
        ArrayList<Integer> range = new ArrayList<>();
        range.add(1);
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.ask("Select: ", range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please, provide a number.%n")
                )
        );
    }
}