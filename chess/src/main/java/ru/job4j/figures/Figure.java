package ru.job4j.figures;

/**
 * Interface for describing a condition of a figure.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 10.01.2019
 */
public interface Figure {

    /**
     * a position describes cells of a board.
     */
    Cell position();

    /**
     * Checks if a figure can move to a destination cell or not.
     * @param source - a cell where a figure is now located
     * @param dest - a cell where a figure is supposed to move to
     * @return an array of cells, which a figure is supposed to come through
     */
    Cell[] way(Cell source, Cell dest);

    /**
     * Uploads a picture of a figure.
     * @return a picture
     */
    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    /**
     * Creates a new figure having a specific cell.
     */
    Figure copy(Cell dest);
}