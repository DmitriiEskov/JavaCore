package ru.job4j.figures.black;

import ru.job4j.figures.Cell;
import ru.job4j.figures.Figure;
import ru.job4j.figures.ImpossibleMoveException;

/**
 * Class for implementation of a black knight.
 *
 * @author Dmitrii Eskov
 * @version $Id$
 * @since 14.01.2019
 */
public class KnightBlack implements Figure {

    /**
     * a position of the figure.
     */
    private final Cell position;

    /**
     * The constructor.
     * @param position - a cell of the figure
     */
    public KnightBlack(final Cell position) {
        this.position = position;
    }

    /**
     * a position describes cells of a board.
     */
    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * Checks if a figure can move to a destination cell or not.
     * @param source - a cell where a figure is now located
     * @param dest - a cell where a figure is supposed to move to
     * @return an array of cells, which a figure is supposed to come through
     * @throws ImpossibleMoveException
     */
    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!this.isWayL(source, dest)) {
            throw new ImpossibleMoveException("Impossible move");
        }
        Cell[] values = new Cell[1];
        values[0] = Cell.values()[dest.ordinal()];
        return values;
    }

    /**
     * Creates a new figure having a specific cell.
     * @param dest - a cell where a figure is supposed to move to
     * @return Figure object
     */
    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }

    /**
     * Checks if a figure moving on a L way.
     * @param source - a cell where a figure is now located
     * @param dest - a cell where a figure is supposed to move to
     * @return true/false
     */
    private boolean isWayL(Cell source, Cell dest) {
        return ((Math.abs(dest.x - source.x) == 1 && Math.abs(dest.y - source.y) == 2)
                || (Math.abs(dest.x - source.x) == 2 && Math.abs(dest.y - source.y) == 1));
    }
}