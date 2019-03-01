package list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class for testing the SimpleArrayList.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 26.02.2019
 */
public class SimpleArrayListTest {

    /**
     * One-way linked list.
     */
    private SimpleArrayList<Integer> list;

    /**
     * Setting a one-way linked list up.
     */
    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

    }

    /**
     * When getting the second element out of 3.
     */
    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    /**
     * When getting the size of the list.
     */
    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    /**
     * When deleting the first element.
     */
    @Test
    public void whenAddThreeElementsThenDeleteFirst() {
        assertThat(list.delete(), is(3));
    }

    /**
     * When deleting the first element.
     */
    @Test
    public void whenAddSixElementsThenDeleteFirst() {
        this.list.add(123);
        this.list.add(223);
        this.list.add(323);
        assertThat(list.delete(), is(323));
    }
}