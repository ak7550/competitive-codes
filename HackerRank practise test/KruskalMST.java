import AkPackage.*;
import java.util.*;



public class KruskalMST {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new KruskalMST());
        while (!lines.isEmpty()) {
            int n = Integer.parseInt(lines.remove(0));
            ArrayList<Integer> from = InputOutput.ArrayListFromString(lines.remove(0)),
                    end = InputOutput.ArrayListFromString(lines.remove(0)),
                    weight = InputOutput.ArrayListFromString(lines.remove(0));

            System.out.println("For: " + from + "\n" + end + "\n" + weight);
            System.out.println("Cost of mst is: " + findMST(from, end, weight ,n));
        }
    }

    static int parent[];

    static class Edge implements Comparable<Edge> {
        int from, end, weight;

        public Edge(int f, int e, int w) {
            from = f;
            end = e;
            weight = w;
            parent[f] = f;
            parent[e] = e;
        }

        public int compareTo(Edge e) {
            return weight == e.weight ? (from + end) - (e.from + e.end) : weight - e.weight;
        }
    }

    public static boolean isLoop(Edge e) {
        return findParent(e.from) == findParent(e.end);
    }

    public static void union(Edge e, int up) {
        int sp = findParent(e.from), ep = findParent(e.end);

        if (sp == up)
            parent[e.end] = up;
        else if(ep == up)
            parent[e.from] = up;
        else // kitchu ekta
            parent[e.end] = sp;
    }

    public static int findParent(int node) {
        return parent[node] == node ? node : findParent(parent[node]);
    }


    public static int findMST(ArrayList<Integer> gFrom, ArrayList<Integer> gTo, ArrayList<Integer> gWeight, int gNodes) {
        ArrayList<Edge> edges = new ArrayList<>();
        parent = new int[gNodes + 1];
        for (int i = 0; i < gFrom.size(); i++)
            edges.add(new Edge(gFrom.get(i), gTo.get(i), gWeight.get(i)));
        Collections.sort(edges);

        int mst = 0, ultimateParent = -1;
        while (!edges.isEmpty()) {
            Edge edge = edges.remove(0);
            // int sp = findParent(edge.from), ep = findParent(edge.end);
            if (!isLoop(edge)) {
                mst += edge.weight;
                if (ultimateParent == -1)
                    ultimateParent = edge.from;
                // union(edge.from, edge.end);
                union(edge, ultimateParent);
            }
        }

        return mst;
    }
}