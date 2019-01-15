package ru.job4j.figures.white;

import ru.job4j.figures.Cell;
import ru.job4j.figures.Figure;
import ru.job4j.figures.ImpossibleMoveException;

/**
 * @author Dmitrii Eskov
 * @version $Id$
 * @since 10.01.2019
 */
public class KnightWhite implements Figure {
    private final Cell position;

    public KnightWhite(final Cell position) {
        this.position = position;
    }

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

    @Override
    public Figure copy(Cell dest) {
        return new KnightWhite(dest);
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