package ru.job4j.search;

import java.util.*;

/**
 * Class for creating a dictionary of persons.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 20.01.2019
 * @version 1.0
 */
public class PhoneDictionary {

    /**
     * A list of persons.
     */
    private List<Person> persons = new ArrayList<Person>();

    /**
     * Adds a new person.
     * @param person - a person
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Returns a list of all persons containing a key in any field.
     * @param key a search key
     * @return a list of suitable persons based on the key
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
            for (Person value : this.persons) {
                if (value.getName().contains(key) || value.getAddress().contains(key)
                        || value.getPhone().contains(key) || value.getSurname().contains(key)) {
                    result.add(value);
                }
            }
        return result;
    }
}