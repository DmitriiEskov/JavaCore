package streamapi.listofaddresses;

/**
 * Class for creating a profile of a person.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 06.02.2019
 * @version 1.0
 */
public class Profile {

    /**
     * A person's address.
     */
    private Address address;

    /**
     * The constructor.
     * @param address - a person's address
     */
    public Profile(Address address) {
        this.address = address;
    }

    /**
     * Returns a client's address.
     * @return address
     */
    public Address getAddress() {
        return this.address;
    }
}