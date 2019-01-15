package ru.job4j.figures.white;

import ru.job4j.figures.Cell;
import ru.job4j.figures.Figure;
import ru.job4j.figures.ImpossibleMoveException;

/**
 * @author Dmitrii Eskov
 * @version $Id$
 * @since 10.01.2019
 */
public class RookWhite implements Figure {
    private final Cell position;

    public RookWhite(final Cell position) {
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
        if (!this.isHorizontalOrVertical(source, dest)) {
            throw new ImpossibleMoveException("Impossible move");
        }
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        Cell[] values = new Cell[Math.abs((deltaX == 0) ? deltaY : deltaX)];
        for (int x = 0; x < Math.abs((source.x == dest.x) ? Math.abs(deltaY) : Math.abs(deltaX)); x++) {
            values[x] = Cell.values()[source.ordinal() + ((source.x == dest.x ? 1 : 8) * (x + 1)
                    * (source.x == dest.x ? deltaY / Math.abs(deltaY) : deltaX / Math.abs(deltaX)))];
        }
        return values;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookWhite(dest);
    }

    /**
     * Checks if a figure moving on a horizontal or a vertical.
     * @param source - a cell where a figure is now located
     * @param dest - a cell where a figure is supposed to move to
     * @return true/false
     */
    private boolean isHorizontalOrVertical(Cell source, Cell dest) {
        return (source.x == dest.x || source.y == dest.y);
    }
}