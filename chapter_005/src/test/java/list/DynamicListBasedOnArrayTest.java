package list;

import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class for testing the "DynamicListBasedOnArray" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 27.02.2019
 */
public class DynamicListBasedOnArrayTest {

    /**
     * The array.
     */
    private DynamicListBasedOnArray<Integer> array;

    /**
     * Setting the collection up.
     */
    @Before
    public void set() {
        this.array = new DynamicListBasedOnArray<>(10);
        for (int i = 0; i < 10; i++) {
            this.array.add(i);
        }
    }

    /**
     * When adding new elements to the array, then success.
     */
    @Test
    public void whenAddMoreElementsThenArrayIncreased() {
        this.array.add(111);
        this.array.add(222);
        assertThat(this.array.get(10), is(111));
        assertThat(this.array.get(11), is(222));
    }

    /**
     * When getting some elements form the array then success.
     */
    @Test
    public void whenGetElementsThenSuccess() {
        assertThat(this.array.get(0), is(0));
        assertThat(this.array.get(9), is(9));
    }

    /**
     * When using an iterator to get all the elements of the array.
     */
    @Test
    public void whenIterIsUsedThenSuccess() {
        Iterator<Integer> iter = this.array.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(0));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(1));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(2));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(3));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(4));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(5));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(6));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(7));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(8));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(9));
        assertThat(iter.hasNext(), is(false));
    }

    /**
     * When using an iterator and at the same time the array,
     * which the iterator is operating over, is being changed, then exception is thrown.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenIterIsUsedAndArrayIsChangedThenException() {
        Iterator<Integer> iter = this.array.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(0));
        this.array.add(10);
        iter.next();
    }
}