import AkPackage.*;
import java.util.*;

public class UnitAreaOf1 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new UnitAreaOf1());
        while (!lines.isEmpty()) {
            int grid[][] = Graph.takeAdjacencyMatrixInput(lines);
            Graph.printAdjacencyMatrix(grid);
            System.out.println("Unit area of 1 is: " + findMax(grid));
        }
    }

    static int area;

    public static int findMax(int grid[][]) {
        int rowLength = grid[0].length, colLength = grid.length, maxArea = Integer.MIN_VALUE;
        boolean found[][] = new boolean[colLength][rowLength];
        for (int row = 0; row < colLength; row++) {
            for (int col = 0; col < rowLength; col++) {
                if (!found[row][col] && grid[row][col] == 1) {
                    area = 0;
                    dfs(grid, found, row, col, rowLength, colLength);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public static boolean check(int grid[][], boolean found[][], int row, int col, int rowLength, int colLength) {
        boolean rwc = row >= 0 && row < colLength, cwc = col >= 0 && col < rowLength;
        return rwc && cwc && grid[row][col] == 1 && !found[row][col];
    }

    public static void dfs(int grid[][], boolean found[][], int row, int col, int rowLength, int colLength) {
        area++;
        found[row][col] = true;
        if (check(grid, found, row + 1, col, rowLength, colLength)) {
            dfs(grid, found, row + 1, col, rowLength, colLength);
            // area++;
        }
        if (check(grid, found, row - 1, col, rowLength, colLength)) {
            dfs(grid, found, row - 1, col, rowLength, colLength);
            // area++;
        }
        if (check(grid, found, row, col + 1, rowLength, colLength)) {
            dfs(grid, found, row, col + 1, rowLength, colLength);
            // area++;
        }
        if (check(grid, found, row, col - 1, rowLength, colLength)) {
            dfs(grid, found, row, col - 1, rowLength, colLength);
            // area++;
        }
        if (check(grid, found, row - 1, col - 1, rowLength, colLength)) {
            dfs(grid, found, row - 1, col - 1, rowLength, colLength);
            // area++;
        }
        if (check(grid, found, row - 1, col + 1, rowLength, colLength)) {
            dfs(grid, found, row - 1, col + 1, rowLength, colLength);
            // area++;
        }
        if (check(grid, found, row + 1, col - 1, rowLength, colLength)) {
            dfs(grid, found, row + 1, col - 1, rowLength, colLength);
            // area++;
        }
        if (check(grid, found, row + 1, col + 1, rowLength, colLength)) {
            dfs(grid, found, row + 1, col + 1, rowLength, colLength);
            // area++;
        }
    }
}