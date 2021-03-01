import AkPackage.*;
import java.util.*;

public class TopologicalSorting {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new TopologicalSorting());
        while (!lines.isEmpty()) {
            Graph.InnerGraph ig = Graph.takeAdjacencyListInputDIRECTED(lines);
            System.out.println("For the given input: ");
            Graph.printAdjacencyList(ig.adjacencyList);
            System.out.println("Topological sorted result is: ");
            topologicalSort(ig.adjacencyList, ig.vertices);
        }
    }

    public static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int V) {
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int x : adj.get(i))
                indegree[x]++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < indegree.length; i++)
            if (indegree[i] == 0) {
                q.add(i);
                indegree[i]--;
            }
        while (!q.isEmpty()) {
            int vertex = q.poll();
            System.out.print(vertex + " ");
            for (int x : adj.get(vertex))
                indegree[x]--;
            for (int i = 0; i < indegree.length; i++)
                if (indegree[i] == 0) {
                    q.add(i);
                    indegree[i]--;
                }
        }
    }
}