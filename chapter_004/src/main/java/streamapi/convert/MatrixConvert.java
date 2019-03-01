package streamapi.convert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for converting from a List<List<T>> to a List<T>.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 07.02.2019
 * @version 1.0
 */
public class MatrixConvert {

    /**
     * Converts from a List<List<Integer>> to a List<Integer>
     * @param list List<List<Integer>>
     * @return List<Integer>
     */
    public List<Integer> convertMatrixToList(List<List<Integer>> list) {
        List<Integer> result = list.stream().flatMap(List :: stream).collect(Collectors.toList());
        return result;
    }
}