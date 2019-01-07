package ru.job4j.tracker;

/**
 * Class for creating an exception that is factually the same as ArrayIndexOutOfBoundsException.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 07.01.2019
 */
public class MenuOutException extends RuntimeException {

    /**
     * The MenuOutException exception.
     * @param message message of the exception
     */
    public MenuOutException(String message) {
        super(message);
    }
}