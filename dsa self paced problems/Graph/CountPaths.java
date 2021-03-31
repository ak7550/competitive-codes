import AkPackage.*;
import java.util.*;

public class CountPaths {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CountPaths());
        while (!lines.isEmpty()) {
            Graph.InnerGraph<Integer> ig = Graph.takeAdjacencyListInputDIRECTED(lines);
            System.out.println("For the given graph: ");
            String line[] = lines.remove(0).split(" ");
            int source = Integer.parseInt(line[0]), destn = Integer.parseInt(line[1]);
            System.out.println("The number paths between " + source + " and " + destn + " are: "
                    + countPaths(ig.vertices, ig.adjacencyList, source, destn));
        }
    }
    public static int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source, int destn) {
        int path[] = new int[V];
        if (source == destn)
            return 1;
        Arrays.fill(path, 0);
        dfs(adj, source, destn, path);
        return path[source];
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int source, int destn, int path[]) {
        for (int v : adj.get(source)) {
            if (v == destn) {
                path[source]++;
                continue;
            }
            if (path[v] == 0) // we have not been in this route yet.
                dfs(adj, v, destn, path);
            path[source] += path[v];
        }
    }
}