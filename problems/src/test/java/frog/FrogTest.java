package frog;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * This class is for testing the Frog class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 17.07.2019
 */
public class FrogTest {

    private HashSet<String> firstTest = new HashSet<>();
    private HashSet<String> secondTest = new HashSet<>();

    public FrogTest() {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(getClass().getClassLoader().getResource("firstTest.txt").getFile()));
             BufferedReader reader2 = new BufferedReader(new FileReader(getClass().getClassLoader().getResource("secondTest.txt").getFile()))) {
            while (reader1.ready()) {
                this.firstTest.add(reader1.readLine());
            }
            while (reader2.ready()) {
                this.secondTest.add(reader2.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenMoveAndMeetTreesThenSuccess() {
        int[] start = {7, 11};
        int[] finish = {10, 9};
        int[] tree = {9, 14};
        int[] tree2 = {8, 5};
        HashSet<String> result = new Frog().move(start, finish, 2, tree, tree2);
        assertThat(result, is(this.firstTest));
    }

    @Test
    public void whenMoveWithoutTreesThenSuccess() {
        int[] start = {7, 11};
        int[] finish = {3, 3};
        HashSet<String> result = new Frog().move(start, finish, 0, new int[0], new int[0]);
        assertThat(result, is(this.secondTest));
    }

    @Test
    public void whenImpossibleToFindWay() {
        int[] start = {7, 11};
        int[] finish = {10, 9};
        int[] tree1 = {10, 8};
        int[] tree2 = {9, 8};
        int[] tree3 = {9, 9};
        int[] tree4 = {9, 10};
        int[] tree5 = {10, 10};
        HashSet<String> result = new Frog().move(start, finish, 5, tree1, tree2, tree3, tree4, tree5);
        assertThat(true, is(result.isEmpty()));
    }
}