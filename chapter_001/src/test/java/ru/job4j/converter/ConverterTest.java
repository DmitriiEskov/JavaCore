package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {
    /**
     * Test for conversion of rubles into dollars.
     */
    @Test
    public void when60RublesToDollarThen1() {
        Converter converter = new Converter();
        double result = converter.rubleToDollar(60);
        assertThat(result, is(1.0));
    }

    /**
     * Test for conversion of rubles into euro.
     */
    @Test
    public void when70RublesToEuroThen() {
        Converter converter = new Converter();
        double result = converter.rubleToEuro(70);
        assertThat(result, is(1.0));
    }

    /**
     * Test for conversion of euro into rubles.
     */
    @Test
    public void when1000EuroToRublesThen70000() {
        Converter converter = new Converter();
        double result = converter.euroToRuble(1000);
        assertThat(result, is(70000.0));
    }

    /**
     * Test for conversion of dollars into rubles.
     */
    @Test
    public void when1000DollarsToRublesThen60000() {
        Converter converter = new Converter();
        double result = converter.dollarToRuble(1000);
        assertThat(result, is(60000.0));
    }
}