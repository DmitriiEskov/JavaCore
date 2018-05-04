package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CalculatorTests.
 *
 * @author Dmitrii Eskov (dmitryhope@yahoo.com)
 * @version 1.0
 * @since 04.05.2018
 */
public class CalculatorTest {
    /**
     * Test for addition.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test for subtraction.
     */
    @Test
    public void whenTenMinusFiveThenFive() {
        Calculator calc = new Calculator();
        calc.subtraction(10D, 5D);
        double result = calc.getResult();
        double expected = 5D;
        assertThat(result, is(expected));
    }

    /**
     * Test for multiplication.
     */
    @Test
    public void whenSevenTimesSevenThenFortyNine() {
        Calculator calc = new Calculator();
        calc.multiplication(7D, 7D);
        double result = calc.getResult();
        double expected = 49D;
        assertThat(result, is(expected));
    }

    /**
     * Test for division.
     */
    @Test
    public void whenOneHundredDividedByTwoThenFifty() {
        Calculator calc = new Calculator();
        calc.division(100D, 2D);
        double result = calc.getResult();
        double expected = 50D;
        assertThat(result, is(expected));
    }
}