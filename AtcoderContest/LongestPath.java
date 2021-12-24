import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LongestPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt(), edges = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < vertices; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < edges; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            adj.get(x - 1).add(y - 1); // made it a 0-indexed graph
        }

        System.out.println(findLongestPath(adj));
    }

    public static long findLongestPath(ArrayList<ArrayList<Integer>> adj) {
        // _ into the question, it is mentioned that the graph does not contain any cycle ==> approach bfs
        long longestPathFromvertex[] = new long[adj.size()];
        Arrays.fill(longestPathFromvertex, -1);
        long max = 0;
        for (int i = 0; i < adj.size(); i++)
            max = Math.max(max, dfs(adj, i, longestPathFromvertex));

        // System.out.println("Array is: "+ Arrays.toString(longestPathFromvertex));
        return max - 1;
        // -> as we need to count the path, not the vertices, ==> for n connected vertices there must be n-1 edges
    }

    public static long dfs(ArrayList<ArrayList<Integer>> adj, int index, long longestPathFromvertex[]) {
        if (longestPathFromvertex[index] != -1)
            return longestPathFromvertex[index];
        longestPathFromvertex[index] = 0;

        for (int vertex : adj.get(index))
            longestPathFromvertex[index] = Math.max(longestPathFromvertex[index],
                    dfs(adj, vertex, longestPathFromvertex));

        longestPathFromvertex[index]++; // we must count the vertex itself.
        return longestPathFromvertex[index];
    }
}
