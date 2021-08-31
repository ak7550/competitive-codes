import AkPackage.*;
import java.util.*;

public class NumberOfPallindromicPath {
    static class Path {
        StringBuilder right, bottom;
    }

    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new NumberOfPallindromicPath());
        while (!lines.isEmpty()) {
            int mat[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For the given input: ");
            System.out.println(Arrays.deepToString(mat));
            System.out.println("Ans is: " + countPath(mat));
        }
    }

    static int count;
    static Path arr[][];

    public static int countPath(int mat[][]) {
        count = 0;
        if (mat[0][0] != mat[mat.length - 1][mat[0].length - 1])
            return 0;
        arr = new Path[mat.length + 1][mat[0].length + 1];
        // recurr(mat, 0, 0, new StringBuilder(0));
        recurr2(mat, 0, 0, new StringBuilder());
        return count;
    }

    public static StringBuilder recurr2(int mat[][], int row, int col, StringBuilder str) {
        if (row >= mat.length || col >= mat[0].length)
            return null;

        str.append(mat[row][col]);

        if (arr[row][col].bottom == null)
            arr[row][col].bottom = recurr2(mat, row + 1, col, str);
        count += checkPal(str, arr[row][col].bottom) ? 1 : 0;

        if (arr[row][col].right == null)
            arr[row][col].right = recurr2(mat, row, col + 1, str);
        count += checkPal(str, arr[row][col].right) ? 1 : 0;

        str.deleteCharAt(str.length()-1);
        return 
    }

    public static void recurr(int mat[][], int row, int col, StringBuilder str) {
        if (row >= mat.length || col >= mat[0].length)
            return;
        str.append(mat[row][col]);
        if (row == mat.length - 1 && col == mat[0].length - 1) {
            count += str.toString().compareTo(str.reverse().toString()) == 0 ? 1 : 0;
            str.reverse();
            System.out.println(str);
        } else {
            recurr(mat, row + 1, col, str);
            recurr(mat, row, col + 1, str);
        }
        str.deleteCharAt(str.length() - 1);
    }
}