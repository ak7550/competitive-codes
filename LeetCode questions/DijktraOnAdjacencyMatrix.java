import AkPackage.*;
import java.util.*;

public class DijktraOnAdjacencyMatrix {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new DijktraOnAdjacencyMatrix());
        while (!lines.isEmpty()) {
            int adj[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For the given: ");
            Graph.printAdjacencyMatrix(adj);
            int res[] = dijkstra(adj.length, adj);
            for (int i = 0; i < res.length; i++)
                System.out.println("To reach node " + i + " travelled distance is: " + res[i]);
        }
    }

    public static int[] dijkstra(int V, int adj[][]) {
        boolean finalized[] = new boolean[V];
        int dis[] = new int[V], totalFinalized = 0;
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0; // _we do not need to make any travel to reach from 0 to 0

        while (totalFinalized < V) {
            int source = -1;
            for (int j = 0; j < dis.length; j++)
                if (!finalized[j] && (source == -1 || dis[j] < dis[source]))
                    source = j;

            for (int j = 0; j < dis.length; j++)
                if (adj[source][j] != 0 && !finalized[j]) //-> if it is not finalized, then only mess with it
                    dis[j] = Math.min(dis[j], dis[source] + adj[source][j]);

            finalized[source] = true;
            totalFinalized++;
        }
        return dis;
    }
}