package ru.job4j.search;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Class for creating a queue with a priority.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 21.01.2019
 * @version 1.0
 */
public class PriorityQueue {

    /**
     * A list of the tasks.
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Fills an element in a proper List's index.
     * @param task a task
     */
    public void put(Task task) {
        ListIterator<Task> iter = tasks.listIterator();
        if (this.tasks.size() == 0) {
            iter.add(task);
        }
        while (iter.hasNext()) {
            if (task.getPriority() <= iter.next().getPriority()) {
                iter.previous();
                iter.add(task);
                break;
            }
        }
    }

    /**
     * Returns and deletes a task from the list.
     * @return a task
     */
    public Task take() {
        return this.tasks.poll();
    }
}