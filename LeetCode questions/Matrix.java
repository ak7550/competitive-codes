import AkPackage.*;
import java.util.*;

//docs: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/612/week-5-july-29th-july-31st/3831/
public class Matrix {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new Matrix());
        while (!lines.isEmpty()) {
            System.out.println();
            int mat[][] = Graph.takeAdjacencyMatrixInput(lines);
            Graph.printAdjacencyMatrix(mat);
            int update[][] = updateMatrix(mat);
            System.out.println();
            Graph.printAdjacencyMatrix(update);
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        int update[][] = new int[mat.length][];
        boolean callStack[][] = new boolean[mat.length][];

        for (int i = 0; i < update.length; i++) {
            update[i] = new int[mat[0].length];
            callStack[i] = new boolean[mat[0].length];
            Arrays.fill(update[i], Integer.MAX_VALUE);
        }

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                if (update[row][col] == Integer.MAX_VALUE) // have not traversed so far..
                {
                    if (mat[row][col] == 0)
                        update[row][col] = 0;
                    else {
                        callStack[row][col] = true;
                        update(mat, update, callStack, row, col);
                        callStack[row][col] = false;
                    }
                }
            }
        }
        return update;
    }

    public static int update(int[][] mat, int[][] update, boolean[][] callStack, int row, int col) {
        if (row < 0 || row == mat.length || col < 0 || col == mat[row].length)
            return Integer.MAX_VALUE;

        if (mat[row][col] == 0) {
            update[row][col] = 0;
            return 0;
        }

        if (update[row][col] != Integer.MAX_VALUE)
            return update[row][col];

        // traverse through the 4 direction
        if (row-1>=0 && row-1< mat.length && col>=0 && col<mat[row].length && !callStack[row - 1][col]) {
            callStack[row - 1][col] = true;
            update[row][col] = Math.min(update[row][col], update(mat, update, callStack, row - 1, col));
            callStack[row - 1][col] = false;
        }
        if (row+1 >= 0 && row +1< mat.length && col >= 0 && col < mat[row].length&& !callStack[row + 1][col]) {
            callStack[row + 1][col] = true;
            update[row][col] = Math.min(update[row][col], update(mat, update, callStack, row + 1, col));
            callStack[row + 1][col] = false;
        }
        if (row >= 0 && row < mat.length && col-1 >= 0 && col-1 < mat[row].length && !callStack[row][col - 1]) {
            callStack[row][col - 1] = true;
            update[row][col] = Math.min(update[row][col], update(mat, update, callStack, row, col - 1));
            callStack[row][col - 1] = false;
        }
        if (row >= 0 && row < mat.length && col+1 >= 0 && col+1 < mat[row].length && !callStack[row][col + 1]) {
            callStack[row][col + 1] = true;
            update[row][col] = Math.min(update[row][col], update(mat, update, callStack, row, col + 1));
            callStack[row][col + 1] = false;
        }

        update[row][col] += 1;
        return update[row][col];

    }

}