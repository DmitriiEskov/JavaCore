package ru.job4j.converter;

/**
 * Class for currency converting.
 */
public class Converter {

    /**
     * Converting rubles into euro.
     * @param value rubles
     * @return euro
     */
    public double rubleToEuro(double value) {
        return value / 75;
    }

    /**
     * Converting rubles into dollars.
     * @param value rubles
     * @return dollars
     */
    public double rubleToDollar(double value) {
        return value / 65;
    }

    /**
     * Converting dollars into rubles.
     * @param value dollars
     * @return rubles
     */
    public double dollarToRuble(double value) {
        return value * 60;
    }

    /**
     * Converting euro into rubles.
     * @param value euro
     * @return rubles
     */
    public double euroToRuble(double value) {
        return value * 70;
    }
}