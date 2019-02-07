package streamapi.convert;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing a convert from a List<List<T>> to a List<T>.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 07.02.2019
 * @version 1.0
 */
public class MatrixConvertTest {

    /**
     * When it needs to convert a List<List<T>> to a List<T>.
     */
    @Test
    public void whenConvertMatrixIntegersToListIntegersThenResult() {
        List<Integer> first = new ArrayList<>();
        first.add(1);
        first.add(14534);
        first.add(0);
        List<Integer> second = new ArrayList<>();
        second.add(32423);
        second.add(112);
        second.add(9834);
        List<Integer> third = new ArrayList<>();
        third.add(223);
        third.add(111);
        third.add(223);
        List<List<Integer>> test = new ArrayList<>();
        test.add(first);
        test.add(second);
        test.add(third);
        List<Integer> expect = new ArrayList<>();
        expect.add(first.get(0));
        expect.add(first.get(1));
        expect.add(first.get(2));
        expect.add(second.get(0));
        expect.add(second.get(1));
        expect.add(second.get(2));
        expect.add(third.get(0));
        expect.add(third.get(1));
        expect.add(third.get(2));
        List<Integer> result = new MatrixConvert().convertMatrixToList(test);
        assertThat(result, is(expect));
    }
}