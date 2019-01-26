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
        List<User> list = new ArrayList<>();
        User sveta = new User(0, "Sveta", "New York");
        User roman = new User(51, "Roman", "San Francisco");
        User peter = new User(55, "Peter", "St Petersburg");
        list.add(sveta);
        list.add(roman);
        list.add(peter);
        UserConvert test = new UserConvert();
        Map<Integer, User> expect = new HashMap<>();
        expect.put(0, sveta);
        expect.put(55, peter);
        expect.put(51, roman);
        Map<Integer, User> result = test.process(list);
        assertThat(result, is(expect));
    }
}