import AkPackage.*;
import java.util.*;

public class FindWhetherPathExist2 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FindWhetherPathExist2());
        while (!lines.isEmpty()) {
            int grid[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For ip: " + Arrays.deepToString(grid));
            System.out.println("op is: " + checkIfPathExist(grid));
        }
    }

    private static class Pair {
        int r, c;

        public Pair(int rw, int cl) {
            r = rw;
            c = cl;
        }
    }

    private static boolean checkIfPathExist(int grid[][]) {

        Queue<Pair> q = new LinkedList<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        boolean found = false;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    q.add(new Pair(r, c));
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            visited[pair.r][pair.c] = true;
            if (grid[pair.r][pair.c] == 2)
                return true;
            Pair left = new Pair(pair.r, pair.c - 1), right = new Pair(pair.r, pair.c + 1),
                    up = new Pair(pair.r - 1, pair.c), down = new Pair(pair.r + 1, pair.c);

            if (isPossible(left, visited, grid))
                q.add(left);
            if (isPossible(right, visited, grid))
                q.add(right);
            if (isPossible(up, visited, grid))
                q.add(up);
            if (isPossible(down, visited, grid))
                q.add(down);
        }

        return false;
    }

    private static boolean isPossible(Pair pair, boolean visted[][], int grid[][]) {
        return pair.r >= 0 && pair.c >= 0 &&
             pair.r < grid.length && pair.c < grid[0].length
                && grid[pair.r][pair.c] != 0 &&
                 !visted[pair.r][pair.c];
    }
}