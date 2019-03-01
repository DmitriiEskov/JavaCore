package ru.job4j.tracker;

/**
 * A Tracker class for containing all created items.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 09.01.2019
 * @version 1.0
 */
public class TrackerSingleFourth {

    /**
     * The constructor.
     */
    private TrackerSingleFourth() {
    }

    /**
     * Creating a Tracker object.
     */
    public Tracker tracker = new Tracker();

    /**
     * Returns an instance of the "TrackerSingleFourth" class.
     * @return INSTANCE
     */
    public static TrackerSingleFourth getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * Class for holding an instance of the "TrackerSingleFourth" class.
     */
    private static final class Holder {
        private static final TrackerSingleFourth INSTANCE = new TrackerSingleFourth();
    }
}