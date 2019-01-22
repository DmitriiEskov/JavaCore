package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing the "PriorityQueue" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 20.01.2019
 * @version 1.0
 */
public class PriorityQueueTest {

    /**
     * When it needs to get an element with the highest priority.
     */
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    /**
     * When it needs to get an element with the highest priority.
     */
    @Test
    public void whenHigherPriority2() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.take();
        Task result = queue.take();
        assertThat(result.getDesc(), is("middle"));
    }

    /**
     * When it needs to get all the elements.
     */
    @Test
    public void whenHigherPriority4() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("middle2", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle1", 3));
        queue.put(new Task("low", 8));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
        result = queue.take();
        assertThat(result.getDesc(), is("middle1"));
        result = queue.take();
        assertThat(result.getDesc(), is("middle2"));
        result = queue.take();
        assertThat(result.getDesc(), is("low"));
    }
}