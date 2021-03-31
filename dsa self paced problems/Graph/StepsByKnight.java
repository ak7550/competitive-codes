import AkPackage.*;
import java.util.*;

public class StepsByKnight {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new StepsByKnight());
        while (!lines.isEmpty()) {
            int N = Integer.parseInt(lines.remove(0)), knightPos[] = InputOutput.arrayFromString(lines.remove(0)),
                    targetPos[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("Knights initial position: " + Arrays.toString(knightPos));
            System.out.println("Target position: " + Arrays.toString(targetPos));
            System.out.println("Minimum steps that are necessary to take by the knight is: "
                    + minStepToReachTarget(knightPos, targetPos, N));
        }
    }

    static class Pair {

        public int row, col;

        public Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    public static boolean check(int row, int col, int N, boolean found[][]) {
        return row >= 1 && row <= N && col <= N && col >= 1 && !found[row][col];
    }

    public static int minStepToReachTarget(int knightPos[], int targetPos[], int N) {
        int count = 0, oldPositions = 1, newPositions = 0;
        boolean found[][] = new boolean[N + 1][N + 1];
        ArrayDeque<Pair> ad = new ArrayDeque<Pair>();
        ad.add(new Pair(knightPos[1], knightPos[0]));
        found[knightPos[1]][knightPos[0]] = true;
        while (!ad.isEmpty()) {
            Pair pair = ad.poll();
            oldPositions--;

            if (pair.row == targetPos[1] && pair.col == targetPos[0])
                return count;

            if (check(pair.row + 2, pair.col + 1, N, found)) {
                ad.add(new Pair(pair.row + 2, pair.col + 1));
                found[pair.row + 2][pair.col + 1] = true;
                newPositions++;
            }
            if (check(pair.row + 2, pair.col - 1, N, found)) {
                newPositions++;
                found[pair.row + 2][pair.col - 1] = true;
                ad.add(new Pair(pair.row + 2, pair.col - 1));
            }
            if (check(pair.row - 2, pair.col - 1, N, found)) {
                newPositions++;
                found[pair.row - 2][pair.col - 1] = true;
                ad.add(new Pair(pair.row - 2, pair.col - 1));
            }
            if (check(pair.row - 2, pair.col + 1, N, found)) {
                newPositions++;
                found[pair.row - 2][pair.col + 1] = true;
                ad.add(new Pair(pair.row - 2, pair.col + 1));
            }
            if (check(pair.row + 1, pair.col + 2, N, found)) {
                newPositions++;
                found[pair.row + 1][pair.col + 2] = true;
                ad.add(new Pair(pair.row + 1, pair.col + 2));
            }
            if (check(pair.row + 1, pair.col - 2, N, found)) {
                newPositions++;
                found[pair.row + 1][pair.col - 2] = true;
                ad.add(new Pair(pair.row + 1, pair.col - 2));
            }
            if (check(pair.row - 1, pair.col - 2, N, found)) {
                newPositions++;
                found[pair.row - 1][pair.col - 2] = true;
                ad.add(new Pair(pair.row - 1, pair.col - 2));
            }
            if (check(pair.row - 1, pair.col + 2, N, found)) {
                newPositions++;
                found[pair.row - 1][pair.col + 2] = true;
                ad.add(new Pair(pair.row - 1, pair.col + 2));
            }
            if (oldPositions == 0) {
                count++;
                oldPositions = newPositions;
                newPositions = 0;
            }

        }
        return count;
    }
}