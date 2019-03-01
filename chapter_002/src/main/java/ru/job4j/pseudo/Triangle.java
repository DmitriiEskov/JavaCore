package ru.job4j.pseudo;

/**
 * Class for drawing a triangle.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 14.12.2018
 */
public class Triangle implements Shape {

    /**
     * Draws a triangle.
     * @return a square
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   ^   ");
        pic.append("  ^^^  ");
        pic.append(" ^^^^^ ");
        pic.append("^^^^^^^");
        return pic.toString();
    }
}