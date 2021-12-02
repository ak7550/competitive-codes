import AkPackage.*;
import java.util.*;

public class ParallelCourses {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ParallelCourses());
        while (!lines.isEmpty()) {
            int relations[][] = Graph.takeAdjacencyMatrixInput(lines);
            int time[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("for given: ");
            Graph.printAdjacencyMatrix(relations);
            System.out.println("Time: " + Arrays.toString(time));
            System.out.println("Minimum time required is: " + minimumtime(relations, time));
        }
    }

    public static int minimumtime(int relations[][], int time[]) {
        int innerEdge[] = new int[time.length + 1]; // _1 -based indexing
        int completionTime[] = new int[time.length + 1];
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        Arrays.stream(time).distinct().sorted().toArray();

        for (int relation[] : relations) {
            innerEdge[relation[1]]++;
            if (!adj.containsKey(relation[0]))
                adj.put(relation[0], new ArrayList<>());
            adj.get(relation[0]).add(relation[1]);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < innerEdge.length; i++)
            if (innerEdge[i] == 0) {
                q.add(i);
                completionTime[i] = time[i - 1];
            }
        int max = 0;
        while (!q.isEmpty()) {
            int vertex = q.poll();
            max = Math.max(max, completionTime[vertex]);
            if (adj.containsKey(vertex))
                for (int v : adj.get(vertex)) {
                    innerEdge[v]--;
                    // -> from vertex I can come to v
                    completionTime[v] = Math.max(completionTime[v], completionTime[vertex]);
                    if (innerEdge[v] == 0) {
                        q.add(v);
                        completionTime[v] += time[v - 1];
                    }
                }
        }
        return max;
    }
}