package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * Test for the TrackerSingle class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 09.01.2019
 * @version 1.0
 */
public class TrackerSingleTest {

    /**
     * Tests if only one Tracker class is being created.
     */
    @Test
    public void whenEnumIsTested() {
        TrackerSingle first = TrackerSingle.INSTANCE;
        TrackerSingle second = TrackerSingle.INSTANCE;
        assertThat(first, is(second));
    }

    /**
     * Tests if only one Tracker class is being created.
     */
    @Test
    public void whenStaticFieldIsTested() {
        TrackerSingleSecond first = TrackerSingleSecond.getInstance();
        TrackerSingleSecond second = TrackerSingleSecond.getInstance();
        assertThat(first, is(second));
    }

    /**
     * Tests if only one Tracker class is being created.
     */
    @Test
    public void whenStaticFinalFieldIsTested() {
        TrackerSingleThird first = TrackerSingleThird.getInstance();
        TrackerSingleThird second = TrackerSingleThird.getInstance();
        assertThat(first, is(second));
    }

    /**
     * Tests if only one Tracker class is being created.
     */
    @Test
    public void whenPrivateStaticFinalClassIsTested() {
        TrackerSingleFourth first = TrackerSingleFourth.getInstance();
        TrackerSingleFourth second = TrackerSingleFourth.getInstance();
        assertThat(first, is(second));
    }
}