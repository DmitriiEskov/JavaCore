package ru.job4j.sortdepartments;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing the GuideSort class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 05.02.2019
 * @version 1.0
 */
public class GuideTest {

    /**
     * Tests when it needs to sort a guide from low to high.
     */
    @Test
    public void whenSortGuideLowToHighThenSorted() {
        List<String> listToSort = Arrays.asList("K2\\SK1\\SSK2", "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2", "K2\\SK1", "K1", "K2", "K2\\SK1\\SSK1");
        List<String> expect = (Arrays.asList("K1", "K1\\SK1", "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"));
        List<String> result = new GuideSort().sortByNameLowToHigh(listToSort);
        assertThat(result, is(expect));
    }

    /**
     * Tests when it needs to sort a guide from high to low.
     */
    @Test
    public void whenSortGuideHighToLowThenSorted() {
        List<String> listToSort = Arrays.asList("K1", "K2", "K2\\SK1\\SSK2", "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2", "K2\\SK1", "K2\\SK1\\SSK1");
        List<String> expect = (Arrays.asList("K2", "K2\\SK1", "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1", "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"));
        List<String> result = new GuideSort().sortByNameHighToLow(listToSort);
        assertThat(result, is(expect));
    }
}