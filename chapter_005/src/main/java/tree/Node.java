package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for a node.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 24.04.2019
 */
public class Node<T extends Comparable<T>> {

    /**
     * Descendants of the node.
     */
    private final List<Node<T>> children = new ArrayList<>();

    /**
     * Key of the node.
     */
    private final T value;

    /**
     * The constructor.
     * @param value - a key value
     */
    public Node(final T value) {
        this.value = value;
    }

    /**
     * Adds a new descendant to the node.
     * @param child - descendant
     */
    public void add(Node<T> child) {
        this.children.add(child);
    }

    /**
     * Retrieves descendants of the node.
     * @return descendants
     */
    public List<Node<T>> leaves() {
        return this.children;
    }

    /**
     * Checks if two nodes are equal to each other.
     * @param that - a node to be compared with
     * @return true - if equal, false - otherwise
     */
    public boolean eqValue(T that) {
        return this.value.compareTo(that) == 0;
    }

    /**
     * Retrieves a value of the node.
     * @return T value
     */
    public T getValue() {
        return this.value;
    }
}