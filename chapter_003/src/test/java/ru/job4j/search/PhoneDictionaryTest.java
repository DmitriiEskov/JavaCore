package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing the "PhoneDictionary" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 20.01.2019
 * @version 1.0
 */
public class PhoneDictionaryTest {

    /**
     * Tests it needs to find a person by their name.
     */
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }
}