package ru.job4j.figures.black;

import ru.job4j.figures.Cell;
import ru.job4j.figures.Figure;
import ru.job4j.figures.ImpossibleMoveException;

/**
 * Class for implementation of a black rook.
 *
 * @author Dmitrii Eskov
 * @version $Id$
 * @since 14.01.2019
 */
public class RookBlack implements Figure {

    /**
     * a position of the figure.
     */
    private final Cell position;

    /**
     * The constructor.
     * @param position - a cell of the figure
     */
    public RookBlack(final Cell position) {
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

    /**
     * Creates a new figure having a specific cell.
     * @param dest - a cell where a figure is supposed to move to
     * @return Figure object
     */
    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
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