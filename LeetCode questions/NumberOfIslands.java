import AkPackage.*;
import java.util.*;

public class NumberOfIslands {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new NumberOfIslands());
        while (!lines.isEmpty()) {
            int mat[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For: ");
            Graph.printAdjacencyMatrix(mat);
            System.out.println("Number of islands: " + countIslands(mat));
        }
    }

    public static int countIslands(int mat[][]) {
        int count = 0;
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++)
                if (mat[r][c] == 1) {
                    count++;
                    dfs(new int[] { r, c }, mat);
                }
        }
        return count;
    }

    public static void dfs(int pos[], int[][] mat) {
        mat[pos[0]][pos[1]] = 2;

        int dirs[][] = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int dir[] : dirs) {
            int row = pos[0] + dir[0], col = pos[1] + dir[1];
            if (check(row, col, mat))
                dfs(new int[] { row, col }, mat);
        }
    }

    public static boolean check(int r, int c, int[][] mat) {
        return r >= 0 && r < mat.length && c >= 0 && c < mat[0].length && mat[r][c] == 1;
    }
}