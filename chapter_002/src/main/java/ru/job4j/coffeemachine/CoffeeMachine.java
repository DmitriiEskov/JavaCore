package ru.job4j.coffeemachine;

import java.util.Arrays;

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
        int[] coins = {1, 2, 5, 10};
        int index = 0;
        int[] result = new int[change];
        int coinsIndex = coins.length - 1;
        while (change != 0) {
            while (change - coins[coinsIndex] < 0) {
                coinsIndex--;
            }
            change -= coins[coinsIndex];
            result[index++] = coins[coinsIndex];
        }
        return Arrays.copyOf(result, index);
    }
}