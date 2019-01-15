package ru.job4j.figures.black;

import ru.job4j.figures.Cell;
import ru.job4j.figures.Figure;
import ru.job4j.figures.ImpossibleMoveException;

/**
 * Class for implementation of a black bishop.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 12.12.2018
 */
public class BishopBlack implements Figure {

    /**
     * a position of the figure.
     */
    private final Cell position;

    /**
     * The constructor.
     * @param position - a cell of the figure
     */
    public BishopBlack(final Cell position) {
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
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!this.isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Impossible move");
        }
        Cell[] values = new Cell[Math.abs((dest.x - source.x))];
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        for (int x = 0; x < Math.abs(dest.x - source.x); x++) {
            values[x] = Cell.values()[source.ordinal() + ((((deltaX + deltaY) == 0) ? 7 : 9) * (x + 1) * deltaX / Math.abs(dest.x - source.x))];
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
        return new BishopBlack(dest);
    }

    /**
     * Checks if a figure moving on a diagonal.
     * @param source - a cell where a figure is now located
     * @param dest - a cell where a figure is supposed to move to
     * @return true/false
     */
    private boolean isDiagonal(Cell source, Cell dest) {
        return (Math.abs(dest.x - source.x)) == (Math.abs(dest.y - source.y));
    }
}