package generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class for creating a wrapper class of an array.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 21.02.2019
 */
public class SimpleArray<T> implements Iterable<T> {

    /**
     * An array.
     */
    private Object[] array;

    /**
     * Array's index.
     */
    private int i = 0;

    /**
     * The constructor.
     */
    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * Returns an element of the array.
     * @param position - an index of an element
     * @return an element
     */
    public T get(int position) {
        if (position > this.array.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        return (T) this.array[position];
    }

    /**
     * Add a new element to the array.
     * @param element - an element to be added
     * @return true if success, exception is thrown - otherwise
     */
    public boolean add(T element) {
        if (this.i > this.array.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        this.array[this.i++] = element;
        return true;
    }

    /**
     * Replaces an old element with a new one.
     * @param index - index of an old element
     * @param model - a new element
     * @return true if success, exception is thrown - otherwise
     */
    public boolean set(int index, T model) {
        if (index > this.i) {
            throw new IndexOutOfBoundsException();
        }
        this.array[index] = model;
        return true;
    }

    /**
     * Removes an element in the array.
     * @param index - an element's index
     * @return true if success, exception is thrown - otherwise
     */
    public boolean remove(int index) {
        if (index > this.i) {
            throw new IndexOutOfBoundsException();
        }
        this.array[index] = null;
        for (int j = 0; j != this.array.length - index - 1; j++) {
            T buffer = (T) this.array[index + j + 1];
            this.array[index + j + 1] = this.array[index + j];
            this.array[index + j] = buffer;
        }
        return true;
    }

    /**
     * An iterator over the SimpleArray.
     * @return an iterator
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int position = 0;

            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[position++];
            }

            @Override
            public boolean hasNext() {
                return this.position <= i - 1 && array[this.position] != null;
            }
        };
    }
}