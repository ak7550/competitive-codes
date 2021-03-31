import AkPackage.*;
import java.util.*;

public class TarjansAlgo {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new TarjansAlgo());
        while (!lines.isEmpty()) {
            Graph.InnerGraph<Integer> ig = Graph.takeAdjacencyListInputDIRECTED(lines);
            System.out.println("For the given graph");
            Graph.printAdjacencyList(ig.adjacencyList);
            ArrayList<ArrayList<Integer>> res = tarjanAlgo(ig.adjacencyList, ig.vertices);
            System.out.println("Strongly connected components are: ");
            res.forEach(System.out::println);
        }
    }

    static int discoveryCount;

    public static ArrayList<ArrayList<Integer>> tarjanAlgo(ArrayList<ArrayList<Integer>> adj, int V) {
        Stack<Integer> stack = new Stack<Integer>();
        int discovery[] = new int[V], low[] = new int[V];
        boolean found[] = new boolean[V], inStack[] = new boolean[V];
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        discoveryCount = 0;
        for (int i = 0; i < adj.size(); i++)
            if (!found[i])
                dfs(i, -1, stack, discovery, low, found, adj, inStack, res);

        Collections.sort(res, (a, b) -> a.get(0) - b.get(0));
        return res;
    }

    public static void dfs(int vertex, int parent, Stack<Integer> st, int discovery[], int low[], boolean found[],
            ArrayList<ArrayList<Integer>> adj, boolean inStack[], ArrayList<ArrayList<Integer>> res) {
        st.push(vertex);
        inStack[vertex] = true;
        found[vertex] = true;
        discovery[vertex] = low[vertex] = ++discoveryCount;
        for (int v : adj.get(vertex)) {
            if (v == vertex) // to avoid the self loop
                continue;
            else if (found[v] && inStack[v]) // (v, vertex) is a backedge
                low[vertex] = Math.min(low[vertex], discovery[v]);
            else if (!found[v]) // (v, vertex) is a tree edge, if it's not found yet, it's can't be present into
                                // the stack
            {
                dfs(v, vertex, st, discovery, low, found, adj, inStack, res);
                low[vertex] = Math.min(low[vertex], low[v]);
            }
        }
        // if we get our condition satisfied we will pop our elements out from the stack
        if (discovery[vertex] == low[vertex]) {
            int v = -1;
            ArrayList<Integer> r = new ArrayList<Integer>();
            do {
                v = st.pop();
                inStack[v] = false;
                r.add(0, v);
            } while (v != vertex && !st.isEmpty());
            Collections.sort(r);
            res.add(0, r);
        }
    }

}