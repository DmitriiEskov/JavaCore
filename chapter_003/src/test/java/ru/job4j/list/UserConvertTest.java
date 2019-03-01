package ru.job4j.list;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing the "UserConvert" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 26.01.2019
 * @version 1.0
 */
public class UserConvertTest {

    /**
     * Tests a conversion from a List<User> into a HashMap<Integer, User>.
     */
    @Test
    public void whenListThenMap() {
        List<User> list = List.of(new User(0, "Sveta", "New York"),
                new User(51, "Roman", "San Francisco"),
                new User(55, "Peter", "St Petersburg"));
        UserConvert test = new UserConvert();
        Map<Integer, User> result = test.process(list);
        assert (result.containsValue(list.get(0)));
        assert (result.containsValue(list.get(1)));
        assert (result.containsValue(list.get(2)));
    }
}