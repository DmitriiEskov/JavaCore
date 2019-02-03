package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Class for counting functions in order to use lambda and FI.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 30.01.2019
 * @version 1.0
 */
public class FunctionMethod {

    /**
     * Method for implementing a functions (linear, quadratic etc.)
     * @param start - a start number
     * @param end - an end number
     * @param func - a function
     * @return result - List<Double>
     */
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int index = start; index != end; index++) {
            result.add(func.apply((double) index));
        }
        return result;
    }
}