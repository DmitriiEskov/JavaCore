package list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class for creating a container for storing any information based on a linked list.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 27.02.2019
 */
public class DynamicContainerBasedOnLinkedList<E> implements Iterable<E> {

    /**
     * An array for storing the information of a class.
     */
    private Node<E> first = new Node<>();

    /**
     * Size of the two-way linked list.
     */
    private int size;

    /**
     * The counter of any changes to the array.
     */
    private int modeCount;

    /**
     * Adds element to the beginning of the list.
     */
    public void add(E obj) {
        Node<E> newLink = new Node<>(obj);
        newLink.next = this.first;
        this.first.previous = newLink;
        this.first = newLink;
        this.size++;
        this.modeCount++;
    }

    /**
     * Returns an element from the array according its index.
     * @param index - an index of an element
     * @return object with E type
     */
    public E get(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * Contains information.
     */
    private static class Node<E> {

        /**
         * The input data.
         */
        E date;

        /**
         * The next element.
         */
        Node<E> next;

        /**
         * The previous element.
         */
        Node<E> previous;

        /**
         * The default constructor.
         */
        Node() {
        }

        /**
         * The constructor.
         */
        Node(E date) {
            this.date = date;
        }
    }

    /**
     * Iterator to operate over the array.
     * @return an iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int i;

            private int expectedModeCount = modeCount;

            @Override
            public boolean hasNext() {
                if (expectedModeCount != modeCount) {
                    throw new ConcurrentModificationException();
                }
                return this.i < size;
            }

            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(this.i++);
            }
        };
    }
}