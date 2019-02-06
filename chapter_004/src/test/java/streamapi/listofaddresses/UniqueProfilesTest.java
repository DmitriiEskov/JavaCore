package streamapi.listofaddresses;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for getting unique and sorted clients' addresses from profiles.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 06.02.2019
 * @version 1.0
 */
public class UniqueProfilesTest {

    /**
     * Tests when it needs to get unique and sorted clients' addresses.
     */
    @Test
    public void whenGetUniqueAndSortedAddressesThenSuccess() {
        List<Profile> profiles = new ArrayList<>();
        Address moscow = new Address("Moscow", "Len. st.", 11, 50);
        Address moscowTwo = new Address("Moscow", "Len. st.", 11, 50);
        Address peter = new Address("Petersburg", "Kutuzov st.", 12, 440);
        Address peterTwo = new Address("Petersburg", "Kutuzov st.", 12, 440);
        Address rostov = new Address("Rostov", "Suvorov st.", 1111, 223);
        Address rostovTwo = new Address("Rostov", "Suvorov st.", 1111, 223);
        Profile first = new Profile(moscow);
        Profile second = new Profile(moscowTwo);
        Profile third = new Profile(peter);
        Profile fourth = new Profile(peterTwo);
        Profile fifth = new Profile(rostov);
        Profile sixth = new Profile(rostovTwo);
        profiles.add(third);
        profiles.add(fourth);
        profiles.add(fifth);
        profiles.add(sixth);
        profiles.add(first);
        profiles.add(second);
        List<Address> expect = new ArrayList<>();
        expect.add(moscow);
        expect.add(peter);
        expect.add(rostov);
        List<Address> result = new Profiles().collectUniqueSortedAddress(profiles);
        assertThat(result, is(expect));
    }
}