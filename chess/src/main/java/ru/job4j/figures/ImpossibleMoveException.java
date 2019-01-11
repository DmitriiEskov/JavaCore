package ru.job4j.figures;

/**
 * Class for creating an exception that is thrown if a figure cannot move to a cell.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 10.01.2019
 */
public class ImpossibleMoveException extends RuntimeException {

    /**
     * The ImpossibleMoveException.
     * @param message message of the exception
     */
    public ImpossibleMoveException(String message) {
        super(message);
    }
}