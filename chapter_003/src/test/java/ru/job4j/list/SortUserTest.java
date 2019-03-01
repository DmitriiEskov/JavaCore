package ru.job4j.list;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing the "SortUser" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 29.01.2019
 * @version 1.0
 */
public class SortUserTest {

    /**
     * Tests when it needs to sort List<User> in order from little to high ages
     * and convert List into Set.
     */
    @Test
    public void whenListUserThenSetUser() {
        List<User> list = List.of(new User("Jack", 15), new User("Peter", 19), new User("Marina", 29));
        Set<User> result = new SortUser().sort(list);
        Iterator iter = result.iterator();
        assertThat(iter.next(), is(list.get(0)));
        assertThat(iter.next(), is(list.get(1)));
        assertThat(iter.next(), is(list.get(2)));
    }

    /**
     * Tests when it needs to sort a List<User> by a name length.
     */
    @Test
    public void whenSortByNameLength() {
        List<User> list = new ArrayList<>();
        User first = new User("Jack", 15);
        User second = new User("Peter", 19);
        User third = new User("Marina", 29);
        User fourth = new User("Jacks", 23);
        list.add(second);
        list.add(first);
        list.add(third);
        list.add(fourth);
        List<User> result = new SortUser().sortNameLength(list);
        Iterator iter = result.iterator();
        assertThat(iter.next(), is(first));
        assertThat(iter.next(), is(second));
        assertThat(iter.next(), is(fourth));
        assertThat(iter.next(), is(third));
    }

    /**
     * Tests when it needs to sort a List<User> lexicographically by a name and by an age.
     */
    @Test
    public void whenSortByAllFields() {
        List<User> list = new ArrayList<>();
        User first = new User("Sergey", 25);
        User second = new User("Ivan", 30);
        User third = new User("Sergey", 20);
        User fourth = new User("Ivan", 25);
        list.add(second);
        list.add(first);
        list.add(third);
        list.add(fourth);
        List<User> result = new SortUser().sortByAllFields(list);
        Iterator iter = result.iterator();
        assertThat(iter.next(), is(fourth));
        assertThat(iter.next(), is(second));
        assertThat(iter.next(), is(third));
        assertThat(iter.next(), is(first));
    }
}