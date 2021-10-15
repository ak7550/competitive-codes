import AkPackage.Graph.Edge;
import AkPackage.*;
import java.util.*;


public class KruskalAlgo {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new KruskalAlgo());
        while (!lines.isEmpty()) {
            Edge[] edges = Graph.getEdges(lines);
            System.out.println("For input: " + Arrays.toString(edges));
            System.out.println("Value of minimum spanning tree is: " + countMinimumSpanningTree(edges));
        }
    }

    public static int countMinimumSpanningTree(Edge edges[]) {
        Arrays.sort(edges);

        //! counting the number of vertices.
        int V = (int) Arrays.stream(edges).map(e -> new int[] {e.start, e.end}).distinct().count();

        int parent[] = new int[V], rank[] = new int[V], sum = 0;

        for (int i = 0; i < V; i++)
            parent[i] = i;

        //-> in case of kruskal, there is always a possibility that, the components are not connected...
        //_ we need to at max only V-1 number of edges to connect all the vertices (theory) ==> this will not hold for disconnected components.
        for (int i = 0, s = 0; s < V-1 && i<edges.length; i++) {
            Edge edge = edges[i];
            int x = find(parent, edge.start), y = find(parent, edge.end);

            if (x != y) {
                sum += edge.weight;
                s++;
                union(x, y, parent, rank);
            }
        }
        return sum;
    }

    public static int find(int parent[], int x) {
        if (x == parent[x])
            return x;
        parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    public static void union(int x, int y, int parent[], int rank[]) {
        int xp = find(parent, x), yp = find(parent, y);

        //-> normally this is not possible, as we are handling or calling this method, only when paprents are not same
        if (xp == yp)
            return;

        if (rank[xp] < rank[yp])
            parent[xp] = yp;
        else if(rank[xp]> rank[yp])
            parent[yp] = xp;
        else {
            parent[yp] = xp;
            rank[xp]++;
        }
    }

}
