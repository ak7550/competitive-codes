import AkPackage.*;
import java.util.*;


public class MakingALargeIsland {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MakingALargeIsland());
        while (!lines.isEmpty()) {
            int grid[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("for the given: ");
            Graph.printAdjacencyMatrix(grid);
            System.out.println("Size of the largest array will be: " + largestIsland(grid));
        }
    }

    public static int largestIsland(int grid[][]) {
        int dp[][] = new int[grid.length][];
        Arrays.stream(dp).forEach(x -> x = new int[grid[0].length]);
        int max = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (dp[row][col] == 0) // not traversed, at the same time it is also telling us that how long we can proceed through this node, even though it may contain 0 value init.
                {
                    max = Math.max(max, dfs(grid, dp, row, col, grid[row][col] == 0)); // if grid[row][col] = 0, then cheat at very first node
                } else
                    max = Math.max(max, dp[row][col]);
            }
        }
        return max;
    }

    public static int dfs(int grid[][], int dp[][], int row, int col, boolean cheated) {

        return 0;
    }
}