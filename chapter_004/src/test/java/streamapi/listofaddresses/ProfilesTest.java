package streamapi.listofaddresses;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for getting clients' addresses from profiles.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 06.02.2019
 * @version 1.0
 */
public class ProfilesTest {

    /**
     * Tests when it needs to get a list of addresses from a profile.
     */
    @Test
    public void whenGetAddressesThenResult() {
        List<Profile> profiles = new ArrayList<>();
        Address moscow = new Address("Moscow", "Len. st.", 11, 50);
        Address voronezh = new Address("Voronezh", "Suvorov st.", 112, 10);
        Address peter = new Address("Petersburg", "Kutuzov st.", 12, 440);
        Profile first = new Profile(moscow);
        Profile second = new Profile(voronezh);
        Profile third = new Profile(peter);
        profiles.add(first);
        profiles.add(second);
        profiles.add(third);
        List<Address> expect = new ArrayList<>();
        expect.add(moscow);
        expect.add(voronezh);
        expect.add(peter);
        List<Address> result = new Profiles().collect(profiles);
        assertThat(result, is(expect));
    }
}