package generic;

import java.util.Iterator;

/**
 * Class for some functions for classes that implement the "Store" interface.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 21.02.2019
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    /**
     * Storage of elements.
     */
    private SimpleArray<T> storage;

    /**
     * The constructor.
     * @param size - size of the storage
     */
    public AbstractStore(int size) {
        this.storage = new SimpleArray<>(size);
    }

    /**
     * Adds an element.
     * @param model - an element
     */
    public void add(T model) {
        this.storage.add(model);
    }

    /**
     * Replaces an element.
     * @param id - id of an element
     * @param model - an element to replaced
     * @return true - if success, false otherwise
     */
    public boolean replace(String id, T model) {
        boolean result = false;
        Iterator<T> iter = this.storage.iterator();
        int index = -1;
        while (iter.hasNext()) {
            index++;
            if (iter.next().getId().equals(id)) {
                this.storage.set(index, model);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Deletes an element.
     * @param id - id of an element
     * @return true - if success, false otherwise
     */
    public boolean delete(String id) {
        boolean result = false;
        Iterator<T> iter = this.storage.iterator();
        int index = -1;
        while (iter.hasNext()) {
            index++;
            if (iter.next().getId().equals(id)) {
                result = this.storage.remove(index);
                break;
            }
        }
        return result;
    }

    /**
     * Finds an element by its id.
     * @param id - id of an element
     * @return true - if success, false otherwise
     */
    public T findById(String id) {
        T result = null;
        Iterator<T> iter = this.storage.iterator();
        int index = -1;
        while (iter.hasNext()) {
            index++;
            if (iter.next().getId().equals(id)) {
                result = this.storage.get(index);
                break;
            }
        }
        return result;
    }
}