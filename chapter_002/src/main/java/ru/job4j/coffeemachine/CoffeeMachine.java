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
        int tenRuble = change / 10;
        int fiveRuble = (change - tenRuble * 10) / 5;
        int twoRuble = (change - tenRuble * 10 - fiveRuble * 5) / 2;
        int oneRuble = change - tenRuble * 10 - fiveRuble * 5 - twoRuble * 2;
        int sum = tenRuble + fiveRuble + twoRuble + oneRuble;
        int[] result = new int[tenRuble + fiveRuble + twoRuble + oneRuble];
        for (int i = 0; i < sum; i++) {
            if (tenRuble != 0) {
                result[i] = 10;
                tenRuble--;
            } else if (fiveRuble != 0) {
                result[i] = 5;
                fiveRuble--;
            } else if (twoRuble != 0) {
                result[i] = 2;
                twoRuble--;
            } else if (oneRuble != 0) {
                result[i] = 1;
                oneRuble--;
            }
        }
        return result;
    }
}