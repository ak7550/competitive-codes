import AkPackage.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;


public class DijkstraAlgorithm {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new DijkstraAlgorithm());
        while (!lines.isEmpty()) {
            Graph.InnerGraph<SimpleEntry<Integer, Integer>> ig = Graph.takeAdjacencyListInputUNDIRECTEDWEIGHTED(lines);
            System.out.println("For the given input: ");
            Graph.printAdjacencyList(ig.adjacencyList);
            int res[] = dijkstra(ig.vertices, ig.adjacencyList);
            for (int i = 0; i < res.length; i++)
                System.out.println("To reach node " + i + " travelled distance is: " + res[i]);
        }
    }

    //-> key is the node number, value is the edge weight
    public static int[] dijkstra(int V, ArrayList<ArrayList<SimpleEntry<Integer, Integer>>> adj) {
        PriorityQueue<SimpleEntry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        int distance[] = new int[V]; //-> distance tells u, what exactly it requires to reach tht particular node, mainly we will update it into the relax operation
        boolean finalize[] = new boolean[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        // finalize the source --> 0 in this case
        //==> steps to finalize
        //=> update all the nodes, that can be reaching from this node, and put them into the pq
        for (SimpleEntry<Integer, Integer> u : adj.get(0))
            relax(u, 0, pq, distance);
        finalize[0] = true;

        while (!pq.isEmpty()) {
            // remove those vertices, which are already finalized
            while (!pq.isEmpty() && finalize[pq.peek().getKey()])
                pq.poll();
            if (pq.isEmpty())
                break;
            SimpleEntry<Integer, Integer> se = pq.poll();
            int v = se.getKey();
            for (SimpleEntry<Integer, Integer> u : adj.get(v))
                relax(u, v, pq, distance);
            finalize[v] = true;
        }

        return distance;
    }

    public static void relax(SimpleEntry<Integer, Integer> u, int v, PriorityQueue<SimpleEntry<Integer, Integer>> pq, int dis[]) {
        if (dis[u.getKey()] > dis[v] + u.getValue()) {
            dis[u.getKey()] = dis[v] + u.getValue();
            u.setValue(dis[u.getKey()]); //_update
            pq.add(u);
        }
    }
}