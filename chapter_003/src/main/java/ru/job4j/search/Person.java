package ru.job4j.search;

/**
 * Class for creating users.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 20.01.2019
 * @version 1.0
 */
public class Person {

    /**
     * a name of a person.
     */
    private String name;

    /**
     * a surname of a person.
     */
    private String surname;

    /**
     * a phone of a person.
     */
    private String phone;

    /**
     * address of a person.
     */
    private String address;

    /**
     * The constructor.
     * @param name a persons's name
     * @param surname a persons's surname
     * @param phone a persons's phone
     * @param address a a persons's address
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Returns a persons's name.
     * @return a name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a persons's surname.
     * @return a surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Returns a persons's phone.
     * @return a phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Returns a persons's address.
     * @return an address
     */
    public String getAddress() {
        return address;
    }
}