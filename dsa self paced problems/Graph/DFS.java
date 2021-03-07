import AkPackage.*;
import java.util.*;

public class DFS {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new DFS());
        while (!lines.isEmpty()) {
            Graph.InnerGraph<Integer> ig = Graph.takeAdjacencyListInputUNDIRECTED(lines);
            System.out.println("DFS is: " + DFSOfGraph(ig.vertices, ig.adjacencyList));
        }
    }

    public static ArrayList<Integer> DFSOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Graph.printAdjacencyList(adj);
        ArrayList<Integer> dfs = new ArrayList<Integer>(V);
        boolean found[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!found[i])
                dfs(adj, dfs, i, found);
        }
        return dfs;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs, int vertex, boolean[] found) {
        if (!found[vertex]) {
            found[vertex] = true;
            dfs.add(vertex);
            for (int i = 0; i < adj.get(vertex).size(); i++) {
                if (!found[adj.get(vertex).get(i)])
                    dfs(adj, dfs, adj.get(vertex).get(i), found);
            }
        }
    }
}