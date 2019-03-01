package ru.job4j.search;

/**
 * Class for creating a task.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 21.01.2019
 * @version 1.0
 */
public class Task {

    /**
     * Task's description.
     */
    private String desc;

    /**
     * Task's priority.
     */
    private int priority;

    /**
     * The constructor.
     * @param desc - a description
     * @param priority - a priority
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    /**
     * Returns a description.
     * @return a description
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Returns a priority.
     * @return a priority
     */
    public int getPriority() {
        return priority;
    }
}