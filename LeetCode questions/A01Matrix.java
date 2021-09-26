import AkPackage.*;
import java.util.*;
//*wrong solution
public class A01Matrix {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new A01Matrix());
        while (!lines.isEmpty()) {
            int mat[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For given: ");
            Graph.printAdjacencyMatrix(mat);
            System.out.println("Minimum distance is: ");
            Graph.printAdjacencyMatrix(updateMatrix(mat));
        }
    }

    public static int[][] updateMatrix(int mat[][]) {
        int dis[][] = new int[mat.length][mat[0].length];
        // Arrays.stream(mat).forEach(x -> Arrays.fill(x, Integer.MAX_VALUE));
        for (int r = 0; r < mat.length; r++)
            for (int c = 0; c < mat[0].length; c++)
                if (mat[r][c] == 1)
                    dis[r][c] = recurr(mat, dis, r, c);
        return dis;
    }

    public static int recurr(int mat[][], int dis[][], int row, int col) {
        if (mat[row][col] == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        if (dis[row][col] != 0)
            return dis[row][col];
        if (row - 1 >= 0 && dis[row - 1][col] == 0)
            recurr(mat, dis, row - 1, col);
        if (row - 1 >= 0)
            min = Math.min(min, dis[row - 1][col]);
        if (min == 0) {
            dis[row][col] = min + 1;
            return dis[row][col];
        }

        if (row + 1 < mat.length && dis[row + 1][col] == 0)
            recurr(mat, dis, row + 1, col);
        if (row + 1 < mat.length)
            min = Math.min(min, dis[row + 1][col]);
        if (min == 0) {
            dis[row][col] = min + 1;
            return dis[row][col];
        }

        if (col - 1 >= 0 && dis[row][col - 1] == 0)
            recurr(mat, dis, row, col - 1);
        if (col - 1 >= 0)
            min = Math.min(min, dis[row][col - 1]);
        if (min == 0) {
            dis[row][col] = min + 1;
            return dis[row][col];
        }

        if (col + 1 < mat[0].length && dis[row][col + 1] == 0)
            recurr(mat, dis, row, col + 1);

        if (col + 1 < mat[0].length)
            min = Math.min(min, dis[row][col + 1]);

        dis[row][col] = min + 1;
        return dis[row][col];
    }
}