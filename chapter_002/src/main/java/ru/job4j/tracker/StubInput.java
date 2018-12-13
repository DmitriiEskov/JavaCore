package ru.job4j.tracker;

/**
 * Class for testing the "StartUI" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 13.12.2018
 */
public class StubInput implements Input {

    /**
     * It contains user's sequence of answers.
     */
    private final String[] answers;

    /**
     * It counts an amount of using the "ask" method.
     */
    private int position = 0;

    /**
     * The constructor.
     * @param answers - user's answers
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Asks a question.
     * @param question - user's question
     * @return the array with answers.
     */
    @Override
    public String ask(String question) {
        return answers[position++];
    }
}