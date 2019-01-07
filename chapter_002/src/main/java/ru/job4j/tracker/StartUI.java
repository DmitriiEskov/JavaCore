package ru.job4j.tracker;

import java.util.*;

/**
 * Class for starting the "Tracker" application.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 12.12.2018
 */
public class StartUI {

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
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        ArrayList<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("Select: ", range));
        } while (!"y".equals(this.input.ask("Exit? (y/n): ")));
    }


    /**
     * The start of the programme.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}