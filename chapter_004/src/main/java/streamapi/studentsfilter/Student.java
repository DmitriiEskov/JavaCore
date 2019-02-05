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
}