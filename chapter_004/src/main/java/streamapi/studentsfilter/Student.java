package streamapi.studentsfilter;

/**
 * Class for students.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 05.02.2019
 * @version 1.0
 */
public class Student {

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
}