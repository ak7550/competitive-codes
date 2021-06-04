import AkPackage.*;
import java.util.*;

public class RatMazeWithMultipleJumps {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new RatMazeWithMultipleJumps());
        while (!lines.isEmpty()) {
            int maze[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("\n\nFor the given input: ");
            Graph.printAdjacencyMatrix(maze);
            solve(maze);
        }
    }

    static class Pair {
        int row = Integer.MAX_VALUE, col = Integer.MAX_VALUE, val = Integer.MAX_VALUE;
    }

    public static void solve(int maze[][]) {
        int jump[][] = new int[maze.length][maze.length], sol[][] = new int[maze.length][maze.length];
        goToPos(jump, maze, 0, 0);
        System.out.println("\n\nJump array: ");
        Arrays.stream(jump).forEach(x -> System.out.println(Arrays.toString(x)));
        System.out.println("\n\nAnswer matrix is: ");
        if (jump[0][0] == -1)
            System.out.println(-1);
        else {
            sol[sol.length - 1][sol.length - 1] = 1;
            makeSoln(sol, jump, 0, 0);
            Arrays.stream(sol).forEach(x -> System.out.println(Arrays.toString(x)));
        }
    }

    public static void goToPos(int jump[][], int maze[][], int row, int col) {
        if (jump[row][col] != 0) // if jump contains something else that means we have reached to this node
                                 // before
            return;
        if (row == maze.length - 1 && col == maze.length - 1) { // reached to the target
            jump[row][col] = 0;
            return;
        }
        if (maze[row][col] == 0) { // 0 means mouse can't jump
            jump[row][col] = -1;
            return;
        }
        Pair minPair = new Pair();

        // going forward
        for (int i = 1; i <= maze[row][col] && (col + i) < maze.length; i++) {
            goToPos(jump, maze, row, col + i);
            if (jump[row][col + i] == -1) // -1 means we can't proceed through this path
                continue;
            if (minPair.val >= jump[row][col + i]) {
                minPair.val = jump[row][col + i];
                minPair.row = row;
                minPair.col = col + i;
            }
        }

        // going downward
        for (int i = 1; i <= maze[row][col] && (row + i) < maze.length; i++) {
            goToPos(jump, maze, row + i, col);
            if (jump[row + i][col] == -1)
                continue;
            if (minPair.val > jump[row + i][col]) {
                minPair.val = jump[row + i][col];
                minPair.row = row + i;
                minPair.col = col;
            }
        }

        if (minPair.val == Integer.MAX_VALUE) // the value has not updated so far, we can't reached to target through
                                              // this path
            jump[row][col] = -1;
        else
            jump[row][col] = minPair.val + 1; // as we can reach to the target jump indexed value has incremented by 1,
                                              // as it will take only 1 more jump from this to reach to the other node
                                              // that will help it to reach to the target
    }

    // jump tels u how much jump u need from the that node to reach to ur trgt
    public static void makeSoln(int sol[][], int jump[][], int row, int col) {
        if (row == sol.length - 1 && col == sol.length - 1) {
            sol[row][col] = 1;
            return; // reached to the trgt
        }
        if (jump[row][col] <= 0) // if it takes 0 jumos to reach the target and node is not the trgt that means
                                 // those bastards are lying to u.
            sol[row][col] = 0;
        else {
            sol[row][col] = 1; // -1 cases are handled before so this is definately an one
            Pair minP = new Pair();

            // row traversal
            for (int i = col + 1; i < sol.length; i++) {
                if (row == sol.length - 1 && i == sol.length - 1)
                    continue;
                if (jump[row][i] > 0 && jump[row][i] <= minP.val) {
                    minP.val = jump[row][i];
                    minP.row = row;
                    minP.col = i;
                }
                sol[row][i] = 0;
            }
            // col traversal
            for (int i = row + 1; i < sol.length; i++) {
                if (i == sol.length - 1 && col == sol.length - 1)
                    continue;
                if (jump[i][col] > 0 && jump[i][col] < minP.val) {
                    minP.val = jump[i][col];
                    minP.row = i;
                    minP.col = col;
                }
                sol[i][col] = 0;
            }
            // finally update the only one
            if (minP.val != Integer.MAX_VALUE) { // the value has updated
                sol[minP.row][minP.col] = 1;
                makeSoln(sol, jump, minP.row, minP.col);
            }
        }
    }
}