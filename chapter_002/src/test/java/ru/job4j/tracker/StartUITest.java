package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.function.Consumer;

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
     * Implementation of the Consumer for showing the tracker info at the console.
     */
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }

        @Override
        public String toString() {
            return out.toString();
        }
    };

    /**
     * Tests when a user wants to add an item.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, tracker, output).init();
        String expected = new StringBuilder()
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
                .append("------------ Adding new item --------------")
                .append(System.lineSeparator())
                .append("------------ New Item with id: " + tracker.getAll().get(0).getId())
                .append(System.lineSeparator())
                .append("------------ New Item with Name: " + tracker.getAll().get(0).getName())
                .append(System.lineSeparator())
                .append("------------ New Item with Description: " + tracker.getAll().get(0).getDescription())
                .append(System.lineSeparator())
                .toString();
        assertThat(this.output.toString(), is(expected));
    }

    /**
     * Tests when a user wants to update an item.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[] {"2", item.getId(), "test replace", "the item was changed", "y"});
        new StartUI(input, tracker, output).init();
        String expected = new StringBuilder()
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
                .append("------------ Editing an item --------------")
                .append(System.lineSeparator())
                .append("------------ Editing complete --------------")
                .append(System.lineSeparator())
                .toString();
        assertThat(this.output.toString(), is(expected));
    }

    /**
     * Tests when a user wants to delete an item.
     */
    @Test
    public void whenDeleteThenTrackerHasDeletedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("The testing item", "We want it to be deleted."));
        Input input = new StubInput(new String[] {"3", item.getId(), "y"});
        new StartUI(input, tracker, output).init();
        String expected = new StringBuilder()
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
                .append("------------ Deleting complete. ----------------")
                .append(System.lineSeparator())
                .toString();
        assertThat(this.output.toString(), is(expected));
    }

    /**
     * Tests when a user wants to find an item by an id.
     */
    @Test
    public void whenFindItemByIDThenTrackerFindsIt() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("The testing item", "We want it to be found."));
        Input input = new StubInput(new String[] {"4", item.getId(), "y"});
        new StartUI(input, tracker, output).init();
        String expected = new StringBuilder()
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
                .append(System.lineSeparator())
                .append("id: " + tracker.getAll().get(0).getId())
                .append(System.lineSeparator())
                .append("Name: " + tracker.getAll().get(0).getName())
                .append(System.lineSeparator())
                .append("Description: " + tracker.getAll().get(0).getDescription())
                .append(System.lineSeparator())
                .append("Create: " + tracker.getAll().get(0).getCreate())
                .append(System.lineSeparator())
                .toString();
        assertThat(this.output.toString(), is(expected));
    }

    /**
     * Tests when a user wants to find an item by a name.
     */
    @Test
    public void whenFindItemByNameThenTrackerFindsIt() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Testing name", "We want it to be found by name."));
        Input input = new StubInput(new String[] {"5", item.getName(), "y"});
        new StartUI(input, tracker, output).init();
        String expected = new StringBuilder()
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
                .append(System.lineSeparator())
                .append("id: " + tracker.getAll().get(0).getId())
                .append(System.lineSeparator())
                .append("Name: " + tracker.getAll().get(0).getName())
                .append(System.lineSeparator())
                .append("Description: " + tracker.getAll().get(0).getDescription())
                .append(System.lineSeparator())
                .append("Created: " + tracker.getAll().get(0).getCreate())
                .append(System.lineSeparator())
                .toString();
        assertThat(this.output.toString(), is(expected));
    }

    /**
     * Tests when it needs all created items to be shown.
     */
    @Test
    public void whenGetAllItems() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("First", "Testing description."));
        Input input = new StubInput(new String[] {"1", "y"});
        new StartUI(input, tracker, output).init();
        String expected = new StringBuilder()
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
                .append("id: " + tracker.getAll().get(0).getId())
                .append(System.lineSeparator())
                .append("Name: " + tracker.getAll().get(0).getName())
                .append(System.lineSeparator())
                .append("Description: " + tracker.getAll().get(0).getDescription())
                .append(System.lineSeparator())
                .append("Created: " + tracker.getAll().get(0).getCreate())
                .append(System.lineSeparator())
                .toString();
        assertThat(this.output.toString(), is(expected));
    }

    /**
     * Tests when it needs an item by name to be shown.
     */
    @Test
    public void whenGetItemByName() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("Second", "Testing description."));
        Input input = new StubInput(new String[] {"5", first.getName(), "y"});
        new StartUI(input, tracker, output).init();
        String expected = new StringBuilder()
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
                .append(System.lineSeparator())
                .append("id: " + tracker.getAll().get(0).getId())
                .append(System.lineSeparator())
                .append("Name: " + tracker.getAll().get(0).getName())
                .append(System.lineSeparator())
                .append("Description: " + tracker.getAll().get(0).getDescription())
                .append(System.lineSeparator())
                .append("Created: " + tracker.getAll().get(0).getCreate())
                .append(System.lineSeparator())
                .toString();
        assertThat(this.output.toString(), is(expected));
    }
}