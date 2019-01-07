package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * Interface for the "Tracker" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 12.12.2018
 */
public interface Input {

    /**
     * Asks user a question and returns their answer.
     * @param question - a question
     * @return - user's answer
     */
    public String ask(String question);

    /**
     * Asks user a question and returns their answer. This method is used for operating exceptions.
     * @param question - a question
     * @return - user's answer
     */
    public int ask(String question, ArrayList<Integer> range);
}