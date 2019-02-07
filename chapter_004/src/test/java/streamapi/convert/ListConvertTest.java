package streamapi.convert;

import org.junit.Test;
import streamapi.studentsfilter.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing a convert from List<Student> into a Map<String, Student>.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 07.02.2019
 * @version 1.0
 */
public class ListConvertTest {

    /**
     * School for tests.
     */
    public List<Student> school;

    /**
     * Filling in this.school with students
     * @return a school
     */
    private List<Student> setSchool() {
        List<Student> school = new ArrayList<>();
        Student first = new Student(1, "Ivanov");
        Student second = new Student(24, "Ivanov");
        Student third = new Student(50, "Eskov");
        Student fourth = new Student(51, "Bastricin");
        Student fifth = new Student(2, "Medvedev");
        school.add(first);
        school.add(second);
        school.add(third);
        school.add(fourth);
        school.add(fifth);
        this.school = school;
        return school;
    }

    /**
     * Tests when it needs to convert from List<Student> into a Map<String, Student>.
     */
    @Test
    public void whenConvertListToMap() {
        List<Student> list = this.setSchool();
        Map<String, Student> result = new ListConvert().convertListToMap(list);
        Map<String, Student> expect = new HashMap<>();
        expect.putIfAbsent("Ivanov", this.school.get(0));
        expect.putIfAbsent("Eskov", this.school.get(2));
        expect.putIfAbsent("Bastricin", this.school.get(3));
        expect.putIfAbsent("Medvedev", this.school.get(4));
        assertThat(result, is(expect));
    }
}