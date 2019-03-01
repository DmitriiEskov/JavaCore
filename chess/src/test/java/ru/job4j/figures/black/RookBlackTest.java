package ru.job4j.figures.black;

import static org.hamcrest.core.Is.is;
import org.junit.*;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.Logic;
import ru.job4j.figures.*;
import ru.job4j.figures.white.*;

/**
 * Test for the "RookBlack" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 14.01.2019
 * @version 1.0
 */
public class RookBlackTest {

    /**
     * The chess logic.
     */
    private Logic logic = new Logic();

    /**
     * Adding all figures on the logic.
     */
    @Before
    public void fillBoardWithAllFigures() {
        this.logic.add(new RookBlack(Cell.A1));
        this.logic.add(new KnightBlack(Cell.B1));
        this.logic.add(new BishopBlack(Cell.C1));
        this.logic.add(new QeenBlack(Cell.D1));
        this.logic.add(new KingBlack(Cell.E1));
        this.logic.add(new BishopBlack(Cell.F1));
        this.logic.add(new KnightBlack(Cell.G1));
        this.logic.add(new RookBlack(Cell.H1));

        this.logic.add(new PawnBlack(Cell.B3));

        this.logic.add(new PawnBlack(Cell.B2));
        this.logic.add(new PawnBlack(Cell.C2));
        this.logic.add(new PawnBlack(Cell.D2));
        this.logic.add(new PawnBlack(Cell.E2));
        this.logic.add(new PawnBlack(Cell.F2));
        this.logic.add(new PawnBlack(Cell.G2));
        this.logic.add(new PawnBlack(Cell.H2));

        this.logic.add(new RookWhite(Cell.A8));
        this.logic.add(new KnightWhite(Cell.B8));
        this.logic.add(new BishopWhite(Cell.C8));
        this.logic.add(new QeenWhite(Cell.D8));
        this.logic.add(new KingWhite(Cell.E8));
        this.logic.add(new BishopWhite(Cell.F8));
        this.logic.add(new KnightWhite(Cell.G8));
        this.logic.add(new RookWhite(Cell.H8));

        this.logic.add(new PawnWhite(Cell.A7));
        this.logic.add(new PawnWhite(Cell.B7));
        this.logic.add(new PawnWhite(Cell.C7));
        this.logic.add(new PawnWhite(Cell.D7));
        this.logic.add(new PawnWhite(Cell.E7));
        this.logic.add(new PawnWhite(Cell.F7));
        this.logic.add(new PawnWhite(Cell.G7));
        this.logic.add(new PawnWhite(Cell.H7));
    }

    /**
     * When a figure is being moved from A1 to A6.
     * delta: *+
     */
    @Test
    public void whenMovedFromA1toA6() {
        boolean result = this.logic.move(Cell.A1, Cell.A6);
        Assert.assertThat(result, is(true));
    }

    /**
     * When a figure is being moved from A6 to A1.
     * delta: *-
     */
    @Test
    public void whenMovedFromA6toA1() {
        this.logic.move(Cell.A1, Cell.A6);
        boolean result = this.logic.move(Cell.A6, Cell.A1);
        Assert.assertThat(result, is(true));
    }

    /**
     * When a figure is being moved from A5 to H5.
     * delta: +*
     */
    @Test
    public void whenMovedFromA5toH5() {
        this.logic.move(Cell.A1, Cell.A5);
        boolean result = this.logic.move(Cell.A5, Cell.H5);
        Assert.assertThat(result, is(true));
    }

    /**
     * When a figure is being moved from H5 to A5.
     * delta: -*
     */
    @Test
    public void whenMovedFromH5toA5() {
        this.logic.move(Cell.A1, Cell.A5);
        this.logic.move(Cell.A5, Cell.H5);
        boolean result = this.logic.move(Cell.H5, Cell.A5);
        Assert.assertThat(result, is(true));
    }

    /**
     * When an impossible move.
     */
    @Test (expected = ImpossibleMoveException.class)
    public void whenImpossibleMoveFromE4toE6() throws ImpossibleMoveException {
        this.logic.move(Cell.A1, Cell.G5);
    }

    /**
     * When a cell is occupied.
     */
    @Test (expected = OccupiedWayException.class)
    public void whenCellIsOccupied() throws OccupiedWayException {
        this.logic.move(Cell.A1, Cell.B1);
    }

    /**
     * When a figure is not found.
     */
    @Test (expected = FigureNotFoundException.class)
    public void whenFigureNotFound() throws FigureNotFoundException {
        this.logic.move(Cell.A3, Cell.H5);
    }
}