import AkPackage.*;
import java.util.*;


public class FindWhetherPathExist {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FindWhetherPathExist());
        while (!lines.isEmpty()) {
            Graph.InnerGraph<Integer> ig = Graph.takeAdjacencyListInputDIRECTED(lines);
            int arr[] = InputOutput.arrayFromString(lines.remove(0)), source = arr[0], dest = arr[1];
            System.out.println("For the given graph:");
            Graph.printAdjacencyList(ig.adjacencyList);
            System.out.println("There exists " + (checkPath(ig.adjacencyList, ig.vertices, source, dest) ? "" : "no ")
                    + "path between " + source + "and " + dest);
        }
    }

    public static boolean checkPath(ArrayList<ArrayList<Integer>> adj, int V, int source, int dest) {
        boolean stack[] = new boolean[V], found[]= new boolean[V];
        for (int v : adj.get(source)) {
            if (!found[v] && dfs(adj, v, dest, stack, found))
                return true;
        }
        return false;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int vertex, int des, boolean stack[], boolean found[]) {
        // stack[vertex] = true;
        found[vertex] = true;
        for (int v : adj.get(vertex)) {
            if (v == des)
                return true;
            if (!found[v] && dfs(adj, v, des, stack, found))
                return true;
        }
        // stack[vertex] = false;
        return false;
    }
}