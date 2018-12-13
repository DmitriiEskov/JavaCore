package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for StartUI class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 13.12.2018
 * @version 1.0
 */
public class StartUITest {

    /**
     * Tests when a user wants to add an item.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    /**
     * Tests when a user wants to update an item.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[] {"2", item.getId(), "test replace", "the item was changed", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    /**
     * Tests when a user wants to delete an item.
     */
    @Test
    public void whenDeleteThenTrackerHasDeletedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("The testing item", "We want it to be deleted."));
        Input input = new StubInput(new String[] {"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        Item result = null;
        assertThat(tracker.findById(item.getId()), is(result));
    }

    /**
     * Tests when a user wants to find an item by an id.
     */
    @Test
    public void whenFindItemByIDThenTrackerFindsIt() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("The testing item", "We want it to be found."));
        Input input = new StubInput(new String[] {"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(item));
    }

    /**
     * Tests when a user wants to find an item by a name.
     */
    @Test
    public void whenFindItemByNameThenTrackerFindsIt() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Testing name", "We want it to be found by name."));
        Input input = new StubInput(new String[] {"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        Item[] result = new Item[1];
        result[0] = item;
        assertThat(tracker.findByName(item.getName()), is(result));
    }
}