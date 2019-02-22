package generic;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;

/**
 * Class for testing the "Store" interface and the "AbstractStore" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 22.02.2019
 */
public class StoreTest {

    /**
     * Storage of users.
     */
    private UserStore users;

    /**
     * Storage of roles.
     */
    private RoleStore roles;

    /**
     * Setting up the storage of users.
     */
    @Before
    public void setUpUserStore() {
        this.users = new UserStore(6);
        users.add(new User("1"));
        users.add(new User("2"));
        users.add(new User("3"));
        users.add(new User("4"));
        users.add(new User("5"));
    }

    /**
     * Setting up the storage of roles.
     */
    @Before
    public void setUpRoleStore() {
        this.roles = new RoleStore(6);
        roles.add(new Role("11"));
        roles.add(new Role("22"));
        roles.add(new Role("33"));
        roles.add(new Role("44"));
        roles.add(new Role("55"));
    }

    /**
     * When adding a new user.
     */
    @Test
    public void whenAddElementsToUserStoreThenSuccess() {
        this.users.add(new User("7"));
    }

    /**
     * When adding a new role.
     */
    @Test
    public void whenAddElementsToRoleStoreThenSuccess() {
        this.roles.add(new Role("17"));
    }

    /**
     * When replacing a user.
     */
    @Test
    public void whenReplaceUserThenTrueOrFalse() {
        assertThat(this.users.replace("1", new User("66")), is(true));
        assertThat(this.users.replace("3", new User("55")), is(true));
        assertThat(this.users.replace("5", new User("77")), is(true));
        assertThat(this.users.replace("6", new User("34")), is(false));
        assertThat(this.users.replace("7", new User("36")), is(false));
    }

    /**
     * When replacing a role.
     */
    @Test
    public void whenReplaceRoleThenTrueOrFalse() {
        assertThat(this.roles.replace("11", new Role("66")), is(true));
        assertThat(this.roles.replace("22", new Role("71")), is(true));
        assertThat(this.roles.replace("33", new Role("77")), is(true));
        assertThat(this.roles.replace("45", new Role("34")), is(false));
        assertThat(this.roles.replace("58", new Role("36")), is(false));
    }

    /**
     * When deleting users.
     */
    @Test
    public void whenDeleteUsersThenTrueOrFalse() {
        assertThat(this.users.delete("1"), is(true));
        assertThat(this.users.delete("6"), is(false));
    }

    /**
     * When deleting roles.
     */
    @Test
    public void whenDeleteRolesThenTrueOrFalse() {
        assertThat(this.roles.delete("11"), is(true));
        assertThat(this.roles.delete("56"), is(false));
    }

    /**
     * When searching for a user by their id.
     */
    @Test
    public void whenFindUserByIDThenSuccessOrNull() {
        User user = new User("12");
        this.users.add(user);
        assertThat(this.users.findById("12"), is(user));
        assertNull(this.users.findById("13"));
    }

    /**
     * When searching for a role by their id.
     */
    @Test
    public void whenFindRoleByIDThenSuccessOrNull() {
        Role role = new Role("12");
        this.roles.add(role);
        assertThat(this.roles.findById("12"), is(role));
        assertNull(this.roles.findById("13"));
    }
}