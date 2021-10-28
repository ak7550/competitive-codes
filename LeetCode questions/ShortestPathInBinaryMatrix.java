import AkPackage.*;
import java.util.*;

public class ShortestPathInBinaryMatrix {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ShortestPathInBinaryMatrix());
        while (!lines.isEmpty()) {
            int grid[][] = Graph.takeAdjacencyMatrixInput(lines);
            Graph.printAdjacencyMatrix(grid);
            System.out.println("Length of the shortest path is: " + shortestPath(grid));
        }
    }

    static class Pair {
        int row, col;

        public Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    public static int shortestPath(int grid[][]) {
        boolean visited[][] = new boolean[grid.length][grid.length];
        // Arrays.stream(visited).forEach(x -> Arrays.fill(x, -1));
        Queue<Pair> q = new LinkedList<>();
        if (grid[0][0] == 1 || grid[grid.length-1][grid.length-1]==1)
            return -1;
        q.add(new Pair(0, 0));
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair pair = q.poll();
                visited[pair.row][pair.col] = true;
                if (pair.row == grid.length - 1 && pair.col == grid.length - 1)
                    return count;
                // now traverse in all the possible direction
                for (int r = -1; r <= 1; r++) {
                    for (int c = -1; c <= 1; c++) {
                        if ((r != 0 || c != 0) && check(pair.row + r, pair.col + c, grid.length)
                                && !visited[pair.row + r][pair.col + c] &&
                                grid[pair.row + r][pair.col + c] != 1)
                            q.add(new Pair(pair.row + r, pair.col + c));
                    }
                }

                count++;
            }

        }
        return -1;

    }

    public static boolean check(int row, int col, int length) {
        return row >= 0 && row < length && col >= 0 && col < length;
    }

}