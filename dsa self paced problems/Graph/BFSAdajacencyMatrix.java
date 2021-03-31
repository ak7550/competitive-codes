import AkPackage.*;
import java.util.*;

public class BFSAdajacencyMatrix {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new BFSAdajacencyMatrix());
        while (!lines.isEmpty()) {
            int adj[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For the given adjaceney matrix: ");
            Graph.printAdjacencyMatrix(adj);
            bfsTraversal(adj);
        }
    }

    public static void bfsTraversal(int adj[][]) {
        boolean found[] = new boolean[adj.length];
        int connectedComponents = 0;
        for (int row = 0; row < adj.length; row++) {
            for (int col = 0; col < adj[row].length; col++) {
                if (!found[row] && adj[row][col] != 0) {
                    bfs(adj, found, row);
                    connectedComponents++;
                }
            }
        }
        System.out.println("Number of distinct islands are: " + connectedComponents);
    }

    public static void bfs(int adj[][], boolean found[], int source) {
        ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
        deq.addLast(source);
        while (!deq.isEmpty()) {
            int vertex = deq.pollFirst();
            System.out.print(vertex + ' ');
            for (int col = 0; col < adj[vertex].length; col++)
                if (!found[vertex] && adj[vertex][col] != 0)
                    deq.addLast(col);
            found[vertex] = true;
        }
    }
}