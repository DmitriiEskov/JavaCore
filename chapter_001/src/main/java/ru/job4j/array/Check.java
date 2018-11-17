package ru.job4j.array;

/**
 * Class for checking if all elements of an array are true or false.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 17.11.2018
 */
public class Check {

    /**
     * Checking if all elements of an array are true or false.
     *
     * @param data - an array
     * @return true/false
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int i = 0; i < data.length; i++) {
           if (data[0] == data[i]) {
               result = true;
           } else {
               result = false;
               break;
           }
        }
        return result;
    }
}