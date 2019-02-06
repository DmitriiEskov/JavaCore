package streamapi.listofaddresses;

/**
 * Class for creating an address for a person.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 06.02.2019
 * @version 1.0
 */
public class Address {

    /**
     * Person's city.
     */
    private String city;

    /**
     * Person's street.
     */
    private String street;

    /**
     * Person's home.
     */
    private int home;

    /**
     * Person's apartment.
     */
    private int apartment;

    /**
     * The constructor.
     * @param city person's city
     * @param street person's street
     * @param home person's home
     * @param apartment person's apartment
     */
    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }
}