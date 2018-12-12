package ru.job4j.tracker;

/**
 * Class for starting the "Tracker" application.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 12.12.2018
 */
public class StartUI {

    /**
     * A Menu constant for adding an item.
     */
    private final static String ADD = "0";

    /**
     * A Menu constant for showing all created items.
     */
    private final static String SHOW = "1";

    /**
     * A Menu constant for editing an item.
     */
    private final static String EDIT = "2";

    /**
     * A Menu constant for deleting an item.
     */
    private final static String DELETE = "3";

    /**
     * A Menu constant for searching for an item by an id.
     */
    private final static String FIND_BY_ID = "4";

    /**
     * A Menu constant for searching for an item by a name.
     */
    private final static String FIND_BY_NAME = "5";

    /**
     * A Menu constant for exit.
     */
    private final static String EXIT = "6";

    /**
     * The storage for keeping all items.
     */
    private final Tracker tracker;

    /**
     * Receiving user's data.
     */
    private Input input;

    /**
     * The constructor.
     * @param input - data input
     * @param tracker - data storage
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * The main cycle of the programme.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Choose an action from the above, please: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findById();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Adds a new item to a tracker.
     */
    private void createItem() {
        System.out.println("------------ Adding an item --------------");
        String name = this.input.ask("Write a name of the item: ");
        String desc = this.input.ask("Write a description of the item: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Here is the new item with the following id: " + item.getId() + " -----------");
    }

    /**
     * Shows all created items of a tracker.
     */
    private void showItems() {
        System.out.println("------------ Showing all created items --------------");
        Item[] items = this.tracker.getAll();
        for (Item i : items) {
            System.out.println();
            System.out.println("id: " + i.getId());
            System.out.println("Name: " + i.getName());
            System.out.println("Created: " + i.getCreate());
            System.out.println("Description: " + i.getDescription());
            System.out.println();
        }
    }

    /**
     * Edits an item.
     */
    private void editItem() {
        System.out.println("------------ Editing an item --------------");
        String id = this.input.ask("Write id of the item: ");
        String name = this.input.ask("Write a new name: ");
        String desc = this.input.ask("Write a new description: ");
        Item item = new Item(name, desc);
        item.setId(id);
        if (this.tracker.replace(id, item)) {
            System.out.println("------------ Editing complete --------------");
        } else {
            System.out.println("------------ Error: id not found! --------------");
        }
    }

    /**
     * Deletes an item.
     */
    private void deleteItem() {
        String id = this.input.ask("Write id of the item: ");
        if (this.tracker.delete(id)) {
            System.out.println("------------ Deleting complete. ----------------");
        } else {
            System.out.println("------------ Error: id not found! --------------");
        }
    }

    /**
     * Finds an item by an id.
     */
    private void findById() {
        String id = this.input.ask("Write id of the item: ");
        Item item = this.tracker.findById(id);
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
     * Finds by a Name.
     */
    private void findByName() {
        String name = this.input.ask("Write a name of the item: ");
        Item[] items = this.tracker.findByName(name);
        if (items.length != 0) {
            System.out.println("------------ Success! --------------");
            for (Item i : items) {
                System.out.println("id: " + i.getId());
                System.out.println("Name: " + i.getName());
                System.out.println("Description: " + i.getDescription());
                System.out.println("Create: " + i.getCreate());
                System.out.println();
            }
        } else {
            System.out.println("------------ Name not found. --------------");
        }
    }

    /**
     * Shows the programme Menu.
     */
    private void showMenu() {
        System.out.println("Menu");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit item.");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by an id.");
        System.out.println("5. Find items by a name.");
        System.out.println("6. Exit Programme.");
    }

    /**
     * The start of the programme.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}