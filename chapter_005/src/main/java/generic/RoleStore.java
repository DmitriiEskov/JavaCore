package generic;

/**
 * Class for creating roles for users.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 21.02.2019
 */
public class RoleStore extends AbstractStore<Role> {

    /**
     * The constructor.
     * @param size - size of the storage
     */
    public RoleStore(int size) {
        super(size);
    }

    /**
     * Adds an element.
     * @param model - an element
     */
    public void add(Role model) {
        super.add(model);
    }

    /**
     * Replaces an element.
     * @param id - id of an element
     * @param model - an element to replaced
     * @return true - if success, false otherwise
     */
    public boolean replace(String id, Role model) {
        return super.replace(id, model);
    }

    /**
     * Deletes an element.
     * @param id - id of an element
     * @return true - if success, false otherwise
     */
    public boolean delete(String id) {
        return super.delete(id);
    }

    /**
     * Finds an element by its id.
     * @param id - id of an element
     * @return true - if success, false otherwise
     */
    public Role findById(String id) {
        return super.findById(id);
    }
}