import AkPackage.*;
import java.util.*;

public class FindTheNumberOfIslands {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FindTheNumberOfIslands());
        while (!lines.isEmpty()) {
            int line[] = InputOutput.arrayFromString(lines.remove(0)), row = line[0], col = line[1];
            int grid[][] = new int[row][];
            for (int i = 0; i < grid.length; i++)
                grid[i] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("The grid is: ");
            Arrays.stream(grid).forEach(arr -> System.out.println(Arrays.toString(arr)));
            System.out.println("Total number of islands are: " + numIslands(grid));
        }
    }

    public static int numIslands(int grid[][]) {
        boolean found[] = new boolean[grid.length * grid[0].length];
        int island = 0;
        for (int i = 0; i < grid.length; i++) { // row
            for (int j = 0; j < grid[i].length; j++) { // col
                if (check(grid, found, i, j)) {
                    island++;
                    dfs(grid, found, i, j);
                }
            }
        }
        return island;
    }
    
    public static boolean check(int grid[][], boolean found[], int row, int col) {
        // grid is telling me if there's a land and found is telling me if I have considered it earlier.
        return grid[row][col] == 1 && !found[(grid[row].length * row) + col];
    }

    public static void dfs(int grid[][], boolean found[], int row, int col) {
        found[grid[row].length * row + col] = true;
        if(row+1<grid.length && check(grid, found, row+1, col)) dfs(grid, found, row+1, col);
        if (col + 1 < grid[row].length && check(grid, found, row, col + 1))
            dfs(grid, found, row, col + 1);
        if (row != 0 && check(grid, found, row - 1, col))
            dfs(grid, found, row - 1, col);
        if (col != 0 && check(grid, found, row, col - 1))
            dfs(grid, found, row, col - 1);
        if (row != 0 && col + 1 < grid[row].length && check(grid, found, row - 1, col + 1))
            dfs(grid, found, row - 1, col + 1);
        if (row != 0 && col != 0 && check(grid, found, row - 1, col - 1))
            dfs(grid, found, row - 1, col - 1);
        if (row + 1 < grid.length && col != 0 && check(grid, found, row + 1, col - 1))
            dfs(grid, found, row + 1, col - 1);
        if(row+1< grid.length && col+1<grid[row].length && check(grid, found, row+1, col+1)) dfs(grid, found, row+1, col+1);
    }
}