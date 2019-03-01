package ru.job4j.idealweight;

/**
 * Class for calculating ideal weight (men and women).
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 05.06.2017
 * @version 1.0
 */
public class Fit {

    /**
     * Ideal weight for men.
     * @param height - height
     * @return weight - ideal weight
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Ideal weight for women.
     * @param height height
     * @return ideal weight
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}