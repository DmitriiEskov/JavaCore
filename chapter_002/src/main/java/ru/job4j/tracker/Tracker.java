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
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * Replaces an item inside items array.
     * @param id - id of the item to be replaced
     * @param item - the item to be replaced
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i != this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Deletes an item inside items array.
     * @param id - the item to be deleted
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, this.items, index, this.position - index - 1);
                this.items[index + this.position - index - 1] = null;
                --this.position;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Returns a copy of items array but without null values.
     * @return result - the array without null values
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Finds a required name of items in the items array and returns a new array filled in with suitable items.
     * @param key - the required name of an item
     * @return result - an array filled in with items containing required names
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int i = 0;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getName().equals(key)) {
                result[i++] = this.items[index];
            }
        }
        return Arrays.copyOf(result, i);
    }
}