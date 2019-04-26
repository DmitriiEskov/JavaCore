package tree;

import java.util.*;

/**
 * Class for an implementation of the SimpleTree interface.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 24.04.2019
 */
public class Tree<T extends Comparable<T>> implements SimpleTree<T> {

    /**
     * The root Node.
     */
    Node<T> root;

    /**
     * Counts an amount of nodes.
     */
    private int modeCount = 0;

    /**
     * Adds a child Node to the parent Node, which is this.root.
     * @param parent parent.
     * @param child child.
     * @return true - if success, false - otherwise
     */
    public boolean add(T parent, T child) {
        boolean result = false;
        Optional<Node<T>> par = this.findBy(parent);
        Optional<Node<T>> chi = this.findBy(child);
        if (!par.isEmpty() && chi.isEmpty()) {
            par.orElseThrow().add(new Node<>(child));
            this.modeCount++;
        } else if (this.root == null) {
            Node<T> first = new Node<>(parent);
            Node<T> second = new Node<>(child);
            this.root = first;
            this.root.add(second);
        }
        return result;
    }

    /**
     * Retrieves a specified Node containing the value.
     * @param value - the value to be found
     * @return Node<T>
     */
    @Override
    public Optional<Node<T>> findBy(T value) {
        Optional<Node<T>> rsl = Optional.empty();
        Queue<Node<T>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<T> el = data.poll();
            if (el == null) {
                break;
            }
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<T> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * Iterator to operate over the collection.
     * @return an iterator
     */
    public Iterator<Node<T>> iterator() {
        return new Iterator<>() {

            private int expectedModeCount = Tree.this.modeCount;
            private Node<T> node = Tree.this.root;
            private Queue<Node<T>> children = new LinkedList<>();

            @Override
            public boolean hasNext() {
                if (expectedModeCount != Tree.this.modeCount) {
                    throw new ConcurrentModificationException();
                }
                return !this.children.isEmpty() || this.node != null;
            }

            @Override
            public Node<T> next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<T> buffer = null;
                if (!this.children.isEmpty()) {
                    buffer = this.children.poll();
                    for (Node<T> element : buffer.leaves()) {
                        this.children.add(element);
                    }
                } else if (this.node != null) {
                    buffer = this.node;
                    for (Node<T> element : this.node.leaves()) {
                        this.children.add(element);
                    }
                    this.node = null;
                }
                return buffer;
            }
        };
    }

    /**
     * Checks if a Tree is binary or not.
     * @return true - if a Tree is binary, false - otherwise
     */
    public boolean isBinary() {
        boolean result = true;
        Iterator<Node<T>> iter = this.iterator();
        while (iter.hasNext()) {
            if (iter.next().leaves().size() > 2) {
                result = false;
                break;
            }
        }
        return result;
    }
}