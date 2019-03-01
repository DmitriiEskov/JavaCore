package generic;

/**
 * Interface for creating objects to store some information.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 21.02.2019
 */
public interface Store<T extends Base> {

    /**
     * Adds an element.
     * @param model - an element
     */
    void add(T model);

    /**
     * Replaces an element.
     * @param id - id of an element
     * @param model - an element to replaced
     * @return true - if success, false otherwise
     */
    boolean replace(String id, T model);

    /**
     * Deletes an element.
     * @param id - id of an element
     * @return true - if success, false otherwise
     */
    boolean delete(String id);

    /**
     * Finds an element by its id.
     * @param id - id of an element
     * @return true - if success, false otherwise
     */
    T findById(String id);
}