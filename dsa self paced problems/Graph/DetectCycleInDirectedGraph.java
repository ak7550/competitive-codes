import AkPackage.*;
import java.util.*;

public class DetectCycleInDirectedGraph {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new DetectCycleInDirectedGraph());
        while (!lines.isEmpty()) {
            Graph.InnerGraph<Integer> ig = Graph.takeAdjacencyListInputDIRECTED(lines);
            System.out.println("For the given graph: ");
            Graph.printAdjacencyList(ig.adjacencyList);
            System.out.println("Cycle does" + (checkCycle(ig.adjacencyList, ig.vertices) ? "" : " not") + " exist.");
        }
    }

    public static boolean checkCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean found[] = new boolean[V], stack[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!found[i] && dfs(adj, i, found, stack))
                return true;
        }
        return false;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int vertex, boolean found[], boolean stack[]) {
        found[vertex] = true;
        stack[vertex] = true;
        for (int v : adj.get(vertex)) {
            if (!found[v] && dfs(adj, v, found, stack))
                return true;
            else if (found[v] && stack[v])
                return true;
        }
        stack[vertex] = false; // popping it out from the stack at the end of the function call
        return false;
    }
}