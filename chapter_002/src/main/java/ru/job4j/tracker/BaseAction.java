package ru.job4j.tracker;

/**
 * Class for refactoring all the actions of a Menu of a Tracker.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 08.01.2019
 */
public abstract class BaseAction implements UserAction  {

    /**
     * A key for an option
     */
    private final int key;

    /**
     * Some information of a Menu's string.
     */
    private final String name;

    /**
     * The constructor.
     */
    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * The method returns a key for an option.
     * @return a key
     */
    @Override
    public int key() {
        return this.key;
    }

    /**
     * The method returns information of Menu's string.
     * @return Menu's string
     */
    @Override
    public String info() {
        return this.name;
    }
}