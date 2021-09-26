import AkPackage.*;
import java.util.*;


public class Triangle {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new Triangle());
        while (!lines.isEmpty()) {
            int row = Integer.parseInt(lines.remove(0));
            List<List<Integer>> triangle = new ArrayList<>();
            for (int i = 0; i < row; i++)
                triangle.add(InputOutput.ArrayListFromString(lines.remove(0)));
            System.out.println("For I/P: ");
            triangle.forEach(System.out::println);
            System.out.println("Minimum cost path: " + mminimumPath(triangle));
        }
    }

    public static int mminimumPath(List<List<Integer>> triangle) {
        int dp[][] = new int[triangle.size()][triangle.size()];
        recurr(triangle, 0, 0, dp);
        return dp[0][0];
    }

    public static void recurr(List<List<Integer>> triangle, int row, int col, int dp[][]) {
        if (row == triangle.size())
            return;
        if (col == triangle.get(row).size())
            return;
        if (dp[row][col] != 0)
            return;

        recurr(triangle, row + 1, col, dp);
        recurr(triangle, row + 1, col + 1, dp);
        int min = Integer.MAX_VALUE;

        if (row + 1 < triangle.size()) {
            min = Math.min(min, dp[row + 1][col]);
            if (col + 1 < triangle.get(row+1).size())
                min = Math.min(min, dp[row + 1][col + 1]);
        }

        dp[row][col] = triangle.get(row).get(col) + (min == Integer.MAX_VALUE ? 0 : min);

    }
}