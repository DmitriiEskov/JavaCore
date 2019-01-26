package ru.job4j.tracker;

import java.util.*;

/**
 * Class for making a menu.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 26.12.2018
 * @version 1.0
 */
public class MenuTracker {

    /**
     * An object for communicating with a user.
     */
    private Input input;

    /**
     * An object for creating a tracker.
     */
    private Tracker tracker;

    /**
     * The list for containing all the options of the Menu.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * The constructor.
     *
     * @param input Input's object
     * @param tracker Tracker's object
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * The method for getting an array of the menu.
     * @return length of an array
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * The method for filling an array in with menu options.
     */
    public void fillActions() {
        this.actions.add(this.new AddItem(0, "Add new item"));
        this.actions.add(this.new ShowItem(1, "Show items"));
        this.actions.add(this.new EditItem(2, "Edit item"));
        this.actions.add(this.new DeleteItem(3, "Delete item"));
        this.actions.add(this.new FindItemByID(4, "Find item by id"));
        this.actions.add(this.new FindItemByName(5, "Find item by name"));
    }

    /**
     * The method that does a specific action depending on a key.
     *
     * @param key an operation key
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * The method shows the menu.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.key() + ". " + action.info());
            }
        }
    }

    /**
     * Class for adding a new item to a tracker.
     *
     * @author Dmitrii Eskov (eskovdmi@gmail.com)
     * @since 26.12.2018
     * @version 1.0
     */
    public class AddItem extends BaseAction {

        /**
         * The constructor.
         * @param key - the key
         * @param info - the info
         */
        public AddItem(int key, String info) {
            super(key, info);
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
    }

    /**
     * Class for showing items of a tracker.
     *
     * @author Dmitrii Eskov (eskovdmi@gmail.com)
     * @since 26.12.2018
     * @version 1.0
     */
    public class ShowItem extends BaseAction {

        /**
         * The constructor.
         * @param key - the key
         * @param info - the info
         */
        public ShowItem(int key, String info) {
            super(key, info);
        }

        /**
         * The method shows all created items in a tracker.
         * @param input Input's object
         * @param tracker Tracker's object
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Showing all created items --------------");
            ArrayList<Item> items = tracker.getAll();
            for (Item i : items) {
                System.out.println();
                System.out.println("id: " + i.getId());
                System.out.println("Name: " + i.getName());
                System.out.println("Description: " + i.getDescription());
                System.out.println("Created: " + i.getCreate());
                System.out.println();
            }
        }
    }

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

    /**
     * Class for deleting an item.
     *
     * @author Dmitrii Eskov (eskovdmi@gmail.com)
     * @since 26.12.2018
     * @version 1.0
     */
    public class DeleteItem extends BaseAction {

        /**
         * The constructor.
         * @param key - the key
         * @param info - the info
         */
        public DeleteItem(int key, String info) {
            super(key, info);
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
    }

    /**
     * Class for searching for an item by an id.
     *
     * @author Dmitrii Eskov (eskovdmi@gmail.com)
     * @since 26.12.2018
     * @version 1.0
     */
    public class FindItemByID extends BaseAction {

        /**
         * The constructor.
         * @param key - the key
         * @param info - the info
         */
        public FindItemByID(int key, String info) {
            super(key, info);
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
    }

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
            ArrayList<Item> items = tracker.findByName(name);
            if (items.size() != 0) {
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
}