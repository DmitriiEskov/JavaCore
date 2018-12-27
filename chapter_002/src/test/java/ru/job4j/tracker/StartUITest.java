package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
     * The default output to the console.
     */
    private final PrintStream stdout = System.out;

    /**
     * The buffer for a result.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * Tests when a user wants to add an item.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
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
        Input input = new StubInput(new String[] {"2", item.getId(), "test replace", "the item was changed", "y"});
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
        Input input = new StubInput(new String[] {"3", item.getId(), "y"});
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
        Input input = new StubInput(new String[] {"4", item.getId(), "y"});
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
        Input input = new StubInput(new String[] {"5", item.getName(), "y"});
        new StartUI(input, tracker).init();
        Item[] result = new Item[1];
        result[0] = item;
        assertThat(tracker.findByName(item.getName()), is(result));
    }

    /**
     * Reassigns the output stream.
     */
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Reassigns the output stream back.
     */
    @After
    public void backOutput() {
        System.setOut(new PrintStream(this.stdout));
    }

    /**
     * Tests when it needs all created items to be shown.
     */
    @Test
    public void whenGetAllItems() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("First", "Testing description."));
        Input input = new StubInput(new String[] {"1", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(
                        new StringBuilder()
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by id")
                                .append(System.lineSeparator())
                                .append("5. Find item by name")
                                .append(System.lineSeparator())
                                .append("------------ Showing all created items --------------")
                                .append(System.lineSeparator())
                                .append(first.getItemCharacteristics(tracker.getAll()))
                                .toString()
                )
        );
    }

    /**
     * Tests when it needs an item by name to be shown.
     */
    @Test
    public void whenGetItemByName() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("Second", "Testing description."));
        Input input = new StubInput(new String[] {"5", first.getName(), "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(
                        new StringBuilder()
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by id")
                                .append(System.lineSeparator())
                                .append("5. Find item by name")
                                .append(System.lineSeparator())
                                .append("------------ Success! --------------")
                                .append(first.getItemCharacteristics(tracker.getAll()))
                                .toString()
                )
        );
    }
}