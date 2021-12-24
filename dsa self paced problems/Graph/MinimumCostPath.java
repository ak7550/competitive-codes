import AkPackage.*;
import java.util.*;
// tough question
public class MinimumCostPath {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MinimumCostPath());
        while (!lines.isEmpty()) {
            int grid[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For the given grid: ");
            Graph.printAdjacencyMatrix(grid);
            System.out.println("Minimum cost from source to the end is: " + minimumCostPath(grid) + "\n");
        }
    }

    static class Pair {
        public int row, col;

        public Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    // using pure dijkstra concept
    public static int minimumCostPath(int[][] grid) {
        int res[][] = new int[grid.length][grid.length]; // res stores the value of minimum cost that needs to reach to (row, col) from (0, 0)
        Arrays.stream(res).forEach(x -> Arrays.fill(x, Integer.MAX_VALUE)); // initially considering it needs infinity cost to reach all of the verices
        boolean finalised[][] = new boolean[grid.length][grid.length];
        // int finalisedCount = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> res[a.row][a.col] - res[b.row][b.col]);
        res[0][0]=grid[0][0];
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.row + 1 < grid.length && !finalised[p.row + 1][p.col])
                relax(p.row + 1, p.col, res, grid, pq, p);
            if (p.row - 1 >= 0 && !finalised[p.row - 1][p.col])
                relax(p.row - 1, p.col, res, grid, pq, p);
            if (p.col + 1 < grid.length && !finalised[p.row][p.col + 1])
                relax(p.row, p.col + 1, res, grid, pq, p);
            if (p.col - 1 >= 0 && !finalised[p.row][p.col - 1])
                relax(p.row, p.col - 1, res, grid, pq, p);
            finalised[p.row][p.col] = true;
        }

        return res[grid.length - 1][grid.length - 1];
    }

    public static void relax(int row, int col, int res[][], int grid[][], PriorityQueue<Pair> pq, Pair p) {
        if (res[p.row][p.col] + grid[row][col] < res[row][col]) {
            res[row][col] = res[p.row][p.col] + grid[row][col];
            pq.add(new Pair(row, col));
        }
    }

}