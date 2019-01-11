package ru.job4j.figures;

/**
 * Class for making a chess board.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 10.01.2019
 */
public class Board {

    /**
     * An array for figures.
     */
    private Figure[] figures = new Figure[32];

    /**
     * An index of an array.
     */
    private int index = 0;

    /**
     * Adds a new figure.
     * @param figure - a new figure
     */
    public void add(Figure figure) {
        this.figures[index++] = figure;
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
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        int figureIndex = -1;
        for (int value = 0; value < this.figures.length; value++) {
            if (this.figures[value].position().equals(source)) {
                figureIndex = value;
                break;
            }
        }
        if (figureIndex == -1) {
            throw new FigureNotFoundException("Figure not found");
        } else if (!this.isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Impossible move");
        } else if (this.isOccupied(this.figures[figureIndex], source, dest)) {
            throw new OccupiedWayException("The move is occupied");
        } else {
            this.figures[figureIndex] = this.figures[figureIndex].copy(dest);
        }
        return true;
    }

    /**
     * Checks if a figure moving on a diagonal.
     * @param source - a cell where a figure is now located
     * @param dest - a cell where a figure is supposed to move to
     * @return true/false
     */
    public boolean isDiagonal(Cell source, Cell dest) {
       boolean firstCon = true;
           try {
               int deltaX = dest.x - source.x / Math.abs(dest.x - source.x);
               int deltaY = dest.y - source.y / Math.abs(dest.y - source.y);
           } catch (ArithmeticException e) {
               firstCon = false;
           }
           return firstCon;
    }

    /**
     * Checks if a path, which a figure is supposed to walk, is occupied.
     * @param figure - a figure
     * @param source - a cell where a figure is now located
     * @param dest - a cell where a figure is supposed to move to
     * @return true/false
     */
    public boolean isOccupied(Figure figure, Cell source, Cell dest) {
        boolean condition = false;
        Cell[] values = figure.way(source, dest);
        for (Cell value : values) {
            for (Figure valueTwo : this.figures) {
                if (valueTwo != null && value.equals(valueTwo.position())) {
                    condition = true;
                    break;
                }
            }
        }
        return condition;
    }
}