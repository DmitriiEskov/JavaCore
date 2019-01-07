package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * Class for handling exceptions in the Tracker.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 07.01.2019
 */
public class ValidateInput implements Input {

    /**
     * Any implementation of the Input interface.
     */
    private final Input input;

    /**
     * The constructor.
     */
    public ValidateInput(final Input input) {
        this.input = input;
    }

    /**
     * Questions a user and gets their answer.
     * @param question - a question
     * @return - a user's answer
     */
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    /**
     * Questions a user and gets their answer.
     * @param question - a question
     * @return - a user's answer (number)
     */
    @Override
    public int ask(String question, ArrayList<Integer> range) {
        boolean condition = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                condition = false;
            } catch (NumberFormatException e) {
                System.out.println("Please, provide a number.");
            } catch (MenuOutException e) {
                System.out.println("Please, provide a correct menu number.");
            }
        } while (condition);
        return value;
    }
}