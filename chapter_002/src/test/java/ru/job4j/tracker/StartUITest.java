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
        Input input = new StubInput(new String[] {"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(
                        new StringBuilder()
                                .append("Menu\r\n")
                                .append("0. Add new Item.\r\n")
                                .append("1. Show all items.\r\n")
                                .append("2. Edit item.\r\n")
                                .append("3. Delete item.\r\n")
                                .append("4. Find item by an id.\r\n")
                                .append("5. Find items by a name.\r\n")
                                .append("6. Exit Programme.\r\n")
                                .append("------------ Showing all created items --------------\r\n\r\n")
                                .append("id: " + first.getId() + "\r\n")
                                .append("Name: " + first.getName() + "\r\n")
                                .append("Created: " + first.getCreate() + "\r\n")
                                .append("Description: " + first.getDescription() + "\r\n" + "\r\n")
                                .append("Menu" + "\r\n")
                                .append("0. Add new Item." + "\r\n")
                                .append("1. Show all items." + "\r\n")
                                .append("2. Edit item." + "\r\n")
                                .append("3. Delete item." + "\r\n")
                                .append("4. Find item by an id." + "\r\n")
                                .append("5. Find items by a name." + "\r\n")
                                .append("6. Exit Programme." + "\r\n")
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
        Input input = new StubInput(new String[] {"5", first.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(
                        new StringBuilder()
                                .append("Menu\r\n")
                                .append("0. Add new Item.\r\n")
                                .append("1. Show all items.\r\n")
                                .append("2. Edit item.\r\n")
                                .append("3. Delete item.\r\n")
                                .append("4. Find item by an id.\r\n")
                                .append("5. Find items by a name.\r\n")
                                .append("6. Exit Programme.\r\n")
                                .append("------------ Success! --------------\r\n")
                                .append("id: " + first.getId() + "\r\n")
                                .append("Name: " + first.getName() + "\r\n")
                                .append("Description: " + first.getDescription() + "\r\n")
                                .append("Create: " + first.getCreate() + "\r\n" + "\r\n")
                                .append("Menu" + "\r\n")
                                .append("0. Add new Item." + "\r\n")
                                .append("1. Show all items." + "\r\n")
                                .append("2. Edit item." + "\r\n")
                                .append("3. Delete item." + "\r\n")
                                .append("4. Find item by an id." + "\r\n")
                                .append("5. Find items by a name." + "\r\n")
                                .append("6. Exit Programme." + "\r\n")
                                .toString()
                )
        );
    }
}