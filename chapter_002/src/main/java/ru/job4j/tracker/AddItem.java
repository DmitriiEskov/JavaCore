package ru.job4j.tracker;

/**
 * Class for adding a new item to a tracker.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 26.12.2018
 * @version 1.0
 */
public class AddItem implements UserAction {

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
    public AddItem(int key, String info) {
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
     * The primary method.
     * @param input Input's object
     * @param tracker Tracker's object
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Adding new item --------------");
        String name = input.ask("Please, provide item name: ");
        String desc = input.ask("Please, provide item description: ");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("------------ New Item with id: " + item.getId());
        System.out.println("------------ New Item with Name: " + item.getName());
        System.out.println("------------ New Item with Description: " + item.getDescription());
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