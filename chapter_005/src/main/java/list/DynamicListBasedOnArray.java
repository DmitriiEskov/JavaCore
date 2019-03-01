package list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class for creating a dynamic list that is based on an array.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 27.02.2019
 */
public class DynamicListBasedOnArray<E> implements Iterable<E> {

    /**
     * An array for storing the information of a class.
     */
    private Object[] container;

    /**
     * Current index of the array.
     */
    private int index;

    /**
     * The counter of any changes to the array.
     */
    private int modeCount;

    /**
     * The default constructor that sets a "10" size of the array.
     */
    public DynamicListBasedOnArray() {
        this.container = new Object[10];
    }

    /**
     * The constructor that sets a size of the array.
     * @param size - a size
     */
    public DynamicListBasedOnArray(int size) {
        this.container = new Object[size];
    }

    /**
     * Adds an element to the array.
     * @param obj - an element
     */
    public void add(E obj) {
        if (this.index >= this.container.length) {
            Object[] container = new Object[this.container.length + 10];
            System.arraycopy(this.container, 0, container, 0, this.index);
            this.container = container;
        }
        this.container[this.index++] = obj;
        this.modeCount++;
    }

    /**
     * Returns an element from the array according its index.
     * @param index - an index of an element
     * @return object with E type
     */
    public E get(int index) {
        if (index >= this.index) {
            throw new IndexOutOfBoundsException();
        }
        return (E) this.container[index];
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
                return this.i < index;
            }

            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[i++];
            }
        };
    }
}