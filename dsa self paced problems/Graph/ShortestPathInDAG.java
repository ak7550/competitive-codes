import AkPackage.*;
import java.util.*;

public class ShortestPathInDAG {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ShortestPathInDAG());
        while (!lines.isEmpty()) {
            int adj[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For: " + Arrays.deepToString(adj));
            shortestPath(adj);
        }
    }

    public static int shortestPath(int adj[][]) {
        int dis[] = new int[adj.length];
        Arrays.fill(dis, Integer.MAX_VALUE);
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addLast(0);
        while (!ad.isEmpty()) {
            int vertex = ad.removeFirst();
            for (int u : adj[vertex]) {
                if (dis[u] == Integer.MAX_VALUE) {
                    dis[u] = Math.min(vertex - u + 1, dis[u]); //! doubt ==> u should have higher value, u - vertex should be there. ==> other than that, I doubt in the formula that is being applied.
                    ad.addLast(u);
                }
            }
        }

        return dis[adj.length - 1] == Integer.MAX_VALUE ? -1 : dis[adj.length - 1];

    }
}