package finaltasks;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class for testing the "Analize" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 13.05.2019
 */
public class AnalizeTest {

    List<User> previous = Arrays.asList(new User(1, "Peter"),
            new User(2, "Jack"), new User(3, "Alex"));
    List<User> current = new ArrayList<>(previous);

    @Test
    public void whenDeletedThenSuccess() {
        current.remove(0);
        current.remove(0);
        Info info = new Analize().diff(previous, current);
        assertThat(info.getDeleted(), is(2));
        assertThat(info.getAdded(), is(0));
        assertThat(info.getChanged(), is(0));
    }

    @Test
    public void whenAddedThenSuccess() {
        current.add(new User(4, "Jacob"));
        current.add(new User(5, "Mishel"));
        Info info = new Analize().diff(previous, current);
        assertThat(info.getDeleted(), is(0));
        assertThat(info.getAdded(), is(2));
        assertThat(info.getChanged(), is(0));
    }

    @Test
    public void whenChangedThenSuccess() {
        current.remove(2);
        current.add(new User(3, "AlexNew"));
        Info info = new Analize().diff(previous, current);
        assertThat(info.getDeleted(), is(0));
        assertThat(info.getAdded(), is(0));
        assertThat(info.getChanged(), is(1));
    }

    @Test
    public void whenNullsAreNorDeletedNorAddedInsideCurrentThenSuccess() {
        List<User> prev = new ArrayList<>();
        prev.add(new User(1, "Jack"));
        prev.add(new User(2, "Johnson"));
        User first = null;
        User second = null;
        prev.add(first);
        prev.add(second);
        List<User> cur = new ArrayList<>(prev);
        cur.add(new User(12, "dsd"));
        cur.add(new User(13, "dsd"));
        cur.add(new User(14, "dsd"));
        cur.add(new User(15, "dsd"));
        Info info = new Analize().diff(prev, cur);
        assertThat(info.getDeleted(), is(0));
        assertThat(info.getAdded(), is(4));
        assertThat(info.getChanged(), is(0));
    }

    @Test
    public void whenNullsAreDeletedInsideCurrentThenSuccess() {
        List<User> prev = new ArrayList<>();
        prev.add(new User(1, "Jack"));
        prev.add(new User(2, "Johnson"));
        User first = null;
        User second = null;
        prev.add(first);
        prev.add(second);
        List<User> cur = new ArrayList<>(prev);
        cur.remove(0);
        cur.remove(0);
        Info info = new Analize().diff(prev, cur);
        assertThat(info.getDeleted(), is(2));
        assertThat(info.getAdded(), is(0));
        assertThat(info.getChanged(), is(0));
    }

    @Test
    public void whenAllActionsAtOneTimeThenSuccess() {
        List<User> prev = new ArrayList<>();
        prev.add(new User(1, "Jack"));
        prev.add(new User(2, "Johnson"));
        User first = null;
        prev.add(first);
        List<User> cur = new ArrayList<>(prev);
        cur.remove(2);
        cur.add(new User(12, "1"));
        cur.add(new User(13, "2"));
        cur.add(new User(14, "3"));
        cur.add(new User(15, "4"));
        cur.remove(0);
        cur.set(0, new User(2, "JohnsonNew"));
        Info info = new Analize().diff(prev, cur);
        assertThat(info.getDeleted(), is(1));
        assertThat(info.getAdded(), is(4));
        assertThat(info.getChanged(), is(1));
    }
}