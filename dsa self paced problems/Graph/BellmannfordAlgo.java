import AkPackage.*;
import AkPackage.Graph.InnerGraph;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;


public class BellmannfordAlgo {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new BellmannfordAlgo());
        while (!lines.isEmpty()) {
            InnerGraph<SimpleEntry<Integer, Integer>> ig = Graph.takeAdjacencyListInputDIRECTEDWEIGHTED(lines);
            System.out.println("For the given adjacency list: ");
            Graph.printAdjacencyList(ig.adjacencyList);
            int source = 0;
            int dis[] = bellmannFord(ig.vertices, ig.adjacencyList, source);
            System.out.println("shortest path of all vertices from the source is: " + Arrays.toString(dis));

            // in negative edged cycle, we will get shorter to shorter path in each
            // iteration, so for the vth time if we get lesser distance, that means the
            // presence of negative edge cycle
            findNegativeEdgeCycle(ig.adjacencyList, ig.vertices, dis);
        }
    }

    public static void findNegativeEdgeCycle(ArrayList<ArrayList<SimpleEntry<Integer, Integer>>> adj, int V,
            int[] dis) {
        //-> at this point all the vertices should be relaxed, so the if condition should nvr satisfy....
        for (int v = 0; v < adj.size(); v++) {
            for (SimpleEntry<Integer, Integer> u : adj.get(v))
                if(dis[u.getKey()]>dis[v] + u.getValue()) // relax operation
                    System.out.println("Negative edged cycle detected.");
        }
    }

    public static int[] bellmannFord(int V, ArrayList<ArrayList<SimpleEntry<Integer, Integer>>> adj, int source) {
        int dis[] = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[source] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (int v = 0; v < adj.size(); v++) {
                for (SimpleEntry<Integer, Integer> u : adj.get(v))
                    dis[u.getKey()] = Math.min(dis[u.getKey()], dis[v] + u.getValue()); // relax operation
            }
        }
        return dis;
    }

}