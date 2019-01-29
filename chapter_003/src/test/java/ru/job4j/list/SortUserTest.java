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
        List<User> list = new ArrayList<>();
        User first = new User("Jack", 15);
        User second = new User("Peter", 19);
        User third = new User("Marina", 29);
        list.add(second);
        list.add(first);
        list.add(third);
        Set<User> result = new SortUser().sort(list);
        Iterator iter = result.iterator();
        assertThat(iter.next(), is(first));
        assertThat(iter.next(), is(second));
        assertThat(iter.next(), is(third));
    }
}