import AkPackage.*;
import java.util.*;
import java.util.stream.Stream;

public class DistanceTheNearestCellHaving1 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new DistanceTheNearestCellHaving1());
        while (!lines.isEmpty()) {
            int grid[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For the given input: ");
            Graph.printAdjacencyMatrix(grid);
            System.out.println("\nThe output matrix is:");
            Graph.printAdjacencyMatrix(nearest(grid));
            System.out.println("\n\n\n");
        }
    }

    public static class Pair {
        public int row, col;

        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    public static int[][] nearest(int grid[][]) {
        int rowLength = grid[0].length, colLength = grid.length;
        // boolean found[][] = new boolean[colLength][rowLength];
        int res[][] = new int[colLength][rowLength];
        Arrays.stream(res).forEach(x -> Arrays.fill(x, Integer.MAX_VALUE)); // will tell which are the points unvisited
                                                                            // till now

        // search for all the sources and put them inside the queue.
        ArrayDeque<Pair> deq = new ArrayDeque<Pair>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    res[row][col] = 0;
                    deq.add(new Pair(row, col));
                }
            }
        }

        while (!deq.isEmpty()) {
            Pair vertex = deq.pollFirst();
            if (check(vertex.row + 1, vertex.col, rowLength, colLength, res)) {
                deq.add(new Pair(vertex.row + 1, vertex.col));
                res[vertex.row + 1][vertex.col] = res[vertex.row][vertex.col] + 1;
            }
            if (check(vertex.row - 1, vertex.col, rowLength, colLength, res)) {
                deq.add(new Pair(vertex.row - 1, vertex.col));
                res[vertex.row - 1][vertex.col] = res[vertex.row][vertex.col] + 1;
            }
            if (check(vertex.row, vertex.col + 1, rowLength, colLength, res)) {
                deq.add(new Pair(vertex.row, vertex.col + 1));
                res[vertex.row][vertex.col + 1] = res[vertex.row][vertex.col] + 1;
            }
            if (check(vertex.row, vertex.col - 1, rowLength, colLength, res)) {
                deq.add(new Pair(vertex.row, vertex.col - 1));
                res[vertex.row][vertex.col - 1] = res[vertex.row][vertex.col] + 1;
            }
        }

        return res;
    }

    public static boolean check(int row, int col, int rowLength, int colLength, int res[][]) {
        boolean ruc = row >= 0 && row < colLength, cuc = col >= 0 && col < rowLength;
        return ruc && cuc && res[row][col] == Integer.MAX_VALUE;
        // if res overwrites to something, that means that is the least value, according
        // to the property of bfs
    }
}