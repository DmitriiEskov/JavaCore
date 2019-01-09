package ru.job4j.tracker;

/**
 * A Tracker class for containing all created items.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 09.01.2019
 * @version 1.0
 */
public class TrackerSingleThird {

    /**
     * Creating an instance of the TrackerSingleThird class.
     */
    private static final TrackerSingleThird INSTANCE = new TrackerSingleThird();

    /**
     * Creating a Tracker object.
     */
    public Tracker tracker = new Tracker();

    /**
     * The constructor.
     */
    private TrackerSingleThird() {
    }

    /**
     * Returns an instance of the "TrackerSingleThird" class.
     * @return INSTANCE
     */
    public static TrackerSingleThird getInstance() {
        return INSTANCE;
    }
}