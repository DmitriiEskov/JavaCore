package list;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class for testing the "LoopInLinkedList" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 04.03.2019
 */
public class LoopInLinkedListTest {

    /**
     * When a linked list has a loop.
     */
    @Test
    public void whenHasCycleThenTrue() {
        LoopInLinkedList.Node<Integer> first = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> second = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> third = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> fourth = new LoopInLinkedList.Node<Integer>();
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        assertThat(new LoopInLinkedList().hasCycle(first), is(true));
    }

    /**
     * When a linked list has a loop.
     */
    @Test
    public void whenHasCycleInMiddleThenTrue() {
        LoopInLinkedList.Node<Integer> first = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> second = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> third = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> fourth = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> fifth = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> sixth = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> seventh = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> eighth = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> ninth = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> tenth = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> eleventh = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> twelfth = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> thirteenth = new LoopInLinkedList.Node<Integer>();
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eighth;
        eighth.next = ninth;
        ninth.next = sixth;
        tenth.next = eleventh;
        eleventh.next = twelfth;
        twelfth.next = thirteenth;
        assertThat(new LoopInLinkedList().hasCycle(first), is(true));
    }

    /**
     * When a linked list has not got a loop.
     */
    @Test
    public void whenNotCycleThenFalse() {
        LoopInLinkedList.Node<Integer> first = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> second = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> third = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> fourth = new LoopInLinkedList.Node<Integer>();
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;
        assertThat(new LoopInLinkedList().hasCycle(first), is(false));
    }

    /**
     * When a linked list has not got a loop.
     */
    @Test
    public void whenFirstIsNull() {
        LoopInLinkedList.Node<Integer> first = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> second = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> third = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> fourth = new LoopInLinkedList.Node<Integer>();
        first.next = null;
        second.next = third;
        third.next = fourth;
        fourth.next = third;
        assertThat(new LoopInLinkedList().hasCycle(first), is(false));
    }

    /**
     * When a linked list has not got a loop.
     */
    @Test
    public void whenNullInMiddle() {
        LoopInLinkedList.Node<Integer> first = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> second = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> third = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> fourth = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> fifth = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> sixth = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> seventh = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> eighth = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> ninth = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> tenth = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> eleventh = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> twelfth = new LoopInLinkedList.Node<Integer>();
        LoopInLinkedList.Node<Integer> thirteenth = new LoopInLinkedList.Node<Integer>();
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = null;
        eighth.next = ninth;
        ninth.next = tenth;
        tenth.next = eleventh;
        eleventh.next = twelfth;
        twelfth.next = thirteenth;
        assertThat(new LoopInLinkedList().hasCycle(first), is(false));
    }
}