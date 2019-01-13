package ru.job4j;

import ru.job4j.figures.*;

/**
 * Class for making a chess board.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 10.01.2019
 */
public class Logic {

    /**
     * An array for figures.
     */
    private final Figure[] figures = new Figure[32];

    /**
     * An index of an array.
     */
    private int index = 0;

    /**
     * Adds a new figure.
     * @param figure - a new figure
     */
    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * The method checks the following:
     * 1. If a cell contains a figure (if false, the FigureNotFoundException is thrown);
     * 2. If there's a figure on the cell, checks if the figure can be moved in the way it is required
     * (if false, the ImpossibleMoveException is thrown);
     * 3. If an array of cells, which a figure is supposed to come through, does not contain any other figures
     * (If false, the OccupiedWayException is thrown);
     * 4. If there are no problems for a figure to be moved, a new figure with the specific cell is created.
     * @param source - a cell where a figure is now located
     * @param dest - a cell where a figure is supposed to move to
     * @return true/false
     * @throws ImpossibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
    public boolean move(Cell source, Cell dest) throws FigureNotFoundException, ImpossibleMoveException, OccupiedWayException {
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("Figure not found");
        }
        Cell[] steps = this.figures[index].way(source, dest);
        for (Cell cell : steps) {
            if (this.findBy(cell) != -1) {
                throw new OccupiedWayException("The way is occupied");
            }
        }
        this.figures[index] = this.figures[index].copy(dest);
        return true;
    }


    /**
     * Cleans the chess board.
     */
    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    /**
     * Finds a required cell among all cells of the board.
     * @param cell - a required cell
     * @return if found - an index of the cell in this.figures, if not - -1;
     */
    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}