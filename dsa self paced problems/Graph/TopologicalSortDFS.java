import AkPackage.*;
import java.util.*;

public class TopologicalSortDFS {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new TopologicalSorting());
        while (!lines.isEmpty()) {
            Graph.InnerGraph<Integer> ig = Graph.takeAdjacencyListInputDIRECTED(lines);
            System.out.println("\nFor the given input: ");
            Graph.printAdjacencyList(ig.adjacencyList);
            System.out.println("Topological sorted result is: ");
            topologicalSort(ig.adjacencyList, ig.vertices);
        }
    }

    public static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int V) {
        Stack<Integer> stack = new Stack<Integer>();
        boolean found[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!found[i]) {
                dfs(i, found, adj, stack);
            }
        }
        while (!stack.isEmpty())
            System.out.print(stack.pop()+ " ");
    }

    public static void dfs(int vertex, boolean found[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        found[vertex] = true;
        for (int v : adj.get(vertex)) {
            if (!found[v])
                dfs(v, found, adj, st);
        }
        st.push(vertex);
    }
}