package ru.job4j.sortdepartments;

import java.util.*;

/**
 * Class for sorting the names of the departments.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 05.02.2019
 * @version 1.0
 */
public class GuideSort {

    /**
     * Contains sorted lexicographically from low to high information of a guide.
     */
    private TreeSet<String> data = new TreeSet<>();

    /**
     * Contains descending sorted lexicographically information of a guide.
     */
    private TreeSet<String> descendingData = new TreeSet<>((x, y) -> {
        int minLen = Math.min(x.length(), y.length());
        int result = -x.substring(0, minLen).compareTo(y.substring(0, minLen));
        return result != 0 ? result : Integer.compare(x.length(), y.length());
    });

    /**
     * Adds elements to a guide (this.data & this.descendingData).
     * @param element an element to be added
     */
    public void add(String element) {
        String[] array = element.split("\\\\");
        StringBuilder buffer = new StringBuilder();
        for (String value : array) {
            buffer.append(value);
            this.data.add(buffer.toString());
            this.descendingData.add(buffer.toString());
            buffer.append("\\");
        }
    }

    /**
     * Returns an array (sorted lexicographically information of a guide).
     * @return a sorted array
     */
    public String[] getData() {
        return this.data.toArray(new String[this.data.size()]);
    }

    /**
     * Returns an array (sorted descending lexicographically).
     * @return a sorted array
     */
    public String[] getDescendingData() {
        return this.descendingData.toArray(new String[this.descendingData.size()]);
    }
}