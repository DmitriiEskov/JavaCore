package streamapi.convert;

import java.util.*;

/**
 * Class for operating an Integer array and returning a result based on the operation.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 18.02.2019
 */
public class ArraySort {

    /**
     * Operates the given array on the following order: 1) Removes all odd numbers
     * 2) Squares each number 3) Summing all elements up.
     * @param array - an array to be operated
     * @return a result
     */
    public Integer sort(Integer[] array) {
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        return list.stream().filter(
                e -> e % 2 == 0
        ).map(
                e -> e * e
        ).reduce(
                        (sum, element) -> sum + element
        ).orElse(0);
    }
}