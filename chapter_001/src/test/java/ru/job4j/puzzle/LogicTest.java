package ru.job4j.puzzle;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test for Logic class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 27.11.2018
 */
public class LogicTest {

    /**
     * Testing when the 3rd vertical is winning.
     */
    @Test
    public void whenVerticalWin() {
        Logic logic = new Logic(5) {
            @Override
            public int[][] convert() {
                return new int[][] {
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                };
            }
        };
        assertThat(logic.isWin(), is(true));
    }

    /**
     * Testing when the 3rd horizontal is winning.
     */
    @Test
    public void whenHorizontalWin() {
        Logic logic = new Logic(5) {
            @Override
            public int[][] convert() {
                return new int[][] {
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 0},
                        {0, 0, 0, 0, 0},
                };
            }
        };
        assertThat(logic.isWin(), is(true));
    }

    /**
     * Testing when no winning combinations.
     */
    @Test
    public void whenNotWin() {
        Logic logic = new Logic(5) {
            @Override
            public int[][] convert() {
                return new int[][] {
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                };
            }
        };
        assertThat(logic.isWin(), is(false));
    }

    /**
     * Testing when no winning combinations.
     */
    @Test
    public void whenVerticalFalse() {
        Logic logic = new Logic(5) {
            @Override
            public int[][] convert() {
                return new int[][] {
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {0, 0, 0, 1, 0},
                        {1, 0, 0, 1, 0},
                        {0, 0, 0, 1, 0},
                };
            }
        };
        assertThat(logic.isWin(), is(false));
    }

    /**
     * Testing when the 5th horizontal is winning.
     */
    @Test
    public void when5thHorizontalTrue() {
        Logic logic = new Logic(5) {
            @Override
            public int[][] convert() {
                return new int[][] {
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {0, 0, 0, 1, 0},
                        {1, 0, 0, 1, 0},
                        {1, 1, 1, 1, 1},
                };
            }
        };
        assertThat(logic.isWin(), is(true));
    }

    /**
     * Testing when the 5th vertical is winning.
     */
    @Test
    public void when5thVerticalTrue() {
        Logic logic = new Logic(5) {
            @Override
            public int[][] convert() {
                return new int[][] {
                        {0, 0, 0, 0, 1},
                        {0, 0, 0, 1, 1},
                        {1, 1, 0, 1, 1},
                        {1, 0, 0, 1, 1},
                        {0, 1, 1, 1, 1},
                };
            }
        };
        assertThat(logic.isWin(), is(true));
    }

    /**
     * Testing when the 5th vertical is winning.
     */
    @Test
    public void when5thVerticalTrueAgain() {
        Logic logic = new Logic(5) {
            @Override
            public int[][] convert() {
                return new int[][] {
                        {0, 0, 0, 1, 1},
                        {0, 0, 0, 1, 1},
                        {1, 1, 0, 1, 1},
                        {1, 0, 0, 1, 1},
                        {0, 1, 1, 0, 1},
                };
            }
        };
        assertThat(logic.isWin(), is(true));
    }

    /**
     * Testing when no winning combinations.
     */
    @Test
    public void whenAllFalse() {
        Logic logic = new Logic(5) {
            @Override
            public int[][] convert() {
                return new int[][] {
                        {1, 1, 1, 0, 0},
                        {1, 1, 1, 1, 0},
                        {1, 1, 1, 1, 0},
                        {1, 1, 1, 1, 0},
                        {0, 0, 0, 1, 1},
                };
            }
        };
        assertThat(logic.isWin(), is(false));
    }

    /**
     * Testing when no winning combinations.
     */
    @Test
    public void allFalse() {
        Logic logic = new Logic(5) {
            @Override
            public int[][] convert() {
                return new int[][] {
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                };
            }
        };
        assertThat(logic.isWin(), is(false));
    }
}