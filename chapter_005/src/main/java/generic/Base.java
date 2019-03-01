package generic;

/**
 * Class for creating a model for storing some information in a Store class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 21.02.2019
 */
public abstract class Base {

    /**
     * Id of an element to be stored.
     */
    private final String id;

    /**
     * The constructor.
     * @param id - id of an element to be stored
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**
     * Returns an id of an element.
     * @return an id
     */
    public String getId() {
        return this.id;
    }
}