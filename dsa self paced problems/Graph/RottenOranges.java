import AkPackage.*;
import java.util.*;

public class RottenOranges {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new RottenOranges());
        while (!lines.isEmpty()) {
            int grid[][] = Graph.takeAdjacencyMatrixInput(lines);
            Graph.printAdjacencyMatrix(grid);
            System.out.println("Time take to rott all the oranges is: " + orangesRotting(grid));
        }
    }

    final static class Pair {
        public int row, col;

        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    public static int orangesRotting(int grid[][]) {
        // int rowLength = grid[0].length, colLength = grid.length;
        ArrayDeque<Pair> deq = new ArrayDeque<Pair>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                // 2 resembles the rotten oranges
                if (grid[row][col] == 2) {
                    // res[row][col] = 0;
                    deq.add(new Pair(row, col));
                }
            }
        }

        int time = 0, oldrottenTomatoes=deq.size(), newRottenTomatoes=0;
        while (!deq.isEmpty()) {
            Pair vertex = deq.poll();
            oldrottenTomatoes--;
            if (check(grid, vertex.row + 1, vertex.col)) {
                grid[vertex.row + 1][vertex.col] = 2; // making the orange rott
                deq.addLast(new Pair(vertex.row + 1, vertex.col));
                newRottenTomatoes++;
            }
            if (check(grid, vertex.row - 1, vertex.col)) {
                grid[vertex.row - 1][vertex.col] = 2; // making the orange rott
                newRottenTomatoes++;
                deq.addLast(new Pair(vertex.row - 1, vertex.col));
            }
            if (check(grid, vertex.row, vertex.col + 1)) {
                grid[vertex.row][vertex.col + 1] = 2; // making the orange rott
                newRottenTomatoes++;
                deq.addLast(new Pair(vertex.row, vertex.col + 1));
            }
            if (check(grid, vertex.row, vertex.col - 1)) {
                grid[vertex.row][vertex.col - 1] = 2; // making the orange rott
                newRottenTomatoes++;
                deq.addLast(new Pair(vertex.row, vertex.col - 1));
            }

            // when all the previously rotten tomatoes has done their job, new tomatoes will start to rott the new ones, which are not into the queue yet.
            if (oldrottenTomatoes == 0 && !deq.isEmpty()) {
                oldrottenTomatoes = newRottenTomatoes;
                newRottenTomatoes = 0;
                time++;
            }
        }

        return Arrays.stream(grid).filter(x -> Arrays.stream(x).filter(num -> num == 1).count() > 0).count() == 0 ? time
                : -1;
    }

    public static boolean check(int grid[][], int row, int col) {
        int rowLength = grid[0].length, colLength = grid.length;
        boolean ruc = row >= 0 && row < colLength, cuc = col >= 0 && col < rowLength;
        return ruc && cuc && grid[row][col] == 1;
    }
}