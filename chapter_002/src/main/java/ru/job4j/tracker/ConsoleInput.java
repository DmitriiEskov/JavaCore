package ru.job4j.tracker;

import java.util.*;

/**
 * Class for input of user's console data.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 12.12.2018
 */
public class ConsoleInput implements Input {

    /**
     * Interacts with a user through the console.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Questions a user and gets their answer.
     * @param question - a question
     * @return - a user's answer
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}