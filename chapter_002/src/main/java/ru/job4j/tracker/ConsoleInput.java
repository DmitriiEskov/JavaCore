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

    /**
     * Questions a user and gets their answer.
     * @param question - a question
     * @return - a user's answer
     */
    @Override
    public int ask(String question, ArrayList<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("The Incorrect input");
        }
        return key;
    }
}