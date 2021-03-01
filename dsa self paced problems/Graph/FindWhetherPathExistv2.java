import AkPackage.*;

import java.util.*;

public class FindWhetherPathExistv2 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FindWhetherPathExistv2());
        while (!lines.isEmpty()) {
            int adj[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For the given adjacency matrix: ");
            // int line[] = InputOutput.arrayFromString(lines.remove(0)), source = line[0],
            // dest = line[1];
            Graph.printAdjacencyMatrix(adj);
            System.out.println(
                    "There exists " + (checkPath(adj) ? "" : "no ") + "path between " + "source " + "and " + "dest");
        }
    }

    static class Path {
        boolean source = false, dest = false;
    }

    // You can traverse up, down, right and left.
    public static boolean checkPath(int adj[][]) {
        Path path = new Path();
        boolean found[] = new boolean[adj[0].length * adj.length];
        for (int row = 0; row < adj.length; row++) {
            for (int col = 0; col < adj[row].length; col++) {
                if ((path.source && !path.dest) || (path.dest && !path.source))
                    return false;
                if (adj[row][col] != 0 && (check(adj, row, col, path) || path.source || path.dest)
                        && dfs(adj, row, col, path, found))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(int adj[][], int row, int col, Path path, boolean found[]) {
        if (check(adj, row, col, path))
            return true;
        found[adj[row].length * row + col] = true;
        if (row > 0 && adj[row - 1][col] != 0 && !checkFound(adj, row - 1, col, found)
                && dfs(adj, row - 1, col, path, found))
            return true;
        if (row + 1 < adj.length && adj[row + 1][col] != 0 && !checkFound(adj, row + 1, col, found)
                && dfs(adj, row + 1, col, path, found))
            return true;
        if (col > 0 && adj[row][col - 1] != 0 && !checkFound(adj, row, col - 1, found)
                && dfs(adj, row, col - 1, path, found))
            return true;
        if (col + 1 < adj[row].length && adj[row][col + 1] != 0 && !checkFound(adj, row, col + 1, found)
                && dfs(adj, row, col + 1, path, found))
            return true;
        return false;
    }

    public static boolean checkFound(int adj[][], int row, int col, boolean found[]) {
        return found[adj[row].length * row + col];
    }

    public static boolean check(int adj[][], int row, int col, Path path) {
        if (adj[row][col] == 1) {
            path.source = true;
            return path.dest;
        }
        if (adj[row][col] == 2) {
            path.dest = true;
            return path.source;
        }
        return false;
    }
}