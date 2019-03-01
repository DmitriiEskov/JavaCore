package ru.job4j.calculator;

/**
 * Class for the simple Calculator.
 *
 * @author Dmitrii Eskov (dmitryhope@yahoo.com)
 * @version 1.0
 * @since 04.05.2018
 */
public class Calculator {

    /**
     * result.
     */
    private double result;

    /**
     * add.
     * @param first  - first
     * @param second - second
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * subtraction.
     * @param first - first
     * @param second - second
     */
    public void subtraction(double first, double second) {
        this.result = first - second;
    }

    /**
     * multiplication.
     * @param first - first
     * @param second - second
     */
    public void multiplication(double first, double second) {
        this.result = first * second;
    }

    /**
     * division.
     * @param first - first
     * @param second - second
     */
    public void division(double first, double second) {
        this.result = first / second;
    }

    /**
     * getting the result.
     * @return - result
     */
    public double getResult() {
        return this.result;
    }
}