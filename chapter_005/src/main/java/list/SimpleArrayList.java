package list;

/**
 * Class for creating a one way linked list.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 26.02.2019
 */
public class SimpleArrayList<E> {

    /**
     * Size of the one-way linked list.
     */
    private int size;

    /**
     * First element of the list.
     */
    private Node<E> first;

    /**
     * Adds element to the beginning of the list.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Deletes a first element in the list.
     * @return a deleted element
     */
    public E delete() {
        E result = this.first.date;
        this.first = this.first.next;
        this.size--;
        return result;
    }

    /**
     * Returns an element from the list according to the index.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * Returns a size of the collection.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Contains information.
     */
    private static class Node<E> {

        /**
         * The input data.
         */
        E date;

        /**
         * The next element.
         */
        Node<E> next;

        /**
         * The constructor.
         * @param date the input data
         */
        Node(E date) {
            this.date = date;
        }
    }
}