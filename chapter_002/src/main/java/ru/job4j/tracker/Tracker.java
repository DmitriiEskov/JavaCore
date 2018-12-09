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
    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Adds an item to the array.
     * @param item  - a new item
     * @return Item - the item
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
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
     * Searches an item in the items array.
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
     * @return Item[] - the array with all items created
     */
    public Item[] getAll() {
        Item[] result = new Item[position];
        for (int index = 0; index != position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * Replaces an item inside items array.
     * @param id - id of the item to be replaced
     * @param item - the item to be replaced
     */
    public void replace(String id, Item item) {
        for (int i = 0; i != position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                break;
            }
        }
    }

    /**
     * Deletes an item inside items array.
     * @param id - the item to be deleted
     */
    public void delete(String id) {
        for (int index = 0; index < position; index++) {
            if (this.items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, this.items, index, this.position - index - 1);
                this.items[index + this.position - index - 1] = null;
                break;
            }
        }
    }

    /**
     * Returns a copy of items array but without null values.
     * @return result - the array without null values
     */
    public Item[] findAll() {
        int i = 0;
        for (int j = 0; j < this.position; j++) {
            if (this.items[j] == null) {
                i++;
            }
        }
        Item[] result = new Item[this.position - i];
        System.arraycopy(this.items, 0, result, 0, this.position - i);
        return result;
    }

    /**
     * Finds a necessary name of items in the items array and returns a new array filled in with suitable items.
     * @param key - the necessary name of an item
     * @return result - an array filled in with items containing required names
     */
    public Item[] findByName(String key) {
        Item[] buffer = new Item[position];
        int i = 0;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getName().equals(key)) {
                buffer[i] = this.items[index];
                i++;
            }
        }
        Item[] result = new Item[i];
        if (i != 0) {
            System.arraycopy(buffer, 0, result, 0, i);
        } else {
            result = null;
        }
        return result;
    }
}