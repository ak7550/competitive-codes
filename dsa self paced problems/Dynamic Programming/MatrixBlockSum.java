import AkPackage.*;
import java.util.*;


public class MatrixBlockSum {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MatrixBlockSum());
        while (!lines.isEmpty()) {
            int mat[][] = Graph.takeAdjacencyMatrixInput(lines), k=Integer.parseInt(lines.remove(0));
            System.out.println("For given: " + Arrays.deepToString(mat));
            System.out.println("Matric block sum is: " + Arrays.deepToString(matrixBlockSum(mat, k)));
        }
    }

    public static int[][] matrixBlockSum(int mat[][], int k) {
        int sum[][] = new int[mat.length][mat[0].length], ans[][] = new int[mat.length][mat[0].length];

        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                sum[r][c] = mat[r][c];
                sum[r][c] += (c - 1 >= 0) ? sum[r][c - 1] : 0;
                sum[r][c] += (r - 1 >= 0) ? sum[r - 1][c] : 0;
            }
        }

        for (int r = 0; r < mat.length; r++) {
            int rd = Math.min(mat.length - 1, r + k), ru = Math.max(0, r - k);

            for (int c = 0; c < mat[0].length; c++) {
                int cl = Math.max(0, c - k), cr = Math.min(mat[0].length - 1, c + k);

                int val = sum[rd][cr];
                val -= (ru - 1 >= 0) ? sum[ru - 1][cr] : 0;
                val -= (cl - 1 >= 0) ? sum[rd][cl - 1] : 0;
                val += (ru - 1 >= 0 && cl - 1 >= 0) ? sum[ru - 1][cl - 1] : 0;

                mat[r][c] = val;
            }
        }

        return mat;
    }
}