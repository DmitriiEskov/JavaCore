package set;

import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * Class for testing the "SetBasedOnArray" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 04.03.2019
 */
public class SetBasedOnArrayTest {

    /**
     * When adding elements to set, then success.
     */
    @Test
    public void whenAddElementsToSetThenSuccess() {
        SetBasedOnArray<Integer> set = new SetBasedOnArray<>();
        set.add(1);
        set.add(2);
        set.add(3);
    }

    /**
     * When adding duplicates, then no result.
     */
    @Test
    public void whenAddDuplicatesThenFail() {
        SetBasedOnArray<Integer> set = new SetBasedOnArray<>();
        set.add(1);
        set.add(1);
        set.add(1);
        Iterator<Integer> iter = set.iterator();
        assertThat(iter.next(), is(1));
        assertThat(iter.hasNext(), is(false));
    }
}