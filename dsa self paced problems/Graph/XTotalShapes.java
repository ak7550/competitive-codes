import AkPackage.*;
import java.util.*;

public class XTotalShapes {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new XTotalShapes());
        while (!lines.isEmpty()) {
            int grid[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For the given input: ");
            Graph.printAdjacencyMatrix(grid);
            System.out.println("Number of X total shapes are: " + xShape(grid));
        }
    }

    public static int getLocation(int row, int col) {
        return row * rowLength + col;
    }

    // matrix is n*m

    static int rowLength, colLength;
    public static int xShape(int[][] grid) {
        int count = 0;
        rowLength = grid[0].length;
        colLength = grid.length;
        boolean found[] = new boolean[grid.length * grid[0].length];
        for (int row = 0; row < grid.length; row++) { // traversing through cols
            for (int col = 0; col < grid[row].length; col++) { // traversing through row
                if (!found[getLocation(row,col)] && grid[row][col]!=0) {
                    dfs(row, col, grid, found);
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean check(int row, int col, int[][] grid, boolean found[]) {
        boolean isRowUnderControlled = row >= 0 && row < colLength,
                isColumnUnderControlled = col >= 0 && col < rowLength;
        return isRowUnderControlled && isColumnUnderControlled ?  grid[row][col] != 0
                && !found[getLocation(row, col)] : false;
    }

    public static void dfs(int row, int col, int[][] grid, boolean[] found) {
        found[getLocation(row, col)] = true;
        if (check(row + 1, col, grid, found))
            dfs(row + 1, col, grid, found);
        if (check(row - 1, col, grid, found))
            dfs(row - 1, col, grid, found);
        if (check(row, col + 1,grid, found))
            dfs(row, col + 1, grid, found);
        if (check(row, col - 1,grid, found))
            dfs(row, col - 1, grid, found);
    }
}