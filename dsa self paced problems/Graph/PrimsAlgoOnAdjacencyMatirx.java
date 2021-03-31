import AkPackage.*;
import java.util.*;

public class PrimsAlgoOnAdjacencyMatirx {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new PrimsAlgoOnAdjacencyMatirx());
        while (!lines.isEmpty()) {
            int adj[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For the given input:");
            Graph.printAdjacencyMatrix(adj);
            System.out.println("Sum of minimum spanning tree is: " + primsMinimumSpanningTree(adj));
        }
    }

    public static int primsMinimumSpanningTree(int adj[][]) {
        int res = 0, key[] = new int[adj.length];
        boolean found[] = new boolean[adj.length];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        for (int i = 0; i < found.length; i++) {
            int u = -1;
            // loop to take the minimum value
            for (int j = 0; j < found.length; j++) {
                if (!found[j] && (u == -1 || key[u] > key[j]))
                    u = j;
            }
            // u is currently storing the not visisted yet minimum edge vertex
            res += key[u];
            found[u] = true;
            // loop to update the key array
            for (int j = 0; j < found.length; j++) {
                if (!found[j] && adj[u][j] != 0)
                    key[j] = Math.min(key[j], adj[u][j]);
            }
        }
        return res;
    }
}