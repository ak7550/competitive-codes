import AkPackage.*;
import java.util.*;

public class DijstrasAlgoOnAdjacencyMatrix {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new DijstrasAlgoOnAdjacencyMatrix());
        while (!lines.isEmpty()) {
            int adj[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For the given input: ");
            Graph.printAdjacencyMatrix(adj);
            System.out.println("The ans is: " + dijstra(adj));
        }
    }

    public static int[] dijstra(int adj[][]) {
        int res[] = new int[adj.length];
        Arrays.fill(res, Integer.MAX_VALUE);
        int source = 0;
        res[source] = 0;
        boolean finalised[] = new boolean[adj.length];
        for (int i = 0; i < adj.length; i++) {
            int u = -1;
            for (int j = 0; j < finalised.length; j++) {
                if (!finalised[j] && (u == -1 || res[u] > res[j]))
                    u = j;
            }
            // u is the vertex that has not finalised yet, holding the least weight from
            // source;
            finalised[u] = true;
            for (int j = 0; j < adj[u].length; j++) {
                // relax operation
                if (!finalised[j] && adj[u][j] != 0)
                    relax(j, u, adj, res);
            }
        }
        return res;
    }
    // specifically made to understand the actual relax operation
    public static void relax(int j, int u, int adj[][], int res[]) {
        if(res[j] > res[u] + adj[u][j])
            res[j] = res[u] + adj[u][j];
    }
}