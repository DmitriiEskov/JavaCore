package streamapi.listofaddresses;

import java.util.Comparator;

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

    /**
     * The default constructor.
     */
    public Address() {
    }

    /**
     * Returns a client's city.
     * @return a city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Returns a client's street.
     * @return a street
     */
    public String getStreet() {
        return this.street;
    }

    /**
     * Returns client's home.
     * @return a home
     */
    public int getHome() {
        return this.home;
    }

    /**
     * Returns a client's apartment.
     * @return an apartment
     */
    public int getApartment() {
        return this.apartment;
    }

    /**
     * Overriding equals to compare all fields of an Address to another one.
     * @param o - address to compare with
     * @return true/false
     */
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        Address address = null;
        if (o instanceof Address) {
            address = (Address) o;
            if (this.getCity().equals(address.getCity()) && this.getStreet().equals(address.getStreet())
                    && this.getHome() == address.getHome()
                    && this.getApartment() == address.getApartment()) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Overriding the hashcode.
     * @return
     */
    @Override
    public int hashCode() {
        return this.street.hashCode();
    }

    /**
     * A comparator for comparing two Address objects in their city fields.
     */
    public class CompareByCity implements Comparator<Address> {
        @Override
        public int compare(Address o1, Address o2) {
            return o1.city.compareTo(o2.city);
        }
    }
}