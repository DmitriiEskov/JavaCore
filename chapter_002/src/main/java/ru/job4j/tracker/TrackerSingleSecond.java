package ru.job4j.tracker;

/**
 * A Tracker class for containing all created items.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 09.01.2019
 * @version 1.0
 */
public class TrackerSingleSecond {

    /**
     * Creating an instance of the TrackerSingleSecond class.
     */
    private static TrackerSingleSecond instance;

    /**
     * Creating a Tracker object.
     */
    public Tracker tracker = new Tracker();

    /**
     * The constructor.
     */
    private TrackerSingleSecond() {
    }

    /**
     * Returns an instance of the "TrackerSingleSecond" class.
     * @return instance
     */
    public static TrackerSingleSecond getInstance() {
        if (instance == null) {
            instance = new TrackerSingleSecond();
        }
        return instance;
    }
}