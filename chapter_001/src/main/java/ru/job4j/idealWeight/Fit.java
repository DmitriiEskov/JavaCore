package ru.job4j.idealweight;

/**
 * Programme for calculating ideal weight (men and women).
 */
public class Fit {

    /**
     * Ideal weight for men and women.
     * @param height - рост
     * @return weight - идеальный вес
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост
     * @return идеальный вес
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}
