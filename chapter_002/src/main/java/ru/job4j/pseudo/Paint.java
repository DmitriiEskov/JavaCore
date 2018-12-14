package ru.job4j.pseudo;

/**
 * Class for drawing a shape.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 14.12.2018
 */
public class Paint {

    /**
     * Draws a shape of a Shape's implementations.
     * @param shape - a shape
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}