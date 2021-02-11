import AkPackage.*;
import java.util.*;

public class BFS {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new BFS());
        while (!lines.isEmpty()) {
            Graph.InnerGraph ig = Graph.takeAdjacencyListInputDIRECTED(lines);
            System.out.println("DFS is: " + bfsOfGraph(ig.vertices, ig.adjacencyList));
        }
    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Graph.printAdjacencyList(adj);
        ArrayList<Integer> bfs = new ArrayList<Integer>();
        boolean counted[] = new boolean[V];
        ArrayDeque<Integer> aq = new ArrayDeque<Integer>();
        aq.push(0);
        while (!aq.isEmpty()) {
            int ver = aq.poll();
            if (!counted[ver]) {
                bfs.add(ver);
                aq.addAll(adj.get(ver));
            }
            counted[ver] = true;
        }
        return bfs;
    }

}