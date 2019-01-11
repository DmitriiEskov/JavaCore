package ru.job4j.figures;

/**
 * Class for creating an exception that is thrown if an array of cells,
 * which a figure is supposed to come through, contains some other figures.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 10.01.2019
 */
public class OccupiedWayException extends RuntimeException {

    /**
     * The OccupiedWayException.
     * @param message message of the exception
     */
    public OccupiedWayException(String message) {
        super(message);
    }
}