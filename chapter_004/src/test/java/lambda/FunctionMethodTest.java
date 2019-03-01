package lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for making some tests for functions implementing lambda and FI.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 30.01.2019
 * @version 1.0
 */
public class FunctionMethodTest {

    /**
     * Tests a linear function.
     */
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionMethod functionMethod = new FunctionMethod();
        List<Double> result = functionMethod.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    /**
     * Tests a quadratic function.
     */
    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionMethod functionMethod = new FunctionMethod();
        List<Double> result = functionMethod.diapason(1, 3, x -> x * x - x - 2);
        List<Double> expected = Arrays.asList(-2D, 0D);
        assertThat(result, is(expected));
    }

    /**
     * Tests a logarithmic function.
     */
    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        FunctionMethod functionMethod = new FunctionMethod();
        List<Double> result = functionMethod.diapason(16, 18, x -> Math.log(x) / Math.log(2.0));
        List<Double> expected = Arrays.asList(4D, 4.08746284125034D);
        assertThat(result, is(expected));
    }
}