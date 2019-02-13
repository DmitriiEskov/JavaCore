package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing the "ConvertMatrix2List" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 23.01.2019
 * @version 1.0
 */
public class ConvertMatrix2ListTest {

    /**
     * Tests when it needs to convert a 2 on 2 dimensional array into an ArrayList.
     */
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    /**
     * Tests when it needs to convert a 4 on 4 dimensional array into an ArrayList.
     */
    @Test
    public void when4on4ArrayThenList16() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2, 5, 0},
                {3, 4, 113, 31111},
                {900, 1, 3, 88888},
                {643, 21, 876, 221}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 5, 0, 3, 4, 113, 31111, 900, 1, 3, 88888, 643, 21, 876, 221
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    /**
     * Tests when List<int[]> list has 2 different arrays and
     * it is required it to be converted into a List<Integer> list.
     */
    @Test
    public void whenListHasTwoDiffArraysThenListHasOnlyInteger() {
        List<int[]> test = new ArrayList<int[]>();
        test.add(new int[] {1, 2});
        test.add(new int[] {3, 4, 5, 6});
        ConvertList2Array list = new ConvertList2Array();
        List<Integer> result = list.convert(test);
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expect));
    }

    /**
     * Tests when List<int[]> list has 3 different arrays and
     * it is required it to be converted into a List<Integer> list.
     */
    @Test
    public void whenListHasThreeDiffArraysThenListHasOnlyInteger() {
        List<int[]> test = new ArrayList<int[]>();
        test.add(new int[] {1});
        test.add(new int[] {7, 4});
        test.add(new int[] {34, 21});
        ConvertList2Array list = new ConvertList2Array();
        List<Integer> result = list.convert(test);
        List<Integer> expect = List.of(1, 7, 4, 34, 21);
        assertThat(result, is(expect));
    }
}