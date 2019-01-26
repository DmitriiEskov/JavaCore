package ru.job4j.tracker;

import java.util.*;

/**
 * Class for containing all created items.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 08.12.2018
 * @version 1.0
 */
public class Tracker {

    /**
     * items - an array that contains created items.
     * position - an index for a new item
     * RN - generates random numbers
     */
    private final ArrayList<Item> items = new ArrayList<Item>();
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Adds an item to the list.
     * @param item  - a new item
     * @return Item - the item
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Generates an id for an item.
     * @return a generated id.
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Searches an item in the items list.
     * @param id - id of an item
     * @return Item - if found, otherwise - null
     */
    protected Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Shows all items created.
     * @return ArrayList<Item> - the list with all items created
     */
    public ArrayList<Item> getAll() {
        ArrayList<Item> result = new ArrayList<Item>();
        result.addAll(this.items);
        return result;
    }

    /**
     * Replaces an item inside items list.
     * @param id - id of the item to be replaced
     * @param item - the item to be replaced
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i != this.items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                this.items.set(i, item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Deletes an item inside items list.
     * @param id - the item to be deleted
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                this.items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Returns a copy of items list but without null values.
     * @return result - the list without null values
     */
    public ArrayList<Item> findAll() {
        ArrayList<Item> result = new ArrayList<Item>();
        for (Item value : this.items) {
            if (value != null) {
                result.add(value);
            }
        }
        return result;
    }

    /**
     * Finds a required name of items in the items list and returns a new list filled in with suitable items.
     * @param key - the required name of an item
     * @return result - a list filled in with items containing required names
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<Item>();
        for (Item value : this.items) {
            if (key.equals(value.name)) {
                result.add(value);
            }
        }
        return result;
    }
}