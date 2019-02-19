package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class for creating an iterator for an array of even numbers.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 19.02.2019
 */
public class EvenIterator implements Iterator {

    /**
     * Contains information of the class.
     */
    private final int[] values;

    /**
     * Counts an elements of an array.
     */
    private int i = 0;

    /**
     * The constructor.
     * @param array - an array
     */
    public EvenIterator(int[] array) {
        this.values = array;
    }

    /**
     * Returns the next element of the array.
     * @return an element
     */
    @Override
    public Integer next() {
        if (this.hasNext()) {
            return this.values[this.i++];
        }
        throw new NoSuchElementException();
    }

    /**
     * Checks if the next element in the array exists or not.
     * @return true/false
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = this.i; i < this.values.length; i++) {
            if (this.values[i] % 2 == 0) {
                result = true;
                this.i = i;
                break;
            }
        }
        return result;
    }
}