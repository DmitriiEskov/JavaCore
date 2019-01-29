package ru.job4j.list;

/**
 * Class for creating users.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 26.01.2019
 * @version 1.0
 */
public class User implements Comparable<User> {

    /**
     * User's id.
     */
    private Integer id;

    /**
     * User's name.
     */
    private String name;

    /**
     * User's age
     */
    private Integer age;

    /**
     * User's city.
     */
    private String city;

    /**
     * The constructor.
     * @param id - user's id
     * @param name - user's name
     * @param city - user's city
     */
    public User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * The constructor.
     * @param name - user's name
     * @param age - user's age
     */
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Returns user's id.
     * @return an id
     */
    public Integer getID() {
        return this.id;
    }

    /**
     * Returns user's name.
     * @return a name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns user's city.
     * @return a city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * User's age.
     * @return an age
     */
    public Integer getAge() {
        return this.age;
    }

    /**
     * Compares this.age with User's age
     * @param o user's age
     * @return 0 - if they equals, -1 if this.age < o.age, 1 if this.age > o.age
     */
    public int compareTo(User o) {
        return Integer.compare(this.getAge(), o.getAge());
    }
}