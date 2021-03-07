import AkPackage.*;
import java.util.*;

public class DetectCycleInUndirectedGraph {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new DetectCycleInUndirectedGraph());
        while (!lines.isEmpty()) {
            Graph.InnerGraph<Integer> ig = Graph.takeAdjacencyListInputUNDIRECTED(lines);
            System.out.println("The following graph : ");
            Graph.printAdjacencyList(ig.adjacencyList);
            System.out.println("do " + (detectCycle(ig.adjacencyList, ig.vertices) ? "" : "not") + " contain a cycle");
        }
    }

    public static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] found = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!found[i] && dsf(adj, found, i, -1))
                return true; // as it's the first vertext of the disconnected part of the graph
        }
        return false;
    }

    public static boolean dsf(ArrayList<ArrayList<Integer>> adj, boolean found[], int vertex,
            int parent) {
        found[vertex] = true;
        for (int x : adj.get(vertex)) {
            if (found[x] && x != parent) // present into the found but does not equal with the parent
                return true;
            if (!found[x] && dsf(adj, found, x, vertex)) //have not found yet, so we check for it's child
                return true;
        }
        return false;
    }
}