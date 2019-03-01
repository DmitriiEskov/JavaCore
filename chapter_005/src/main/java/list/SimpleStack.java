package list;

import java.util.NoSuchElementException;

/**
 * Class for creating a stack based on a linked list.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 27.02.2019
 */
public class SimpleStack<T> {

    /**
     * A container based on the linked list.
     */
    private DynamicContainerBasedOnLinkedList<T> stack = new DynamicContainerBasedOnLinkedList<>();

    /**
     * Counts elements in the stack.
     */
    private int i;

    /**
     * Adds an element to the stack.
     * @param push - an element
     */
    public void push(T push) {
        this.stack.add(push);
        this.i++;
    }

    /**
     * Deletes an element from the stack and returns it.
     * @return element
     */
    public T poll() {
        if (this.i <= 0) {
            throw new NoSuchElementException();
        }
        this.i--;
        return this.stack.delete();
    }
}