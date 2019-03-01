package ru.job4j.figures.black;

import ru.job4j.figures.Cell;
import ru.job4j.figures.Figure;
import ru.job4j.figures.ImpossibleMoveException;

/**
 *
 * @author Dmitrii Eskov
 * @version $Id$
 * @since 10.01.2019
 */
public class PawnBlack implements Figure {
    private final Cell position;

    public PawnBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    // does not work at Chess class
    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!this.isStraight(source, dest)) {
            throw new ImpossibleMoveException("Impossible move");
        }
        return new Cell[] {
                dest
        };
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }

    /**
     * Checks if a figure moving on a L way.
     * @param source - a cell where a figure is now located
     * @param dest - a cell where a figure is supposed to move to
     * @return true/false
     */
    private boolean isStraight(Cell source, Cell dest) {
        return (source.x == dest.x && dest.y - source.y == 1);
    }
}