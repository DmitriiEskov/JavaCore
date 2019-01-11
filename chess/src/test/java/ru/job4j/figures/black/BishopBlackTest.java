package ru.job4j.figures.black;

import org.junit.Before;
import org.junit.Test;
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
     * The chess board.
     */
    private Board board = new Board();

    /**
     * Adding all figures on the board.
     */
    @Before
    public void fillBoardWithAllFigures() {
        this.board.add(new RookBlack(Cell.A1));
        this.board.add(new KnightBlack(Cell.B1));
        this.board.add(new BishopBlack(Cell.C1));
        this.board.add(new QeenBlack(Cell.D1));
        this.board.add(new KingBlack(Cell.E1));
        this.board.add(new BishopBlack(Cell.F1));
        this.board.add(new KnightBlack(Cell.G1));
        this.board.add(new RookBlack(Cell.H1));

        this.board.add(new PawnBlack(Cell.A2));
        this.board.add(new PawnBlack(Cell.B2));
        this.board.add(new PawnBlack(Cell.C2));
        this.board.add(new PawnBlack(Cell.D2));
        this.board.add(new PawnBlack(Cell.E2));
        this.board.add(new PawnBlack(Cell.F2));
        this.board.add(new PawnBlack(Cell.G2));
        this.board.add(new PawnBlack(Cell.H2));

        this.board.add(new RookWhite(Cell.A8));
        this.board.add(new KnightWhite(Cell.B8));
        this.board.add(new BishopWhite(Cell.C8));
        this.board.add(new QeenWhite(Cell.D8));
        this.board.add(new KingWhite(Cell.E8));
        this.board.add(new BishopWhite(Cell.F8));
        this.board.add(new KnightWhite(Cell.G8));
        this.board.add(new RookWhite(Cell.H8));

        this.board.add(new PawnWhite(Cell.A7));
        this.board.add(new PawnWhite(Cell.B7));
        this.board.add(new PawnWhite(Cell.C7));
        this.board.add(new PawnWhite(Cell.D7));
        this.board.add(new PawnWhite(Cell.E7));
        this.board.add(new PawnWhite(Cell.F7));
        this.board.add(new PawnWhite(Cell.G7));
        this.board.add(new PawnWhite(Cell.H7));
    }

    /**
     * When a figure is being moved from C1 to F4.
     * delta: ++
     */
    @Test
    public void whenMovedFromC1toF4() {
        Figure figure = new BishopBlack(Cell.C1);
        Board board = new Board();
        board.add(figure);
        board.move(Cell.C1, Cell.F4);
    }

    /**
     * When a figure is being moved from H8 to E5.
     * delta: --
     */
    @Test
    public void whenMovedFromH8toE5() {
        Figure figure = new BishopBlack(Cell.H8);
        Board board = new Board();
        board.add(figure);
        board.move(Cell.H8, Cell.E5);
    }

    /**
     * When a figure is being moved from D5 to E4.
     * delta: +-
     */
    @Test
    public void whenMovedFromD5toE4() {
        Figure figure = new BishopBlack(Cell.D5);
        Board board = new Board();
        board.add(figure);
        board.move(Cell.D5, Cell.E4);
    }

    /**
     * When an impossible move.
     */
    @Test (expected = ImpossibleMoveException.class)
    public void whenImpossibleMoveFromD5toG5() throws ImpossibleMoveException {
        this.board.move(Cell.C1, Cell.C4);
    }

    /**
     * When a cell is occupied.
     */
    @Test (expected = OccupiedWayException.class)
    public void whenCellIsOccupied() throws OccupiedWayException {
        this.board.move(Cell.C1, Cell.F4);
    }

    /**
     * When a figure is not found.
     */
    @Test (expected = FigureNotFoundException.class)
    public void whenFigureNotFound() throws FigureNotFoundException {
        this.board.move(Cell.F4, Cell.E5);
    }
}