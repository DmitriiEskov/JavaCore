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
        return new TreeSet<>(list);
    }

    /**
     * Sorts a List<User> by a name length and returns a sorted List<User>.
     * @param list - a list to sort
     * @return list - a sorted list
     */
    public List<User> sortNameLength(List<User> list) {
        class UserCompareByName implements Comparator<User> {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        }
        list.sort(new UserCompareByName());
        return list;
    }

    /**
     * Sorts a List<User> lexicographically by a name and by an age, then returns a sorted List<User>.
     * @param list - a list to be sorted
     * @return list - a sorted list
     */
    public List<User> sortByAllFields(List<User> list) {
        class UserCompareAge implements Comparator<User> {
            @Override
            public int compare(User o1, User o2) {
                int result = o1.getName().compareTo(o2.getName());
                if (result == 0) {
                    result = Integer.compare(o1.getAge(), o2.getAge());
                }
                return result;
            }
        }
        list.sort(new UserCompareAge());
        return list;
    }
}