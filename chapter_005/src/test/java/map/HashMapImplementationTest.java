package map;

import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;

/**
 * Class for testing the "HashMapImplementation" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 24.03.2019
 */
public class HashMapImplementationTest {

    /**
     * Setting a HashMap up.
     */
    HashMapImplementation<Integer, Integer> table = new HashMapImplementation<>();

    /**
     * Filling in this.table.
     */
    @Before
    public void fillInHashMap() {
        for (int i = 0; i < 33; i++) {
            this.table.insert(i, i);
        }
    }

    /**
     * Inserts elements in the HashMap.
     */
    @Test
    public void whenInsertElementsThenSuccess() {
        assertThat(this.table.insert(33, 111), is(true));
        assertThat(this.table.insert(34, 111), is(true));
        assertThat(this.table.insert(35, 111), is(true));
    }

    /**
     * Inserts elements in the HashMap and fails.
     */
    @Test
    public void whenInsertElementsThenFail() {
        assertThat(this.table.insert(33, 111), is(true));
        assertThat(this.table.insert(33, 111), is(true));
    }

    /**
     * Gets elements from this.table.
     */
    @Test
    public void whenGetElementThenSuccess() {
        assertThat(this.table.get(0), is(0));
        assertThat(this.table.get(31), is(31));
        assertThat(this.table.get(14), is(14));
    }

    /**
     * Gets elements from this.table and fails.
     */
    @Test
    public void whenGetElementThenFail() {
        assertNull(this.table.get(63));
    }

    /**
     * When successfully deletes elements.
     */
    @Test
    public void whenDeleteElementThenSuccess() {
        assertThat(this.table.delete(10), is(true));
        assertThat(this.table.delete(0), is(true));
        assertThat(this.table.delete(32), is(true));
    }

    /**
     * When unsuccessfully deletes elements.
     */
    @Test
    public void whenDeleteElementThenFail() {
        assertThat(this.table.delete(35), is(false));
    }

    /**
     * When iter is successfully being used.
     */
    @Test
    public void whenIteratorIsTestedThenSuccess() {
        HashMapImplementation<Integer, Integer> map = new HashMapImplementation<>();
        for (int i = 0; i < 3; i++) {
            map.insert(i, i);
        }
        Iterator<Integer> iter = map.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(0));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(1));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(2));
        assertThat(iter.hasNext(), is(false));
    }

    /**
     * When iter is successfully being used.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenIteratorIsTestedWithNullsThenSuccess() {
        HashMapImplementation<Integer, Integer> map = new HashMapImplementation<>();
        for (int i = 0; i < 1; i++) {
            map.insert(i, i);
        }
        Iterator<Integer> iter = map.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(0));
        iter.next();
    }

    /**
     * When iter is unsuccessfully being used.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenIterIsUsedThenException() {
        HashMapImplementation<Integer, Integer> map = new HashMapImplementation<>();
        for (int i = 0; i < 3; i++) {
            map.insert(i, i);
        }
        Iterator<Integer> iter = map.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(0));
        map.insert(15, 16);
        assertThat(iter.next(), is(1));
    }
}