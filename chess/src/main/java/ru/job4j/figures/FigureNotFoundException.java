package ru.job4j.figures;

/**
 * Class for creating an exception when a cell does not contain a figure.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 10.01.2019
 */
public class FigureNotFoundException extends RuntimeException {

    /**
     * The FigureNotFoundException.
     * @param message message of the exception
     */
    public FigureNotFoundException(String message) {
        super(message);
    }
}