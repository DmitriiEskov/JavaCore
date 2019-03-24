package map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class for implementing a HashMap, based on an array.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 23.03.2019
 */
public class HashMapImplementation<K, V> implements Iterable<V> {

    /**
     * Size of the HashMap.
     */
    private int size = 16;

    /**
     * Quantity of elements in HashMap.
     */
    private int elements = 0;

    /**
     * Counter for Iterators.
     */
    private int modeCount = 0;

    /**
     * Array on which the HashMap is based on.
     */
    private Node<K, V>[] table = new Node[size];

    /**
     * Inserts a specified value with a specified key in this.table;
     * @param key specified key
     * @param value value to be stored
     * @return true if success, false - if a cell is not emty
     */
    public boolean insert(K key, V value) {
        boolean result = true;
        if (this.modeCount == this.size) {
            this.extendArray();
        }
        int hash = this.hash(key);
        int index = this.size - 1 & this.hash(key);
        if (this.table[index] == null) {
            Node<K, V> node = new Node<>();
            node.hash = hash;
            node.key = key;
            node.value = value;
            this.table[index] = node;
            this.modeCount++;
            this.elements++;
        } else {
            if (this.table[index].key.equals(key)) {
                this.table[index].value = value;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * Returns a value associated with the specified key.
     * @param key the key
     * @return the value
     */
    public V get(K key) {
        int index = this.size - 1 & this.hash(key);
        return (this.table[index] != null && this.table[index].key.equals(key)) ? this.table[index].value : null;
    }

    /**
     * Deletes an object with the specified key in this.table.
     * @param key - object's key
     * @return true if success, false - otherwise
     */
    public boolean delete(K key) {
        boolean result = false;
        int index = this.size - 1 & this.hash(key);
        if (this.table[index] != null && this.table[index].key.equals(key)) {
            this.table[index] = null;
            result = true;
            this.modeCount++;
            this.elements--;
        }
        return result;
    }

    /**
     * Extends this.table when it is fully filled in with elements.
     */
    private void extendArray() {
        this.size = this.size * 2;
        Node<K, V>[] extended = new Node[this.size];
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i] != null) {
                int index = this.size - 1 & this.table[i].hash;
                extended[index] = this.table[i];
            }
        }
        this.table = extended;
    }

    /**
     * Generates a hashcode for an object.
     * @param key key of an object
     * @return generated hashcode
     */
    private int hash(K key) {
        int h = key.hashCode();
        return h ^ h >>> 16;
    }

    /**
     * Object for creating a linked list to store elements of the HashMap.
     * @param <K> - key of an object
     * @param <V> - value to be stored
     */
    private static class Node<K, V> {
        K key;

        V value;

        Node<K, V> next;

        int hash;
    }

    /**
     * Iterator to operate over the collection.
     * @return an iterator
     */
    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int i = 0;

            int expectedModeCount = modeCount;

            @Override
            public boolean hasNext() {
                if (expectedModeCount != modeCount) {
                    throw new ConcurrentModificationException();
                }
                return this.i < elements;
            }

            @Override
            public V next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                for (int index = this.i; index < elements; index++) {
                    if (table[index] != null) {
                        this.i = index;
                        break;
                    }
                }
                return table[this.i++].value;
            }
        };
    }
}