package generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;

/**
 * Class for testing the "SimpleArray" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 21.02.2019
 */
public class SimpleArrayTest {

    /**
     * A testing array.
     */
    SimpleArray<Integer> array;

    /**
     * When adding elements.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddElement() {
        assertThat(this.array.add(999), is(true));
        this.array.add(1000);
    }

    /**
     * Creating a SimpleArray and filling in with 10 elements
     */
    @Before
    public void setUp() {
        this.array = new SimpleArray<Integer>(11);
        int index = 0;
        while (index < 10) {
            this.array.add(index++);
        }
    }

    /**
     * When removing elements.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRemoveElements() {
        assertThat(this.array.remove(9), is(true));
        assertNull(this.array.get(9));
        assertThat(this.array.remove(0), is(true));
        assertNull(this.array.get(8));
        this.array.remove(11);
    }

    /**
     * When removing elements.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetElements() {
        assertThat(this.array.get(9), is(9));
        assertThat(this.array.get(0), is(0));
        this.array.get(175);
    }

    /**
     * When setting elements.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenSetElements() {
        this.array.set(0, 5);
        assertThat(this.array.get(0), is(5));
        this.array.set(5, 196);
        assertThat(this.array.get(5), is(196));
        this.array.set(13, 187);
    }

    /**
     * When getting and using an iterator of the array.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenGetAndUseIterator() {
        Iterator<Integer> iter = this.array.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(0));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(1));
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        assertThat(iter.hasNext(), is(false));
        iter.next();
    }
}