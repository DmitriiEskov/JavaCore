package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for Tracker class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 08.12.2018
 * @version 1.0
 */
public class TrackerTest {

    /**
     * Creating and adding an item to the tracker.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * Changes the item.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Deletes an item.
     */
    @Test
    public void whenDeleteOneItemInMiddle() {
        Tracker tracker = new Tracker();
        Item first = new Item();
        tracker.add(first);
        Item second = new Item();
        tracker.add(second);
        Item third = new Item();
        tracker.add(third);
        tracker.delete(first.getId());
        Item[] result = tracker.findAll();
        Item[] expect = new Item[2];
        expect[0] = second;
        expect[1] = third;
        assertThat(result, is(expect));
    }

    /**
     * Finds an item by id.
     */
    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item first = new Item();
        tracker.add(first);
        Item second = new Item();
        tracker.add(second);
        Item third = new Item();
        tracker.add(third);
        Item result = tracker.findById(third.getId());
        assertThat(result, is(third));
    }

    /**
     * Finds an item by id.
     */
    @Test
    public void whenFindByIdAndResultIsNull() {
        Tracker tracker = new Tracker();
        Item first = new Item();
        tracker.add(first);
        Item second = new Item();
        tracker.add(second);
        Item third = new Item();
        tracker.add(third);
        Item result = tracker.findById("123653L");
        Item expect = null;
        assertThat(result, is(expect));
    }

    /**
     * Gets all elements of the items array without null elements inside.
     */
    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item();
        tracker.add(first);
        Item second = new Item();
        tracker.add(second);
        Item third = new Item();
        tracker.add(third);
        tracker.delete(third.getId());
        Item[] expect = new Item[2];
        expect[0] = first;
        expect[1] = second;
        Item[] result = tracker.findAll();
        assertThat(result, is(expect));
    }

    /**
     * Finds all items with the same name inside the items array.
     */
    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item first = new Item();
        tracker.add(first);
        first.name = "First";
        Item second = new Item();
        tracker.add(second);
        second.name = "Second";
        Item third = new Item();
        tracker.add(third);
        third.name = "Second";
        Item fourth = new Item();
        tracker.add(fourth);
        fourth.name = "Fourth";
        Item[] result = tracker.findByName("Second");
        Item[] expect = new Item[2];
        expect[0] = second;
        expect[1] = third;
        assertThat(result, is(expect));
    }

    /**
     * Gets all items from the items array.
     */
    @Test
    public void whenGetAllItems() {
        Tracker tracker = new Tracker();
        Item first = new Item();
        tracker.add(first);
        Item second = new Item();
        tracker.add(second);
        Item third = new Item();
        tracker.add(third);
        Item[] result = tracker.getAll();
        Item[] expect = new Item[3];
        expect[0] = first;
        expect[1] = second;
        expect[2] = third;
        assertThat(result, is(expect));
    }
}