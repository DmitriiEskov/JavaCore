package ru.job4j.tracker;

/**
 * Class for deleting an item.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 26.12.2018
 * @version 1.0
 */
public class DeleteItem implements UserAction {

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
    public DeleteItem(int key, String info) {
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
     * The method deletes an item.
     * @param input Input's object
     * @param tracker Tracker's object
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Write id of the item: ");
        if (tracker.delete(id)) {
            System.out.println("------------ Deleting complete. ----------------");
        } else {
            System.out.println("------------ Error: id not found! --------------");
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