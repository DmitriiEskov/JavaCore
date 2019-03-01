package list;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class for testing the "SimpleStack" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 27.02.2019
 */
public class SimpleStackTest {

    /**
     * A stack.
     */
    private SimpleStack<Integer> stack;

    /**
     * Setting a stack up.
     */
    @Before
    public void set() {
        this.stack = new SimpleStack<>();
        for (int i = 0; i < 5; i++) {
            this.stack.push(i);
        }
    }

    /**
     * When adding elements, then success.
     */
    @Test
    public void whenPushElementsThenSuccess() {
        this.stack.push(100);
        this.stack.push(200);
    }

    /**
     * When deleting elements from the stack, then success.
     */
    @Test
    public void whenPollElementsThenSuccess() {
        assertThat(this.stack.poll(), is(4));
        assertThat(this.stack.poll(), is(3));
        assertThat(this.stack.poll(), is(2));
        assertThat(this.stack.poll(), is(1));
        assertThat(this.stack.poll(), is(0));
    }

    /**
     * When polling elements, then exception is thrown.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenPollElementsThenException() {
        assertThat(this.stack.poll(), is(4));
        assertThat(this.stack.poll(), is(3));
        assertThat(this.stack.poll(), is(2));
        assertThat(this.stack.poll(), is(1));
        assertThat(this.stack.poll(), is(0));
        this.stack.poll();
    }
}