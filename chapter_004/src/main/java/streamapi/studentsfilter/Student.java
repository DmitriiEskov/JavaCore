package streamapi.studentsfilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class for students.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 05.02.2019
 * @version 1.0
 */
public class Student implements Comparable<Student> {

    /**
     * Student's score.
     */
    private int score;

    /**
     * Student's surname.
     */
    private String surname;

    /**
     * The constructor.
     * @param score a student's score
     */
    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    /**
     * The constructor.
     * @param score a student's score
     */
    public Student(int score) {
        this.score = score;
    }

    /**
     * Returns student's score.
     * @return a score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Returns a student's surname.
     * @return a surname
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Provides numeric order of sorting students' scores in a List<Student>.
     * @param students - a list of students
     * @param bound - a minimum score value for a student to have to be included into a result List
     * @return a result List<Student>
     */
    List<Student> levelOf(List<Student> students, int bound) {
        Collections.sort(students);
        return students.stream().flatMap(
                Stream :: ofNullable
        ).takeWhile(
                        s -> s.getScore() > bound
        ).collect(Collectors.toList());
    }

    /**
     * Overriding equals to compare a surname field of a Student to another one.
     * @param o - address to compare with
     * @return true/false
     */
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o) {
            return true;
        }
        if (o instanceof Student) {
            Student student = (Student) o;
            if (this.getSurname().equals(student.getSurname())) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Overriding the hashcode method using a surname field.
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return this.surname.hashCode();
    }

    /**
     * Sorts students in numeric order according their scores.
     * @param o - a student
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to,
     * or greater than the specified object.
     */
    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.score, o.getScore());
    }
}