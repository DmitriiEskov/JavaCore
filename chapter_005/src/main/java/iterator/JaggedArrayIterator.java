package iterator;

import java.util.Iterator;

/**
 * Class for creating an iterator for a double array.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 19.02.2019
 */
public class JaggedArrayIterator implements Iterator {

    /**
     * Contains information of the class.
     */
    private final int[][] values;

    /**
     * Counts a row of an array.
     */
    private int i = 0;

    /**
     * Counts a column of an array.
     */
    private int j = 0;

    /**
     * The constructor.
     * @param array - a double array
     */
    public JaggedArrayIterator(int[][] array) {
        this.values = array;
    }

    /**
     * Returns the next element of the double array.
     * @return an element
     */
    @Override
    public Integer next() {
        int result = this.values[i][j++];
        if (this.j == this.values[i].length) {
            this.j = 0;
            this.i++;
        }
        return result;
    }

    /**
     * Checks if the next element in the array exists or not.
     * @return true/false
     */
    @Override
    public boolean hasNext() {
        return this.i < this.values.length;
    }
}