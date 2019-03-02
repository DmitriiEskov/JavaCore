package list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;

/**
 * Class for testing the "SimpleQueue" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 02.03.2019
 */
public class SimpleQueueTest {

    /**
     * A queue.
     */
    private SimpleQueue<Integer> queue;

    /**
     * Setting this.queue up.
     */
    @Before
    public void set() {
        this.queue = new SimpleQueue<>();
        for (int i = 0; i < 5; i++) {
            this.queue.push(i);
        }
    }

    /**
     * When receiving elements from this.queue.
     */
    @Test
    public void whenPollElementsThenSuccess() {
        assertThat(this.queue.poll(), is(0));
        assertThat(this.queue.poll(), is(1));
        assertThat(this.queue.poll(), is(2));
        assertThat(this.queue.poll(), is(3));
        assertThat(this.queue.poll(), is(4));
        assertNull(this.queue.poll());
    }

    /**
     * When adding elements to this.queue, then success.
     */
    @Test
    public void whenAddElementsThenSuccess() {
        this.queue.push(111);
        this.queue.push(22222);
        this.queue.push(555555555);
    }
}