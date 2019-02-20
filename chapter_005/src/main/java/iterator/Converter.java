package iterator;

import java.util.*;

/**
 * Class for creating a converter from Iterator<Iterator<Integer>> to Iterator<Integer>.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 19.02.2019
 */
public class Converter {

    /**
     * Converts an Iterator<Iterator<Integer>> to an Iterator<Integer>.
     * @param it - an Iterator<Iterator<Integer>> to be converted
     * @return an Iterator<Integer>
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {
            Iterator<Integer> iter = (it.hasNext()) ? it.next() : null;

            @Override
            public boolean hasNext() {
                boolean result = true;
                while (!(this.iter != null && this.iter.hasNext())) {
                    if (!it.hasNext()) {
                        result = false;
                        break;
                    }
                    this.iter = it.next();
                }
                return result;
            }

            @Override
            public Integer next() {
                if (this.hasNext()) {
                    return this.iter.next();
                }
                throw new NoSuchElementException();
            }
        };
    }
}