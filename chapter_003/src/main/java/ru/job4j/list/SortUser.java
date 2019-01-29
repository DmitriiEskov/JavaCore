package ru.job4j.list;

import java.util.*;

/**
 * Class for converting a List<User> into a Set<User>.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 29.01.2019
 * @version 1.0
 */
public class SortUser {

    /**
     * Sorts users by age(from little to high) and converts a List<User> into a Set<User>
     * @param list - a list to sort and convert
     * @return result - a sorted and converted Set
     */
    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<>();
        Collections.sort(list);
        result.addAll(list);
        return result;
    }
}