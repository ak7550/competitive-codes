import AkPackage.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class DijkstrasAlgoOnAdjacencyList {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new DijkstrasAlgoOnAdjacencyList());
        while (!lines.isEmpty()) {
            Graph.InnerGraph<SimpleEntry<Integer, Integer>> ig = Graph.takeAdjacencyListInputUNDIRECTEDWEIGHTED(lines);
            System.out.println("For the given input: ");
            Graph.printAdjacencyList(ig.adjacencyList);
            int res[] = dijkstra(ig.vertices, ig.adjacencyList);
            System.out.println("Shortest path to reach all the adjacent vertices are: " + Arrays.toString(res));
        }
    }

    public static int[] dijkstra(int V, ArrayList<ArrayList<SimpleEntry<Integer, Integer>>> adj) {
        int res[] = new int[V];
        Arrays.fill(res, Integer.MAX_VALUE);
        PriorityQueue<SimpleEntry<Integer, Integer>> pq = new PriorityQueue<SimpleEntry<Integer, Integer>>(
                (a, b) -> a.getValue() - b.getValue());
        // considering 0 as the source vertex
        int source = 0;
        res[source] = 0;
        boolean finalised[] = new boolean[V];

        // relaxing all the adjacent of 0
        for (SimpleEntry<Integer, Integer> u : adj.get(source)) {
            relax(u, source, pq, res);
        }
        finalised[source] = true; // now relax
        int count = 1;
        while (count < V && !pq.isEmpty()) {
            SimpleEntry<Integer, Integer> v;
            do {
                v = pq.poll();
            } while (finalised[v.getKey()]);
            for (SimpleEntry<Integer, Integer> u : adj.get(v.getKey())) {
                relax(u, v.getKey(), pq, res);
            }
            finalised[v.getKey()] = true;
            count++;
        }
        return res;
    }

    public static void relax(SimpleEntry<Integer, Integer> u, int v, PriorityQueue<SimpleEntry<Integer, Integer>> pq,
            int res[]) {
        if (res[u.getKey()] > res[v] + u.getValue()) {
            res[u.getKey()] = res[v] + u.getValue();
            u.setValue(res[u.getKey()]);
            pq.add(u);
        }
    }

}
