package ru.job4j.sortdepartments;

import org.junit.Test;
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
        String[] listToSort = {
                "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"
        };
        String[] expect = {
                "K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        GuideSort test = new GuideSort();
        for (String value : listToSort) {
            test.add(value);
        }
        assertThat(test.getData(), is(expect));
    }

    /**
     * Tests when it needs to sort a guide from low to high.
     */
    @Test
    public void whenDescendingOrderThenSuccess() {
        String[] listToSort = {
                "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"
        };
        String[] expect = {"K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K1", "K1\\SK2", "K1\\SK1",
                "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"
        };
        GuideSort test = new GuideSort();
        for (String value : listToSort) {
            test.add(value);
        }
        assertThat(test.getDescendingData(), is(expect));
    }
}