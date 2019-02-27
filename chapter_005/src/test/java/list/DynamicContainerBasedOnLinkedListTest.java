package list;

import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class for testing the "DynamicContainerBasedOnLinkedList" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 27.02.2019
 */
public class DynamicContainerBasedOnLinkedListTest {

    /**
     * The container.
     */
    private DynamicContainerBasedOnLinkedList<Integer> container;

    /**
     * Setting the container up with elements.
     */
    @Before
    public void set() {
        this.container = new DynamicContainerBasedOnLinkedList<>();
        for (int i = 0; i < 10; i++) {
            this.container.add(i);
        }
    }

    /**
     * When adding new elements to the container, then success.
     */
    @Test
    public void whenAddMoreElementsThenListIncreased() {
        this.container.add(111);
        this.container.add(222);
        assertThat(this.container.get(1), is(111));
        assertThat(this.container.get(0), is(222));
    }

    /**
     * When getting some elements form the container, then success.
     */
    @Test
    public void whenGetElementsThenSuccess() {
        assertThat(this.container.get(0), is(9));
        assertThat(this.container.get(9), is(0));
    }

    /**
     * When using an iterator to get all the elements of the container.
     */
    @Test
    public void whenIterIsUsedThenSuccess() {
        Iterator<Integer> iter = this.container.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(9));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(8));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(7));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(6));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(5));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(4));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(3));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(2));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(1));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(0));
        assertThat(iter.hasNext(), is(false));
    }

    /**
     * When using an iterator and at the same time the container,
     * which the iterator is operating over, is being changed, then exception is thrown.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenIterIsUsedAndArrayIsChangedThenException() {
        Iterator<Integer> iter = this.container.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(9));
        this.container.add(1110);
        iter.next();
    }

    /**
     * When index >= a size of the container.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexNotExistThenException() {
        this.container.get(10);
    }
}