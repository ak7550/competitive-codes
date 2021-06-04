import AkPackage.*;
import java.util.*;

public class MColouringProblem {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MColouringProblem());
        while (!lines.isEmpty()) {
            int vce[] = InputOutput.arrayFromString(lines.get(0));
            int vertices = vce[0], m = vce[2], edges = vce[1];
            Graph.InnerGraph<Integer> ig = Graph.takeAdjacencyListInputUNDIRECTED(lines);
            int colors[] = new int[vertices];
            boolean res = graphColouring(ig.adjacencyList, colors, 0, m);
            System.out.println("For the given input: ");
            Graph.printAdjacencyList(ig.adjacencyList);
            System.out.println("Ans is: " + res);
            System.out.println("Color is: " + Arrays.toString(colors));
        }
    }

    public static boolean graphColouring(ArrayList<ArrayList<Integer>> adj, int colors[], int v, int m) {
        if (Arrays.stream(colors).filter(a -> a == 0).count() == 0) // -> all the vertices of the graph has been
                                                                    // coloured
            return true;
        for (int i = 1; i <= m; i++) {
            if (isSafe(adj, colors, v, i)) {
                colors[v] = i;
                if (graphColouring(adj, colors, (v + 1) % adj.size(), m))
                    return true;
                colors[v] = 0; // -> reset
            }
        }
        return false;
    }

    public static boolean isSafe(ArrayList<ArrayList<Integer>> adj, int colors[], int v, int colorValue) {
        // _ check, none of the adjacent vertices of v is having the colorValue
        for (int a : adj.get(v)) {
            if (colors[a] == colorValue)
                return false;
        }
        return true;
    }
}