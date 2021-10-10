import AkPackage.*;
import java.util.*;

public class DungeonGame {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new DungeonGame());
        while (!lines.isEmpty()) {
            int grid[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For input: " + Arrays.deepToString(grid));
            System.out.println("Minimum health required is: " + calculateMinimumHP(grid));
        }
    }

    public static int calculateMinimumHP(int grid[][]) {
        int dp[][] = new int[grid.length][grid[0].length];

        for (int x[] : dp)
            Arrays.fill(x, Integer.MAX_VALUE);

        // dp[row][col] will tell, what is the minimum blood is needed to reach to the
        // end from the (row, col) shell.
        int ans = dfs(grid, dp, 0, 0);
        System.out.println(Arrays.deepToString(dp));
        return ans;
    }

    static int dfs(int grid[][], int dp[][], int row, int col) {
        if (row >= grid.length || col >= grid[0].length || grid[row][col] == 0)
            return Integer.MAX_VALUE;
        if (dp[row][col] != Integer.MAX_VALUE)
            return dp[row][col];
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            dp[row][col] = Math.max(1, 1 - grid[row][col]);
            return dp[row][col];
        }

        dp[row][col] = Math.min(dfs(grid, dp, row + 1, col), dfs(grid, dp, row, col + 1))
                + (grid[row][col] < 0 ? 1 - grid[row][col] : grid[row][col]);

        return dp[row][col];
    }
}