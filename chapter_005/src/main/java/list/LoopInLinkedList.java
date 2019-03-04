package list;

/**
 * Class for the implementation of the algorithm for searching a loop in a linked list.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 04.03.2019
 */
public class LoopInLinkedList {

    /**
     * Checks if a linked list has a loop or not.
     * @param first - a linked list to be checked
     * @return true - if there's a loop, false - otherwise
     */
    public boolean hasCycle(final Node first) {
        boolean result = false;
        Node slow = first;
        Node fast = first;
        if (first != null) {
            while (true) {
                if (fast.next != null && fast.next.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                } else {
                    break;
                }
                if (slow == fast) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Class for Node objects.
     * @param <T>
     */
    static class Node<T> {
        T value;
        Node<T> next;
    }
}