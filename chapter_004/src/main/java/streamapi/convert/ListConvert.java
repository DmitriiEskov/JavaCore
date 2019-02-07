package streamapi.convert;

import streamapi.studentsfilter.Student;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class for converting from a List to a Map.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 07.02.2019
 * @version 1.0
 */
public class ListConvert {

    /**
     * Converts a List<Student> into a Map<String, Student>.
     * @param list a list of students
     * @return a map
     */
    public Map<String, Student> convertListToMap(List<Student> list) {
        Map<String, Student> result = list.stream().distinct().collect(
                Collectors.toMap(Student :: getSurname, student -> student
                )
        );
        return result;
    }
}