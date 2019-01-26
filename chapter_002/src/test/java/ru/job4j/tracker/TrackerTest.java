package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

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
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    /**
     * Changes the item successfully.
     */
    @Test
    public void whenReplaceNameIsSuccessfulThenTrue() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2");
        next.setId(previous.getId());
        assertThat(tracker.replace(previous.getId(), next), is(true));
    }

    /**
     * Changes the item unsuccessfully.
     */
    @Test
    public void whenReplaceNameIsUnsuccessfulThenFalse() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2");
        assertThat(tracker.replace(next.getId(), next), is(false));
    }

    /**
     * Deletes an item successfully.
     */
    @Test
    public void whenDeleteItemIsSuccessful() {
        Tracker tracker = new Tracker();
        Item first = new Item();
        tracker.add(first);
        Item second = new Item();
        tracker.add(second);
        Item third = new Item();
        tracker.add(third);
        assertThat(tracker.delete(first.getId()), is(true));
    }

    /**
     * Deletes an item unsuccessfully.
     */
    @Test
    public void whenDeleteItemIsUnsuccessful() {
        Tracker tracker = new Tracker();
        Item first = new Item();
        tracker.add(first);
        Item second = new Item();
        tracker.add(second);
        Item third = new Item();
        assertThat(tracker.delete(third.getId()), is(false));
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
        ArrayList<Item> expect = new ArrayList<Item>();
        expect.add(first);
        expect.add(second);
        ArrayList<Item> result = tracker.findAll();
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
        ArrayList<Item> result = tracker.findByName("Second");
        ArrayList<Item> expect = new ArrayList<>();
        expect.add(second);
        expect.add(third);
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
        ArrayList<Item> result = tracker.getAll();
        ArrayList<Item> expect = new ArrayList<Item>();
        expect.add(first);
        expect.add(second);
        expect.add(third);
        assertThat(result, is(expect));
    }
}