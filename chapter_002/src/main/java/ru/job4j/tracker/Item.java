package ru.job4j.tracker;

/**
 * Class for creating items.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 08.12.2018
 * @version 1.0
 */
public class Item {

    /**
     * id of an item.
     */
    private String id;

    /**
     * Name of an item.
     */
    public String name;

    /**
     * Description of an item.
     */
    public String description;

    /**
     * The time of creating of an item.
     */
    public long create;

    /**
     * Comments of an item.
     */
    public String[] comments;

    /**
     * The default constructor.
     */
    public Item() {
    }

    /**
     * The constructor.
     * @param name - name of an item
     * @param description - description of an item
     * @param create - time of creating of an item
     */
    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    /**
     * Returns a name of an item.
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns a description of an item.
     * @return a description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns the time of creating of an item.
     * @return time
     */
    public long getCreate() {
        return this.create;
    }

    /**
     * Returns an id of an item.
     * @return an id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Sets an id of an item.
     * @param id - an id
     */
    public void setId(String id) {
        this.id = id;
    }
}