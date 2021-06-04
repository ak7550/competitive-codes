import AkPackage.*;
import java.util.*;

public class SolveTheSoduko {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SolveTheSoduko());
        while (!lines.isEmpty()) {
            int grid[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For the given grid: ");
            Graph.printAdjacencyMatrix(grid);
            System.out.println(solveSoduko(grid));
            System.out.println("Solution is: ");
            Graph.printAdjacencyMatrix(grid);
        }
    }

    public static boolean solveSoduko(int grid[][]) {
        int row = 0, col = 0;
        for (col = 0; col < grid.length; col++) {
            for (row = 0; row < grid.length; row++) {
                if (grid[row][col] == 0) // i was searching for an empty square
                    break;
            }
            if (row != grid.length)
                if (grid[row][col] == 0) // i was searching for an empty square
                    break;
        }

        if (row == grid.length && col == grid.length) {
            // both have reached to the end that's why loop ended, no empty
            // square is left
            return true;
        }

        // -> grid[row][col] can have the digits from 1 - 9
        for (int i = 1; i <= grid.length; i++) {
            if (isSafe(grid, row, col, i)) {
                grid[row][col] = i;
                if (solveSoduko(grid))
                    return true;
                else
                    grid[row][col] = 0; // reset
            }
        }
        return false; // no possible solution has found out!!
    }

    public static boolean isSafe(int grid[][], int row, int col, int n) {
        // check row wise
        for (int i = 0; i < grid.length; i++)
            if (grid[i][col] == n)
                return false;
        // check col wise
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] == n) {
                return false;
            }
        }

        // check if the box has number before or not
        for (int r = row - (row % 3); r <= row - (row % 3) + 2; r++) {
            for (int c = col - (col % 3); c <= col - (col % 3) + 2; c++) {
                if (grid[r][c] == n) // anyone from the same box contains n
                    return false;
            }
        }

        return true; // after all the filteration it is ready to be true for this place
    }
}