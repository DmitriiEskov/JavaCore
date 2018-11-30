package ru.job4j.calculator;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for echo method.
 *
 * @author Dmitrii Eskov (dmitryhope@yahoo.com)
 * @version $Id$
 * @since 0.1
 */
public class CalculateTest {

    /**
     * Test echo.
     */
    @Test
    public void whenTakeNameThenTreeEchoPlusName() {
        String input = "Dmitrii Eskov";
        String expect = "Echo, echo, echo: Dmitrii Eskov";
        ru.job4j.calculator.Calculate calc = new ru.job4j.calculator.Calculate();
        String result = calc.echo(input);
        assertThat(result, is(expect));
    }
}