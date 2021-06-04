import AkPackage.*;
import java.util.*;

public class RatInMazeWithMultipleJumpsv3 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new RatMazeWithMultipleJumps());
        while (!lines.isEmpty()) {
            int maze[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("\n\nFor the given input: ");
            Graph.printAdjacencyMatrix(maze);
            solve(maze);
        }
    }

    public static void solve(int maze[][]) {
        int sol[][] = new int[maze.length][maze.length];
        maze[maze.length - 1][maze.length - 1] = 1; // so it never become zero
        boolean res = jump(maze, sol, 0, 0);
        if (res) // res true then sol[0][0] is 1.
            sol[0][0] = 1;
        System.out.println("Solution is: ");
        System.out.println("Ans: " + res);
        System.out.println("sol is: ");
        Graph.printAdjacencyMatrix(sol);
    }

    public static boolean jump(int maze[][], int sol[][], int row, int col) {
        // _base cases
        // -> reached to heaven
        if (row == maze.length - 1 && col == maze.length - 1) {
            sol[row][col] = 1;
            return true;
        }


        // -> cols are the 1st priority
        for (int i = 1; i <= maze[row][col] && col + i < maze.length; i++) {
            if (maze[row][col + i] != 0) {
                if (jump(maze, sol, row, col + i)) {
                    sol[row][col+i] = 1;
                    return true;
                }
            }
        }

        // -> rows are the 2nd priority
        for (int i = 1; i <= maze[row][col] && row + i < maze.length; i++) {
            if (maze[row + i][col] != 0) {
                if (jump(maze, sol, row + i, col)) {
                    sol[row + i][col] = 1;
                    return true;
                }
            }
        }

        sol[row][col] = 0; // !reset
        return false;
    }
}