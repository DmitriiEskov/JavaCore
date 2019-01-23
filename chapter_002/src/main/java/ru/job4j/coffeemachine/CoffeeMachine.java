package ru.job4j.coffeemachine;

/**
 * Class for returning the change after a payment for coffee using a coffee machine.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 21.01.2019
 * @version 1.0
 */
public class CoffeeMachine {

    /**
     * Returns an array that contains change after the payment. The change represented as coins: 10, 5, 2, 1 and is
     * being returned in order starting with the most valuable (from 10 to 1).
     *
     * @param value - customer's value
     * @param price - price of coffee
     * @return an array containing change
     */
    public int[] changes(int value, int price) {
        int change = value - price;
        int[] money = {10, 5, 2, 1};
        int index = change / money[0]
                + (change % money[0]) / money[1]
                + ((change % money[0]) % money[1]) / money[2]
                + ((change % money[0]) % money[1]) % money[2];
        int[] result = new int[index];
        for (int i = 0; change != 0; i++) {
            if (change / money[0] != 0) {
                result[i] = money[0];
                change -= money[0];
            } else if ((change % money[0]) / money[1] != 0) {
                result[i] = money[1];
                change -= money[1];
            } else if (((change % money[0]) % money[1]) / money[2] != 0) {
                result[i] = money[2];
                change -= money[2];
            } else if (((change % money[0]) % money[1]) % money[2] != 0) {
                result[i] = money[3];
                change -= money[3];
            }
        }
        return result;
    }
}