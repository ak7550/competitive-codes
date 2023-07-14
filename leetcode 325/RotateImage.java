import AkPackage.*;
import java.util.*;


public class RotateImage {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new RotateImage());
        while (!lines.isEmpty()) {
            int matrix[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For ip: " + Arrays.deepToString(matrix));
            rorateImage(matrix);
            System.out.println("op: " + Arrays.deepToString(matrix));
        }
    }

    private static void rorateImage(int matrix[][]) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                int tem = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = tem;
            }
        }
    }
}