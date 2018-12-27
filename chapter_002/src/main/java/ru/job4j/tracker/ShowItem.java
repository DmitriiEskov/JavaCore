package ru.job4j.tracker;

/**
 * Class for showing items of a tracker.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 26.12.2018
 * @version 1.0
 */
public class ShowItem implements UserAction {

    /**
     * Menu's option.
     */
    private int key;

    /**
     *  Menu's option information.
     */
    private String info;

    /**
     * The constructor.
     * @param key - the key
     * @param info - the info
     */
    public ShowItem(int key, String info) {
        this.key = key;
        this.info = info;
    }

    /**
     * The method returns a menu's option.
     * @return a menu's option
     */
    @Override
    public int key() {
        return this.key;
    }

    /**
     * The method shows all created items in a tracker.
     * @param input Input's object
     * @param tracker Tracker's object
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Showing all created items --------------");
        Item[] items = tracker.getAll();
        for (Item i : items) {
            System.out.println();
            System.out.println("id: " + i.getId());
            System.out.println("Name: " + i.getName());
            System.out.println("Description: " + i.getDescription());
            System.out.println("Created: " + i.getCreate());
            System.out.println();
        }
    }

    /**
     * Menu's option information.
     * @return the information
     */
    @Override
    public String info() {
        return this.info;
    }
}