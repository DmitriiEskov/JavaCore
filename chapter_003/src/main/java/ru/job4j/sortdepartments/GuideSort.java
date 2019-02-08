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
    private TreeSet<String> tree = new TreeSet<>();

    /**
     * Adds elements to this.tree.
     * @param element an element to be added
     */
    private void addElementToSet(String element) {
        String[] elements = element.split("\\\\");
        StringBuilder result = new StringBuilder();
        int i = 0;
        if (elements.length != 0) {
            result.append(elements[i++]);
            this.tree.add(result.toString());
            while (i != elements.length) {
                result.append("\\" + elements[i++]);
                this.tree.add(result.toString());
            }
        }
    }

    /**
     * Sorts a String array lexicographically from low to high.
     * @param array - an array to be sorted
     * @return a sorted array
     */
    public String[] sortByNameLowToHigh(String[] array) {
        for (String value : array) {
            this.addElementToSet(value);
        }
        String[] result = new String[this.tree.size()];
        Iterator iter = this.tree.iterator();
        for (int i = 0; iter.hasNext(); i++) {
            result[i] = (String) iter.next();
        }
        return result;
    }

    /**
     * Sorts a String array lexicographically from high to low.
     * @param array - an array to be sorted
     * @return a sorted array
     */
    public String[] sortByNameHighToLow(String[] array) {
        for (String value : array) {
            this.addElementToSet(value);
        }
        List<String> list = new ArrayList<>();
        Iterator setIterator = this.tree.iterator();
        while (setIterator.hasNext()) {
            list.add((String) setIterator.next());
        }

        /**
         * Class for creating a comparator for comparing two guides lexicographically from high to low.
         */
        class CompareDepartsHighToLow implements Comparator<String> {

            /**
             * Compares two String objects.
             * @param o1 - first sting to compare
             * @param o2 - second string to compare
             * @return Positive integer - if second greater that first, negative integer - if second less than first,
             * zero - if they are equal
             */
            @Override
            public int compare(String o1, String o2) {
                int result = o2.compareTo(o1);
                return (result == o2.length() - o1.length()) ? 1 : result;
            }
        }

        list.sort(new CompareDepartsHighToLow());
        Iterator listIterator = list.iterator();
        String[] result = new String[list.size()];
        for (int i = 0; listIterator.hasNext(); i++) {
            result[i] = (String) listIterator.next();
        }
        return result;
    }
}