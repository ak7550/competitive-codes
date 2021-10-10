import AkPackage.*;
import java.util.*;

public class IslandPerimeter {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new IslandPerimeter());
        while (!lines.isEmpty()) {
            int grid[][] = Graph.takeAdjacencyMatrixInput(lines);
            Graph.printAdjacencyMatrix(grid);
            System.out.println("Island Perimeter: " + islandPerimeter(grid));
        }
    }

    static int count;

    public static int islandPerimeter(int grid[][]) {
        count = 0;
        boolean found[][] = new boolean[grid.length][grid[0].length];

        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[0].length; c++)
                if (!found[r][c] && grid[r][c] == 1)
                    dfs(grid, found, new int[] { r, c });
        return count;
    }

    public static void dfs(int grid[][], boolean found[][], int pos[]) {
        if (!inRange(grid, pos[0], pos[1]) || found[pos[0]][pos[1]])
            return;

        found[pos[0]][pos[1]] = true;

        count += countExposed(grid, pos);
        dfs(grid, found, new int[] { pos[0] + 1, pos[1] });
        dfs(grid, found, new int[] { pos[0] - 1, pos[1] });
        dfs(grid, found, new int[] { pos[0], pos[1] + 1 });
        dfs(grid, found, new int[] { pos[0], pos[1] - 1 });
    }

    public static int countExposed(int grid[][], int pos[]) {
        int left = (pos[1] < 1 || grid[pos[0]][pos[1] - 1] == 0) ? 1 : 0,
            right = (pos[1] + 1 >= grid[0].length || grid[pos[0]][pos[1] + 1] == 0) ? 1 : 0,
            up = (pos[0] < 1 || grid[pos[0] - 1][pos[1]] == 0) ? 1 : 0,
            down = (pos[0] + 1 >= grid.length || grid[pos[0] + 1][pos[1]] == 0) ? 1 : 0;
        return left + right + up + down;
    }

    public static boolean inRange(int grid[][], int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1;
    }

    //_without dfs implementation
    public int islandPerimeter2(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++;  //-> count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1)
                        neighbours++;  //-> count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1)
                        neighbours++; //-> count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }

}