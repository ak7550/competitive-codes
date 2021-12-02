import AkPackage.*;
import java.util.*;

//*FLOYD WARSHALL ==> all source minimum shortest path, dynamic programming approach
//=> floyd warshall algorithm doesnot work with -ve edged graphs
public class FloydWarshall {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FloydWarshall());
        while (!lines.isEmpty()) {
            int adj[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For the given: ");
            Graph.printAdjacencyMatrix(adj);
            adj = floydWarshall(adj);
            System.out.println("minimum shortest distance matrix: ");
            Graph.printAdjacencyMatrix(adj);
        }
    }

    public static int[][] floydWarshall(int adj[][]) {

        for (int k = 0; k < adj.length; k++) {
            for (int u = 0; u < adj.length; u++) { // -> wish to find the shrtest possible way to reach v from u
                for (int v = 0; v < adj.length; v++) {
                    if (adj[u][k] == -1 || adj[k][v] == -1) // _ -1 means no path in between
                        continue;
                    if (adj[u][v] == -1)
                        adj[u][v] = Integer.MAX_VALUE;

                    adj[u][v] = Math.min(adj[u][v], adj[u][k] + adj[k][v]);
                }
            }
        }
        return adj; // this is not an adjacency matrix anymore, now it represents the shortest path that needs to be followed to reach v from u.
    }
}