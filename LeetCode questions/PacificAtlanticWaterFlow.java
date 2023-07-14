import AkPackage.*;
import java.util.*;


public class PacificAtlanticWaterFlow {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new PacificAtlanticWaterFlow());
        while (!lines.isEmpty()) {
            int heights[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For ip: " + Arrays.deepToString(heights));
            System.out.println("Ans: " + solve(heights));
        }
    }

    private static List<List<Integer>> solve(int[][] heights) {
        int pacific[][] = getGrid(heights, 0, 0),
                atlantic[][] = getGrid(heights, heights.length - 1, heights[0].length - 1);

        List<List<Integer>> ans = new LinkedList<>();
        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                if (pacific[r][c] == 1 && atlantic[r][c] == 1) {
                    LinkedList<Integer> aa = new LinkedList<>();
                    aa.add(r);
                    aa.add(c);
                    ans.add(aa);
                }
            }
        }
        return ans;
    }

    private static int[][] getGrid(int[][] heights, int row, int col) {
        int visited[][] = new int[heights.length][heights[0].length];

        for (int c = 0; c < heights[0].length; c++) {
            dfs(heights, visited, row, c);
        }
        for (int c = 0; c < heights.length; c++) {
            dfs(heights, visited, c, col);
        }

        return visited;
    }

    private static int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    private static void dfs(int[][] heights, int[][] visited, int row, int col) {
        visited[row][col] = 1;

        for (int[] direc : directions) {
            int r = row + direc[0], c = col + direc[1];

            if (r < 0 || c < 0 || r >= heights.length || c >= heights[0].length)
                continue;

            if (heights[row][col] <= heights[r][c] && visited[r][c] == 0) {
                dfs(heights, visited, r, c);
            }
        }
    }
}