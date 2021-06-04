import AkPackage.*;
import java.util.*;

public class RatmazeWithMultiPleJumps2 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new RatMazeWithMultipleJumps());
        while (!lines.isEmpty()) {
            int maze[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("\n\nFor the given input: ");
            Graph.printAdjacencyMatrix(maze);
            solve(maze);
        }
    }

    static int remainingCount = 0;

    public static void solve(int[][] maze) {
        int hopeCount[][] = new int[maze.length][maze.length], sol[][] = new int[maze.length][maze.length];
        // lets build the hopeCount array first
        gotoPos(hopeCount, maze, 0, 0);
        System.out.println("\n\nHopeCount Matrix is: ");
        Graph.printAdjacencyMatrix(hopeCount);
        remainingCount = hopeCount[0][0];
        if (remainingCount > 2 * maze.length - 1) // from [0,0] maximum number of jumps to take
        {
            System.out.println("Ans is: -1");
            return;
        }
        makeSoultion(sol, maze, hopeCount, 0, 0);
        System.out.println("\n\nSolution Matrix: ");
        Graph.printAdjacencyMatrix(sol);
    }

    static class Pair {
        int row, col;
    }

    public static boolean makeSoultion(int sol[][], int maze[][], int hopeCount[][], int row, int col) {

        sol[row][col] = 1;
        // -> base case
        // reached to the end
        if (row == hopeCount.length - 1 && col == hopeCount.length - 1)
            return true;

        Pair pair = new Pair();
        // going forward
        for (int i = col + 1; i < hopeCount.length; i++) {
            if (hopeCount[row][i] == remainingCount - 1) {
                pair.col = i;
                pair.row = row;

                // _ make all the points int the same row as 1
                for (int j = col; j <= pair.col; j++) {
                    if (maze[row][j] != 0)
                        sol[row][j] = 1;
                }
                remainingCount--;

                if (makeSoultion(sol, maze, hopeCount, pair.row, pair.col))
                    return true;

                remainingCount++;
                for (int j = col; j <= pair.col; j++) {
                    if (maze[row][j] != 0)
                        sol[row][j] = 0;
                }
            }
        }

        // going downward
        for (int i = row + 1; i < hopeCount.length; i++) {
            if (hopeCount[i][col] == remainingCount - 1) {
                pair.row = i;
                pair.col = col;

                for (int j = row; j <= pair.row; j++) {
                    if (maze[j][col] != 0)
                        sol[j][col] = 1;
                }

                remainingCount--;

                if (makeSoultion(sol, maze, hopeCount, pair.row, pair.col))
                    return true;

                remainingCount++;
                for (int j = col; j <= pair.col; j++) {
                    if (maze[row][j] != 0)
                        sol[row][j] = 0;
                }
            }
        }

        return false;
    }

    public static void gotoPos(int hopeCount[][], int maze[][], int row, int col) {

        // -> base cases

        // _ if we have reached this node before, that means all of it's adjacent nodes
        // _ has been visited
        if (hopeCount[row][col] != 0)
            return;

        // _ if we reached to the end of the maze
        if (row == maze.length - 1 && col == maze.length - 1) {
            hopeCount[row][col] = 1;
            return;
        }

        // _ if the maze containes 0 ==> means from this maze node you can't go to
        // _ anywhere
        if (maze[row][col] == 0) {
            hopeCount[row][col] = Integer.MAX_VALUE;
            return;
        }

        int minJumps = Integer.MAX_VALUE;

        // going downward first, so we can ignore if we get the same forward value
        for (int i = 1; i <= maze[row][col] && row + i < maze.length; i++) {
            gotoPos(hopeCount, maze, row + i, col); // to update the hopecount value
            minJumps = Math.min(minJumps, hopeCount[row + i][col]);
        }

        // going forward
        for (int i = 1; i <= maze[row][col] && col + i < maze.length; i++) {
            gotoPos(hopeCount, maze, row, col + i);
            minJumps = Math.min(minJumps, hopeCount[row][col + i]);
        }

        // -> it may happen that minJumps will consists the MAXVALUE till the end.
        // -> that means we can't reach to the end from this node.
        // -> then this node will also have the MAXVALUE in it.
        hopeCount[row][col] = minJumps == Integer.MAX_VALUE ? minJumps : minJumps + 1;
    }

}