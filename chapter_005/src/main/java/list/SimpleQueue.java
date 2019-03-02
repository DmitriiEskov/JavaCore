package list;

/**
 * Class for creating a simple queue.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 01.03.2019
 */
public class SimpleQueue<T> {

    /**
     * Stack for storing all elements of a queue.
     */
    private DynamicContainerBasedOnLinkedList<T> rightStack = new DynamicContainerBasedOnLinkedList<>();

    /**
     * Stack for storing only first element of a queue.
     */
    private DynamicContainerBasedOnLinkedList<T> leftStack = new DynamicContainerBasedOnLinkedList<>();

    /**
     * Counter of elements in this.rightStack.
     */
    private int i = 0;

    /**
     * Counter of elements in this.leftStack.
     */
    private int j = 0;

    /**
     * Adds an element to this.rightStack
     *
     * @param value an element to be added
     */
    public void push(T value) {
        this.rightStack.add(value);
        this.i++;
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     *
     * @return the head of this queue
     */
    public T poll() {
        T result = null;
        if (this.j > 0 || this.i > 0) {
            if (this.j == 0) {
                while (this.i != 0) {
                    this.leftStack.add(this.rightStack.delete());
                    this.i--;
                    this.j++;
                }
            }
            result = this.leftStack.delete();
            this.j--;
        }
        return result;
    }
}