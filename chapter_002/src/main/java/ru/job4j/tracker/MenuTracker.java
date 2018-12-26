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
     * The array for containing all the options of the Menu.
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
        this.actions.add(new AddItem(0, "Add new item"));
        this.actions.add(new ShowItem(1, "Show items"));
        this.actions.add(new EditItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemByID(4, "Find item by id"));
        this.actions.add(new FindItemByName(5, "Find item by name"));
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
}