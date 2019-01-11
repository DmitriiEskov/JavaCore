package ru.job4j.figures.white;

import ru.job4j.figures.Cell;
import ru.job4j.figures.Figure;

/**
 * @author Dmitrii Eskov
 * @version $Id$
 * @since 10.01.2019
 */
public class QeenWhite implements Figure {
    private final Cell position;

    public QeenWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        return new Cell[] {
                dest
        };
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenWhite(dest);
    }
}