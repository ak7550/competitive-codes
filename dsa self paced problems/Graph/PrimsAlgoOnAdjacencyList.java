import AkPackage.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class PrimsAlgoOnAdjacencyList {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new PrimsAlgoOnAdjacencyList());
        while (!lines.isEmpty()) {
            Graph.InnerGraph<SimpleEntry<Integer, Integer>> ig = Graph.takeAdjacencyListInputUNDIRECTEDWEIGHTED(lines);
            System.out.println("For the given adjacency list: ");
            Graph.printAdjacencyList(ig.adjacencyList);
            System.out.println(
                    "Value of minimum spanning tree is: " + primsMinimumSpanningTree(ig.vertices, ig.adjacencyList));
        }
    }

    public static int primsMinimumSpanningTree(int V, ArrayList<ArrayList<SimpleEntry<Integer, Integer>>> adj) {
        int res = 0, count = 0;
        // Priority queue of only those paris which nodes has not been found yet.
        PriorityQueue<SimpleEntry<Integer, Integer>> pq = new PriorityQueue<SimpleEntry<Integer, Integer>>(
                (a, b) -> a.getValue() - b.getValue());
        boolean found[] = new boolean[V];
        for (SimpleEntry<Integer, Integer> pair : adj.get(0))
            pq.add(pair);
        found[0] = true;
        count = 1;
        while (count < V) {
            while (found[pq.peek().getKey()])
                pq.poll();
            SimpleEntry<Integer, Integer> v = pq.poll();
            // pair is now containing the least value adjacent to 0
            res += v.getValue();
            count++;
            found[v.getKey()] = true;
            for (SimpleEntry<Integer, Integer> u : adj.get(v.getKey())) {
                if (!found[u.getKey()])
                    pq.add(u);
            }
        }
        return res;
    }
}