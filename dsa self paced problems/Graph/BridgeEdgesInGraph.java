import AkPackage.*;
import java.util.*;

public class BridgeEdgesInGraph {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new BridgeEdgesInGraph());
        while (!lines.isEmpty()) {
            Graph.InnerGraph<Integer> ig = Graph.takeAdjacencyListInputUNDIRECTED(lines);
            Graph.printAdjacencyList(ig.adjacencyList);
            int str[] = InputOutput.arrayFromString(lines.remove(0));
            int source = str[0], destn = str[1];
            System.out.println("The vertex between " + source + " to " + destn
                    + (isBridge(ig.vertices, ig.adjacencyList, source, destn) ? " is" : " is not") + " a bridge");
        }
    }

    static int discoveryCount;
    static boolean timeToReturnFromD, timeToReturnFromC;
    public static boolean isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d) {
        int low[] = new int[V], discovery[] = new int[V];
        boolean found[] = new boolean[V];
        discoveryCount = 1;
        timeToReturnFromD = false;
        timeToReturnFromD = false;
        for (int source = 0; source < adj.size(); source++) {
            if (!found[source] && !(timeToReturnFromC && timeToReturnFromD)) {
                dfs1(adj, discovery, low, found, source, -1, c, d);
                low[source] = discovery[source];
            }
        }
        // Arrays.fill(low, Integer.MAX_VALUE);
        return low[d]>discovery[c] || low[c]>discovery[d];
    }

    public static void dfs1(ArrayList<ArrayList<Integer>> adj, int discovery[], int low[], boolean found[], int vertex,
            int parent,int c, int d) {
        found[vertex] = true;
        low[vertex] = discovery[vertex] = discoveryCount++;
        for (int v : adj.get(vertex)) {
            if (v == parent)
                continue;
            else if (found[v]) // I have found v before, this is definately a backedge
                low[vertex] = Math.min(low[vertex], discovery[v]);
            else {
                // i have not found this verte yet, so it's a tree edge
                dfs1(adj, discovery, low, found, v, vertex, c, d);
                low[vertex] = Math.min(low[vertex], low[v]);
                //considering v is the children of vertex
                if (timeToReturnFromD && timeToReturnFromC)
                    return;
            }
        }
        if (vertex == c)
            timeToReturnFromC = true;
        if (vertex == d)
            timeToReturnFromD = true;
        if (timeToReturnFromC && timeToReturnFromD)
            return;
    }
}