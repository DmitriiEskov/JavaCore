package ru.job4j.tracker;

/**
 * Class for editing items of a tracker.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 26.12.2018
 * @version 1.0
 */
public class EditItem extends BaseAction {

    /**
     * The constructor.
     * @param key - the key
     * @param info - the info
     */
    public EditItem(int key, String info) {
        super(key, info);
    }

    /**
     * The method edits an item.
     * @param input Input's object
     * @param tracker Tracker's object
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Editing an item --------------");
        String id = input.ask("Write id of the item: ");
        String name = input.ask("Write a new name: ");
        String desc = input.ask("Write a new description: ");
        Item item = new Item(name, desc);
        item.setId(id);
        if (tracker.replace(id, item)) {
            System.out.println("------------ Editing complete --------------");
        } else {
            System.out.println("------------ Error: id not found! --------------");
        }
    }
}