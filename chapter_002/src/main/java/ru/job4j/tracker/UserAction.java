package ru.job4j.tracker;

/**
 * Interface for the "Tracker" task.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 26.12.2018
 */
public interface UserAction {

    /**
     * The method returns a key for an option.
     * @return a key
     */
    int key();

    /**
     * The primary method.
     * @param input Input's object
     * @param tracker Tracker's object
     */
    void execute(Input input, Tracker tracker);

    /**
     * The method returns information of Menu's string.
     * @return Menu's string
     */
    String info();
}