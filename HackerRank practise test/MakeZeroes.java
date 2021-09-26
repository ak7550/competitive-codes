import AkPackage.*;
import java.util.*;


public class MakeZeroes {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MakeZeroes());
        while (!lines.isEmpty()) {
            int matrix[][] = Graph.takeAdjacencyMatrixInput(lines);

            System.out.println("For the given: \n" + Arrays.deepToString(matrix));
            makeZeroes(matrix);
        }
    }

    public static void makeZeroes(int matrix[][]) {
        boolean visited[][] = new boolean[matrix.length][matrix[0].length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (!visited[r][c] && matrix[r][c] == 0) {
                    matrix[r][c] = 0;
                    if (r - 1 >= 0) {
                        visited[r - 1][c] = true;
                        matrix[r][c] += matrix[r - 1][c];
                        matrix[r - 1][c] = 0;
                    }
                    if (r + 1 < matrix.length) {
                        visited[r + 1][c] = true;
                        matrix[r][c] += matrix[r + 1][c];
                        matrix[r + 1][c] = 0;
                    }
                    if (c - 1 >= 0) {
                        visited[r][c - 1] = true;
                        matrix[r][c] += matrix[r][c - 1];
                        matrix[r][c - 1] = 0;
                    }
                    if (c + 1 < matrix[0].length) {
                        visited[r][c + 1] = true;
                        matrix[r][c] += matrix[r][c + 1];
                        matrix[r][c + 1] = 0;
                    }
                }
                visited[r][c] = true;
            }
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++)
                System.out.print(matrix[r][c] + " ");
            System.out.println();
        }
    }
}