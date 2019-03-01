package ru.job4j.condition;

/**
 * Class for creating a point with x and y.
 *
 * @author Dmitrii Eskov (dmitryhope@yahoo.com)
 * @version 1.0
 * @since 07.06.2018
 */
public class Point {
    private int x;
    private int y;

    /**
     * Constructor.
     * @param x - position for .x
     * @param y - position for .y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Distance between .A and .B
     * @param that - x and y for Point that
     * @return distance between .A and .B
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }

    public static void main(String[] arqs) {
        Point a = new Point(10, 10);
        Point b = new Point(5, 5);
        double result = a.distanceTo(b);
        double secondResult = a.distanceTo(a);
        System.out.println("Расстояние между точками А и Б равно: " + result);
        System.out.println("Расстояние точки А между собой: " + secondResult);
    }
}