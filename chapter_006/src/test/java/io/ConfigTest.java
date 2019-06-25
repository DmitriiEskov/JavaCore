package io;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Tests fo the Config class.
 */
public class ConfigTest {

    @Test
    public void whenToReadFromFileThenSuccess() {
        Config config = new Config("texts/properties.txt");
        config.load();
        Map<String, String> result = config.getResultMap();
        Map<String, String> expect = new HashMap<>();
        expect.put("FirstKEy", "FIrstValue");
        expect.put("SecondKey", "SecondVAlue");
        expect.put("ThirdKey", "ThirdValue");
        expect.put("FourthKey", "FourthValue");
        expect.put("12234Key", "Fift353hValue");
        Set<String> keys1 = expect.keySet();
        Collection<String> values1 = expect.values();
        Set<String> keys2 = result.keySet();
        Collection<String> values2 = result.values();
        boolean res1 = keys1.containsAll(keys2);
        boolean res2 = values1.containsAll(values2);
        assertThat(res1, is(true));
        assertThat(res2, is(true));
    }

    @Test
    public void whenToReadFromEmptyFileThenFail() {
        Config config = new Config("texts/EmptyProperties.txt");
        config.load();
        Map<String, String> result = config.getResultMap();
        Map<String, String> expect = new HashMap<>();
        expect.put("FirstKEy", "FIrstValue");
        expect.put("SecondKey", "SecondVAlue");
        expect.put("ThirdKey", "ThirdValue");
        expect.put("FourthKey", "FourthValue");
        expect.put("12234Key", "Fift353hValue");
        boolean res = true;
        Set<String> keys = result.keySet();
        Iterator<String> iterKeys = keys.iterator();
        Collection<String> values = result.values();
        Iterator<String> iterValues = values.iterator();
        if (expect.size() == result.size()) {
            while (iterKeys.hasNext() && iterValues.hasNext()) {
                if (!expect.get(iterKeys.next()).equals(iterValues.next())) {
                    break;
                }
            }
        } else {
            res = false;
        }
        assertThat(res, is(false));
    }
}