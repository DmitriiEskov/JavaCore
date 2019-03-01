package ru.job4j.list;

import java.util.*;

/**
 * Class for converting a List<User> into a Map<User>.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 26.01.2019
 * @version 1.0
 */
public class UserConvert {

    /**
     * Converts a List<User> list into a HashMap<User> list.
     * @param list a List
     * @return a HashMap
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<Integer, User>();
        for (User user : list) {
            map.put(user.getID(), user);
        }
        return map;
    }
}