package ru.job4j.tracker;

/**
 * A Tracker class for containing all created items.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 09.01.2019
 * @version 1.0
 */
public enum TrackerSingle {
    INSTANCE;

    /**
     * Creating a Tracker object.
     */
    public Tracker tracker = new Tracker();
}