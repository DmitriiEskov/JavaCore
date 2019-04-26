package tree;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class for testing the Tree class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 24.04.2019
 */
public class TreeTest {

    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>();
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>();
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenIterIsUsedThenSuccess() {
        Tree<Integer> tree = new Tree<>();
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        Iterator<Node<Integer>> iter = tree.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next().getValue(), is(1));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next().getValue(), is(2));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next().getValue(), is(3));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next().getValue(), is(4));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next().getValue(), is(5));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next().getValue(), is(6));
        assertThat(iter.hasNext(), is(false));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenIterIsUsedAndNewElementWasAddedThenException() {
        Tree<Integer> tree = new Tree<>();
        tree.add(1, 2);
        tree.add(1, 3);
        Iterator<Node<Integer>> iter = tree.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next().getValue(), is(1));
        tree.add(3, 5);
        assertThat(iter.hasNext(), is(true));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenIterIsUsedAndNoElementsThenException() {
        Tree<Integer> tree = new Tree<>();
        Iterator<Node<Integer>> iter = tree.iterator();
        assertThat(iter.hasNext(), is(false));
        assertThat(iter.next().getValue(), is(1));
    }
}