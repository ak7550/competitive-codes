import AkPackage.*;
import java.util.*;

public class LevelOfNode {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LevelOfNode());
        while (!lines.isEmpty()) {
            Graph.InnerGraph<Integer> ig = Graph.takeAdjacencyListInputUNDIRECTED(lines);
            System.out.println("For the given graph: ");
            Graph.printAdjacencyList(ig.adjacencyList);
            int X = InputOutput.arrayFromString(lines.remove(0))[0];
            System.out.println("Level of " + X + " is: " + nodeLevel(ig.vertices, ig.adjacencyList, X));
        }
    }

    static int actualLevel;

    static int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {
        if (X >= V)
            return -1;
        boolean found[] = new boolean[V];
        actualLevel = -1;
        for (int i = 0; i < V; i++)
            if (!found[i] && !found[X]) {
                if (i == X)
                    return 0;
                bfs(adj, X, found, i);
            }
        return actualLevel;
    }

    public static void bfs(ArrayList<ArrayList<Integer>> adj, int X, boolean found[], int vertex) {
        found[vertex] = true;
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(vertex, 0);
        for (int i : adj.get(vertex)) {
            if (!found[i]) {
                found[i] = true;
                if (i == X) {
                    actualLevel = hm.get(vertex) + 1;
                    return;
                }
                ad.addLast(i);
                hm.put(i, hm.get(vertex) + 1);
            }
        }
        while (!ad.isEmpty()) {
            int v = ad.pollFirst();
            for (Integer i : adj.get(v)) {
                if (!found[i]) {
                    found[i] = true;
                    if (i == X) {
                        actualLevel = hm.get(v) + 1;
                        return;
                    }
                    ad.addLast(i);
                    hm.put(i, hm.get(v) + 1);
                }
            }
        }
    }

}