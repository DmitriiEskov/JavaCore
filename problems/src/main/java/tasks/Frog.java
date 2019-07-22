package tasks;

import java.util.*;

/**
 * This programme solves the Frog problem.
 *
 * The programme returns the minimum number of jumps that the frog needs to do in order to get
 * from the initial segment to the final one and shows all possible paths with the minimum number of jumps.
 *
 * Rules: The frog can't jump out of the circle, can't turn around, and can't jump through the center.
 * The frog cannot jump on segments that are occupied by trees.
 *
 * Input parameters: start and end segments, number of trees, coordinates of segments occupied by trees.
 *
 * Output: a Set with all possible minimum paths from point A to point B.
 * A path is represented as pairs of coordinates such as
 * [circle number, sector number, circle number, sector number etc.].
 * A number of jumps for such paths is also shown after square parentheses.
 * The example of the output: "[7, 11, 7, 14, 5, 15, 4, 1, 3, 3] Number of jumps: 4".
 *
 * If no way is found then the message about the impossibility to get from the starting position to the final one
 * is thrown.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 17.07.2019
 */
public class Frog {

    /**
     * The previous position of the frog.
     */
    private int previous;

    /**
     * Number of jumps of a minimum path.
     */
    private int min = Integer.MAX_VALUE;

    /**
     * The initial position of the frog.
     */
    private int[] start;

    /**
     * Array for calculating permutations, which indicates if we have already used an i-th number.
     * The length is 5 because we have only 5 possible movements.
     */
    private boolean[] used = new boolean[5];

    /**
     * Array for storing permutations.
     * The length is 5 because we have only 5 possible movements.
     */
    private int[] permutations = new int[5];

    /**
     * Area where a frog is moving. This array simulates a circle.
     * The first length indicates the number of sectors.
     * The second length indicates the number of circles.
     */
    private final int[][] circle = new int[16][10];

    /**
     * The stack is for saving the coordinates of each position while jumping.
     */
    private Stack<Integer> stack = new Stack<>();

    /**
     * Contains coordinates of jumps of a minimum path and a number of jumps.
     */
    private HashSet<String> set = new HashSet<>();

    /**
     * Initiates the input parameters and moves the frog from the initial position to the final position.
     * @param start - the initial position
     * @param finish - the final position
     * @param treesNumber - number of trees
     * @param coordinates - coordinates of trees
     * @return the result set containing the coordinates of the minimum path and the minimum number of jumps for it.
     */
    public HashSet<String> move(int[] start, int[] finish, int treesNumber, int[]...coordinates) {
        this.start = start;
        this.circle[finish[1] - 1][finish[0] - 1] = 2;
        if (treesNumber > 0) {
            int[] treePosition;
            for (int i = 0; i < coordinates.length; i++) {
                treePosition = coordinates[i];
                this.circle[treePosition[1] - 1][treePosition[0] - 1] = -1;
            }
        }
        this.calcPermutations(0);
        if (this.set.isEmpty()) {
            System.out.println("Impossible to find a way to the specified destination.");
        }
        return this.set;
    }

    /**
     * Calculates and checks for possibility of moving all possible paths for the frog to move on this.circle.
     * @param step - number of a jump or, factually, a level of recursion
     * @param current - current position of the frog for each recursion level
     * @param index - indicates what movement to use at each level of recursion
     * @param sequences - array with sequences of movements, which indicates an order of movements
     */
    private void step(int step, int[] current, int index, int[] sequences) {
        this.stack.push(current[0]);
        this.stack.push(current[1]);
        if (this.circle[current[1] - 1][current[0] - 1] == 2) {
            if (step <= this.min) {
                this.min = step;
                if (this.previous > this.min) {
                    this.set.clear();
                }
                this.previous = step;
                this.set.add(this.stack.toString() + " Number of jumps: " + String.valueOf(step - 1));
            }
            this.stack.pop();
            this.stack.pop();
            return;
        } else if (circle[current[1] - 1][current[0] - 1] == 1) {
            this.stack.pop();
            this.stack.pop();
            return;
        }
        this.circle[current[1] - 1][current[0] - 1] = 1;
        int[] forward = {current[0],
                current[1] + 3 > this.circle.length ? current[1] + 3 - this.circle.length : current[1] + 3};

        int[] right2 = {current[0] - 1,
                current[1] + 2 > this.circle.length ? current[1] + 2 - this.circle.length : current[1] + 2};

        int[] left2 = {current[0] + 1,
                current[1] + 2 > this.circle.length ? current[1] + 2 - this.circle.length : current[1] + 2};

        int[] right1 = {current[0] - 2,
                current[1] + 1 > this.circle.length ? current[1] + 1 - this.circle.length : current[1] + 1};

        int[] left1 = {current[0] + 2,
                current[1] + 1 > this.circle.length ? current[1] + 1 - this.circle.length : current[1] + 1};
        for (int i = index; i < 5; i++) {
            if (i == sequences[0] && this.checkStep(current, forward)) {
                step(step + 1, forward, i, sequences);
            } else if (i == sequences[1] && this.checkStep(current, right2)) {
                step(step + 1, right2, i, sequences);
            } else if (i == sequences[2] && this.checkStep(current, left2)) {
                step(step + 1, left2, i, sequences);
            } else if (i == sequences[3] && this.checkStep(current, right1)) {
                step(step + 1, right1, i, sequences);
            } else if (i == sequences[4] && this.checkStep(current, left1)) {
                step(step + 1, left1, i, sequences);
            }
        }
        this.circle[current[1] - 1][current[0] - 1] = 0;
        this.stack.pop();
        this.stack.pop();
    }

    /**
     * Returns true if the destination is reachable, false - otherwise.
     * Checks if there are trees on the way and if the way goes out of the this.circle.
     */
    private boolean checkStep(int[] current, int[] dest) {
        boolean res = true;
        int curI = current[1] - 1;
        int curJ = current[0] - 1;
        int destI = dest[1] - 1;
        int destJ = dest[0] - 1;
        if (destI >= this.circle.length || destJ >= this.circle[1].length || destJ < 0 || curJ < 0) {
            res = false;
        } else {
            int delta = curJ - destJ;
            for (int i = 1; i < Math.abs(delta) + 1; i++) {
                if (delta > 0) {
                    if (this.circle[curI][curJ - i] == -1) {
                        res = false;
                        break;
                    }
                } else {
                    if (this.circle[curI][curJ + i] == -1) {
                        res = false;
                        break;
                    }
                }
            }
            for (int i = 1; i < destI - curI + 1; i++) {
                if (this.circle[curI + i][destJ] == -1) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * Calculates permutations. In our case there are 5! permutations, because we have only 5 possible moves.
     * @param idx level of recursion
     */
    private void calcPermutations(int idx) {
        if (idx == this.permutations.length) {
            this.step(1, this.start, 0, this.permutations);
            return;
        }
        for (int i = 0; i < this.permutations.length; i++) {
            if (this.used[i]) {
                continue;
            }
            this.permutations[idx] = i;
            this.used[i] = true;
            calcPermutations(idx + 1);
            this.used[i] = false;
        }
    }
}