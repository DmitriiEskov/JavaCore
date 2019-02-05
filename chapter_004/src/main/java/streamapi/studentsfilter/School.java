package streamapi.studentsfilter;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class for creating a school.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 05.02.2019
 * @version 1.0
 */
public class School {

    /**
     * Divides a school class into some smaller classes depending on students' grades.
     * @param students a class of students
     * @param predict condition of how to divide
     * @return a result List that contains a divided class into some small classes
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> result = students.stream().filter(predict).collect(Collectors.toList());
        return result;
    }
}