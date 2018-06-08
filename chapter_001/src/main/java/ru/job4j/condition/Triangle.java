package ru.job4j.condition;

/**
 * Calculating an area for a triangle.
 *
 * @author Dmitrii Eskov (dmitryhope@yahoo.com)
 * @version 1.0
 * @since 07.06.2018
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    /**
     * Constructor.
     *
     * @param a - point a
     * @param b - point b
     * @param c - point c
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Method for calculating a semi-perimeter.
     *
     * @param ab - distance between a and b
     * @param ac - distance between a and c
     * @param bc - distance between b and c
     * @return semi-perimeter
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Calculating an area of a triangle.
     * @return the area
     */
    public double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(
                    p * (p - ab) * (p - ac) * (p - bc)
            );
        }
        return rsl;
    }

    /**
     * Checking if a triangle exists.
     * @return true/false
     */
    public boolean exist(double ab, double ac, double bc) {
        return (ab < ac + bc) && (ac < ab + bc) && (bc < ab + ac);
    }
}