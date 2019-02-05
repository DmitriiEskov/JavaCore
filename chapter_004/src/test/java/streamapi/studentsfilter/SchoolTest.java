package streamapi.studentsfilter;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing the "School" task.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 05.02.2019
 * @version 1.0
 */
public class SchoolTest {

    /**
     * School for tests.
     */
    private List<Student> school;

    /**
     * Filling this.school in with students
     * @return a school
     */
    private List<Student> setSchool() {
        List<Student> school = new ArrayList<>();
        Student first = new Student(1);
        Student second = new Student(24);
        Student third = new Student(50);
        Student fourth = new Student(51);
        Student fifth = new Student(69);
        Student sixth = new Student(70);
        Student seventh = new Student(71);
        Student eighth = new Student(90);
        Student tenth = new Student(100);
        school.add(first);
        school.add(second);
        school.add(third);
        school.add(fourth);
        school.add(fifth);
        school.add(sixth);
        school.add(seventh);
        school.add(eighth);
        school.add(tenth);
        this.school = school;
        return school;
    }

    /**
     * Tests when it needs to create a C class with score (0 : 50).
     */
    @Test
    public void whenDivideBy0To50() {
        List<Student> school = this.setSchool();
        List<Student> result = new School().collect(school, student -> student.getScore() < 50 && student.getScore() >= 0);
        List<Student> expect = new ArrayList<>();
        expect.add(this.school.get(0));
        expect.add(this.school.get(1));
        assertThat(result, is(expect));
    }

    /**
     * Tests when it needs to create a B class with score [50 : 70).
     */
    @Test
    public void whenDivideBy50To70() {
        List<Student> school = this.setSchool();
        List<Student> result = new School().collect(school, student -> student.getScore() >= 50 && student.getScore() < 70);
        List<Student> expect = new ArrayList<>();
        expect.add(this.school.get(2));
        expect.add(this.school.get(3));
        expect.add(this.school.get(4));
        assertThat(result, is(expect));
    }

    /**
     * Tests when it needs to create an A class with score [70 : 100].
     */
    @Test
    public void whenDivideBy70To100() {
        List<Student> school = this.setSchool();
        List<Student> result = new School().collect(school, student -> student.getScore() >= 70 && student.getScore() <= 100);
        List<Student> expect = new ArrayList<>();
        expect.add(this.school.get(5));
        expect.add(this.school.get(6));
        expect.add(this.school.get(7));
        expect.add(this.school.get(8));
        assertThat(result, is(expect));
    }
}