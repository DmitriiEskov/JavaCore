package ru.job4j.tracker;

/**
 * Class for searching for an item by a name.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 26.12.2018
 * @version 1.0
 */
public class FindItemByName extends BaseAction {

    /**
     * The constructor.
     * @param key - the key
     * @param info - the info
     */
    public FindItemByName(int key, String info) {
        super(key, info);
    }

    /**
     * The method finds an item by a name.
     * @param input Input's object
     * @param tracker Tracker's object
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Write a name of the item: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            System.out.println("------------ Success! --------------");
            for (Item i : items) {
                System.out.println("id: " + i.getId());
                System.out.println("Name: " + i.getName());
                System.out.println("Description: " + i.getDescription());
                System.out.println("Created: " + i.getCreate());
                System.out.println();
            }
        } else {
            System.out.println("------------ Name not found. --------------");
        }
    }
}