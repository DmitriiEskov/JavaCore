package ru.job4j.coffeemachine;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for the "CoffeeMachine" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 21.01.2019
 * @version 1.0
 */
public class CoffeeMachineTest {

    /**
     * Tests when the coffee price is 35 RUB, the value is 50 RUB, the change is 15 RUB.
     */
    @Test
    public void whenPrice35AndValue50ThenChange15() {
        CoffeeMachine coffee = new CoffeeMachine();
        int[] change = {10, 5};
        assertThat(coffee.changes(50, 35), is(change));
    }

    /**
     * Tests when the coffee price is 39 RUB, the value is 150 RUB, the change is 111 RUB.
     */
    @Test
    public void whenPrice39AndValue150ThenChange111() {
        CoffeeMachine coffee = new CoffeeMachine();
        int[] change = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 1};
        assertThat(coffee.changes(150, 39), is(change));
    }

    /**
     * Tests when the coffee price is 50 RUB, the value is 50 RUB, the change is 0 RUB.
     */
    @Test
    public void whenPrice50AndValue50ThenChange0() {
        CoffeeMachine coffee = new CoffeeMachine();
        int[] change = {};
        assertThat(coffee.changes(50, 50), is(change));
    }

    /**
     * Tests when the coffee price is 46 RUB, the value is 50 RUB, the change is 4 RUB.
     */
    @Test
    public void whenPrice46AndValue50ThenChange4() {
        CoffeeMachine coffee = new CoffeeMachine();
        int[] change = {2, 2};
        assertThat(coffee.changes(50, 46), is(change));
    }

    /**
     * Tests when the coffee price is 49 RUB, the value is 50 RUB, the change is 1 RUB.
     */
    @Test
    public void whenPrice49AndValue50ThenChange1() {
        CoffeeMachine coffee = new CoffeeMachine();
        int[] change = {1};
        assertThat(coffee.changes(50, 49), is(change));
    }

    /**
     * Tests when the coffee price is 77 RUB, the value is 100 RUB, the change is 23 RUB.
     */
    @Test
    public void whenPrice77AndValue100ThenChange0() {
        CoffeeMachine coffee = new CoffeeMachine();
        int[] change = {10, 10, 2, 1};
        assertThat(coffee.changes(100, 77), is(change));
    }
}