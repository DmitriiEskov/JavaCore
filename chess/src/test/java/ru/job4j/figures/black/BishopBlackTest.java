package ru.job4j.figures.black;

import static org.hamcrest.core.Is.is;
import org.junit.*;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.Logic;
import ru.job4j.figures.*;
import ru.job4j.figures.white.*;

/**
 * Test for the "BishopBlack" class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 11.01.2019
 * @version 1.0
 */
public class BishopBlackTest {

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

        this.logic.add(new BishopBlack(Cell.E4));

        this.logic.add(new QeenBlack(Cell.D1));
        this.logic.add(new KingBlack(Cell.E1));
        this.logic.add(new BishopBlack(Cell.F1));
        this.logic.add(new KnightBlack(Cell.G1));
        this.logic.add(new RookBlack(Cell.H1));

        this.logic.add(new PawnBlack(Cell.A2));
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
     * When a figure is being moved from E4 to G6.
     * delta: ++
     */
    @Test
    public void whenMovedFromE4toG6() {
        boolean result = this.logic.move(Cell.E4, Cell.G6);
        Assert.assertThat(result, is(true));
    }

    /**
     * When a figure is being moved from E4 to D3.
     * delta: --
     */
    @Test
    public void whenMovedFromE4toD3() {
        boolean result = this.logic.move(Cell.E4, Cell.D3);
        Assert.assertThat(result, is(true));
    }

    /**
     * When a figure is being moved from E4 to F3.
     * delta: +-
     */
    @Test
    public void whenMovedFromE4toF3() {
        boolean result = this.logic.move(Cell.E4, Cell.F3);
        Assert.assertThat(result, is(true));
    }

    /**
     * When a figure is being moved from E4 to C6.
     * delta: -+
     */
    @Test
    public void whenMovedFromE4toC6() {
        boolean result = this.logic.move(Cell.E4, Cell.C6);
        Assert.assertThat(result, is(true));
    }

    /**
     * When an impossible move.
     */
    @Test (expected = ImpossibleMoveException.class)
    public void whenImpossibleMoveFromE4toE6() throws ImpossibleMoveException {
        this.logic.move(Cell.E4, Cell.E6);
    }

    /**
     * When a cell is occupied.
     */
    @Test (expected = OccupiedWayException.class)
    public void whenCellIsOccupied() throws OccupiedWayException {
        this.logic.move(Cell.F1, Cell.A6);
    }

    /**
     * When a figure is not found.
     */
    @Test (expected = FigureNotFoundException.class)
    public void whenFigureNotFound() throws FigureNotFoundException {
        this.logic.move(Cell.F3, Cell.H5);
    }
}