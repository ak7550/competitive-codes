import AkPackage.*;
import java.util.*;
import java.util.stream.IntStream;

public class MotherVertex {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MotherVertex());
        while (!lines.isEmpty()) {
            Graph.InnerGraph<Integer> ig = Graph.takeAdjacencyListInputDIRECTED(lines);
            Graph.printAdjacencyList(ig.adjacencyList);
            System.out.println("Mother vertex is: " + mothervertex(ig.adjacencyList, ig.vertices) + "\n\n");
        }
    }

    public static int mothervertex(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean found[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!found[i]) {
                dfs(adj, i, found);
                if (check(adj, i))
                    return i;
            }
        }
        return -1;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int vertex, boolean found[]) {
        found[vertex] = true;
        for (int v : adj.get(vertex))
            if (!found[v])
                dfs(adj, v, found);
    }

    public static boolean check(ArrayList<ArrayList<Integer>> adj, int vertex) {
        boolean found[] = new boolean[adj.size()];
        dfs(adj, vertex, found);
        return IntStream.range(0, found.length).parallel().mapToObj(index -> found[index])
                .filter(x -> x.equals(Boolean.TRUE)).count() == 0;
    }
}

// tough question