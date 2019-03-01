package ru.job4j.array;

/**
 * Class for checking if a word starts in a proper sequence.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 18.11.2018
 */
public class ArrayChar {

    /**
     * An array for input to compare with another one.
     */
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Checking if a word starts with a proper prefix.
     * @param prefix - a prefix.
     * @return true/false
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (value[i] != data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}