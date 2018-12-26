package ru.job4j.tracker;

/**
 * Class for searching for an item by an id.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 26.12.2018
 * @version 1.0
 */
public class FindItemByID implements UserAction {

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
    public FindItemByID(int key, String info) {
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
     * The method finds an item by an id.
     * @param input Input's object
     * @param tracker Tracker's object
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Write id of the item: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("------------ Success! --------------");
            System.out.println("id: " + item.getId());
            System.out.println("Name: " + item.getName());
            System.out.println("Description: " + item.getDescription());
            System.out.println("Create: " + item.getCreate());
        } else {
            System.out.println("------------ id not found. --------------");
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