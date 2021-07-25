import AkPackage.*;
import java.util.*;

//* tough question

public class ArticulationPoint {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ArticulationPoint());
        while (!lines.isEmpty()) {
            Graph.InnerGraph<Integer> ig = Graph.takeAdjacencyListInputUNDIRECTED(lines);
            System.out.println("For the given input: ");
            Graph.printAdjacencyList(ig.adjacencyList);
            System.out.println("Articulation points are: " + findArticulationPoint(ig.adjacencyList, ig.vertices));
        }
    }

    static int discoveryCount;
    static ArrayList<Integer> pts;

    public static ArrayList<Integer> findArticulationPoint(ArrayList<ArrayList<Integer>> adj, int V) {
        pts = new ArrayList<Integer>();
        int low[] = new int[V], discovery[] = new int[V], source = 0;
        boolean found[] = new boolean[V];
        discoveryCount = 1;
        dfs1(adj, discovery, low, found, source, -1);
        // Arrays.fill(low, Integer.MAX_VALUE);
        low[source] = discovery[source];
        return pts;
    }

    public static void dfs1(ArrayList<ArrayList<Integer>> adj, int discovery[], int low[], boolean found[], int vertex,
            int parent) {
        found[vertex] = true;
        low[vertex] = discovery[vertex] = discoveryCount++;
        int children = 0;
        for (int v : adj.get(vertex)) {
            if (v == parent)
                continue;
            else if (found[v]) // I have found v before, this is definately a backedge
                low[vertex] = Math.min(low[vertex], discovery[v]);
            else {
                // i have not found this verte yet, so it's a tree edge
                dfs1(adj, discovery, low, found, v, vertex);
                low[vertex] = Math.min(low[vertex], low[v]);
                // considering v is the children of vertex
                children++;
            }
            if (parent != -1 && low[v] >= discovery[vertex])
                pts.add(vertex);
        }
        if (parent == -1 && children > 1)
            pts.add(vertex);
    }
}