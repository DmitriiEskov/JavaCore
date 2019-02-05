package ru.job4j.sortdepartments;

import java.util.Comparator;
import java.util.List;

/**
 * Class for sorting the names of the departments.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 05.02.2019
 * @version 1.0
 */
public class GuideSort {

    /**
     * Sorts a list of GuideSort names lexicographically from low to high.
     * @param input - a list
     * @return a sorted list
     */
    public List<String> sortByNameLowToHigh(List<String> input) {
        class CompareDepartsLowToHigh implements Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }
        input.sort(new CompareDepartsLowToHigh());
        return input;
    }

    /**
     * Sorts a list of GuideSort names lexicographically from high to low.
     * @param input - a list
     * @return a sorted list
     */
    public List<String> sortByNameHighToLow(List<String> input) {
        class CompareDepartsHighToLow implements Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                char[] v1 = o1.toCharArray();
                char[] v2 = o2.toCharArray();
                int len1 = v1.length;
                int len2 = v2.length;
                int lim = Math.min(len1, len2);

                int k = 0;
                while (k < lim) {
                    char c1 = v1[k];
                    char c2 = v2[k];
                    if (c1 != c2) {
                        return c2 - c1;
                    }
                    k++;
                }
                return (len1 < len2) ? -1 : 1;
            }
        }
        input.sort(new CompareDepartsHighToLow());
        return input;
    }
}