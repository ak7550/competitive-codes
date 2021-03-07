import AkPackage.*;
import java.util.*;

public class DetectCycleInUndirectedGraphBFS {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new DetectCycleInUndirectedGraph());
        while (!lines.isEmpty()) {
            Graph.InnerGraph<Integer> ig = Graph.takeAdjacencyListInputUNDIRECTED(lines);
            System.out.println("For the given graph: ");
            Graph.printAdjacencyList(ig.adjacencyList);
            System.out.println("Cycle does" + (checkCycleBFS(ig.adjacencyList, ig.vertices) ? "" : " not") + " exist.");
        }
    }

    public static boolean checkCycleBFS(ArrayList<ArrayList<Integer>> adj, int V) {
        HashMap<Integer, Integer> parentChildren = new HashMap<Integer, Integer>();
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
        boolean found[] = new boolean[V];
        ad.add(0);
        parentChildren.put(0, -1);
        while (!ad.isEmpty()) {
            int vertex = ad.poll();
            for (int v : adj.get(vertex)) {
                // v has already been found and v is not the parent of vertex
                if (found[v] && parentChildren.get(vertex) != v)
                    return true;
                if (!found[v]) {
                    found[v] = true;
                    ad.add(v);
                    parentChildren.put(v, vertex);
                }
            }
        }
        return false;
    }
}