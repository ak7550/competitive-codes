import AkPackage.*;
import java.util.*;

public class KosarajusAlgo {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new KosarajusAlgo());
        while (!lines.isEmpty()) {
            Graph.InnerGraph<Integer> ig = Graph.takeAdjacencyListInputDIRECTED(lines);
            System.out.println("For the given input: ");
            Graph.printAdjacencyList(ig.adjacencyList);
            kosaraju(ig.adjacencyList, ig.vertices);
        }
    }

    public static void kosaraju(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean found[] = new boolean[V];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < adj.size(); i++) {
            for (int v : adj.get(i)) {
                if (!found[v])
                    dfs(v, adj, found, stack);
            }
            // only put it into the stack if it have not found out yet.
            if (!found[i])
                stack.push(i);
        }
        ArrayList<ArrayList<Integer>> trans = getTransposeGraph(adj);
        Arrays.fill(found, false);
        System.out.println("Strongly connected components are: ");
        int count = 0;
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!found[v]) {
                dfs(v, trans, found);
                System.out.println();
                count++;
            }
        }
        System.out.println("Count is: " + count);
    }

    public static void dfs(int vertex, ArrayList<ArrayList<Integer>> adj, boolean found[]) {
        found[vertex] = true;
        System.out.print(vertex + " ");
        for (int v : adj.get(vertex))
            if (!found[v])
                dfs(v, adj, found);

    }

    public static void dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean found[], Stack<Integer> st) {
        found[u] = true;
        for (int v : adj.get(u)) {
            if (!found[v])
                dfs(v, adj, found, st);
        }
        st.push(u);
    }

    public static ArrayList<ArrayList<Integer>> getTransposeGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> trans = new ArrayList<ArrayList<Integer>>(adj.size());
        for (int i = 0; i < adj.size(); i++)
            trans.add(new ArrayList<Integer>());

        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                trans.get(adj.get(i).get(j)).add(i);
            }
        }

        System.out.println("New reversed adjacency list is: ");
        Graph.printAdjacencyList(trans);
        return trans;
    }
}