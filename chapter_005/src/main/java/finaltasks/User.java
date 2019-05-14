package finaltasks;

/**
 * Class for creating a user.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 12.05.2019
 */
public class User {

    /**
     * User's id.
     */
    private int id;

    /**
     * User's name.
     */
    private String name;

    /**
     * The constructor.
     * @param id - user's id
     * @param name - user's name
     */
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns user's name.
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns user's id.
     * @return id
     */
    public int getID() {
        return this.id;
    }
}