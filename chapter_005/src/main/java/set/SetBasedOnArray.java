package set;

import list.DynamicListBasedOnArray;
import java.util.Iterator;

/**
 * Class for creating a Set, based on an array.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 04.03.2019
 */
public class SetBasedOnArray<T> {

    /**
     * Array, which this Set is based on.
     */
    private DynamicListBasedOnArray<T> set = new DynamicListBasedOnArray<>();

    /**
     * Adds an elements to this.set in case the element does not have duplicates.
     * @param element - an element to be added
     */
    public void add(T element) {
        boolean result = true;
        Iterator<T> iter = this.set.iterator();
        while (iter.hasNext()) {
            if (iter.next().equals(element)) {
                result = false;
                break;
            }
        }
        if (result) {
            this.set.add(element);
        }
    }

    /**
     * Returns an iterator.
     * @return an iterator
     */
    public Iterator<T> iterator() {
        return this.set.iterator();
    }
}