package ru.job4j.loop;

import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Dmitrii Eskov (dmitryhope@yahoo.com)
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {

    /**
     * Test only for the right side of a pyramid.
     */
    @Test
        public void whenPyramid4Right() {
            Paint paint = new Paint();
            String rst = paint.rightTrl(4);
            System.out.println(rst);
            assertThat(rst,
                    is(
                            new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                    .add("^   ")
                                    .add("^^  ")
                                    .add("^^^ ")
                                    .add("^^^^")
                                    .toString()
                    )
            );
        }

    /**
     * Test only for the left side of a pyramid.
     */
    @Test
    public void whenPyramid4Left() {
        Paint paint = new Paint();
        String rst = paint.leftTrl(4);
        System.out.println(rst);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^")
                                .add("  ^^")
                                .add(" ^^^")
                                .add("^^^^")
                                .toString()
                )
        );
    }

    /**
     * Test for the whole pyramid of two rows.
     */
    @Test
    public void whenPyramidOfTwoRows() {
        Paint paint = new Paint();
        String rst = paint.pyramid(2);
        System.out.println(rst);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add(" ^ ")
                                .add("^^^")
                                .toString()
                )
        );
    }

    /**
     * Test for the whole pyramid of four rows.
     */
    @Test
    public void whenPyramidOfFourRows() {
        Paint paint = new Paint();
        String rst = paint.pyramid(4);
        System.out.println(rst);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^   ")
                                .add("  ^^^  ")
                                .add(" ^^^^^ ")
                                .add("^^^^^^^")
                                .toString()
                )
        );
    }
}