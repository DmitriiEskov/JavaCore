package streamapi.listofaddresses;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Class for creating a list of clients' addresses.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 06.02.2019
 * @version 1.0
 */
public class Profiles {

    /**
     * Returns a list of clients' addresses.
     * @param profiles - a list of clients' profiles
     * @return a list of clients' addresses
     */
    List<Address> collect(List<Profile> profiles) {
        List<Address> result = profiles.stream().map(Profile :: getAddress).collect(Collectors.toList());
        return result;
    }

    /**
     * Returns a unique and sorted list of clients' addresses.
     * @param profiles - a list of clients' profiles
     * @return a list of clients' addresses
     */
    List<Address> collectUniqueSortedAddress(List<Profile> profiles) {
        List<Address> result = this.collect(profiles).stream().distinct().sorted(
                new Address().new CompareByCity()).collect(Collectors.toList()
        );
        return result;
    }
}