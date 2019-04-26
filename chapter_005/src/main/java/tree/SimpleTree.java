package tree;

import java.util.Optional;

/**
 * Class for Tree interface.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 24.04.2019
 */
public interface SimpleTree<T extends Comparable<T>> extends Iterable<Node<T>> {

    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param parent parent.
     * @param child child.
     * @return
     */
    boolean add(T parent, T child);

    /**
     * Retrieves a specified Node containing the value.
     * @param value - the value to be found
     * @return Node<T>
     */
    Optional<Node<T>> findBy(T value);
}