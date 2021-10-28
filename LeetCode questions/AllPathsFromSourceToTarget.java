import AkPackage.*;
import java.util.*;


public class AllPathsFromSourceToTarget {
    public static void main(String args[]){
        ArrayList<String> lines= InputOutput.takeCompleteInput(new AllPathsFromSourceToTarget());
        while (!lines.isEmpty()) {
            int n = InputOutput.arrayFromString(lines.remove(0))[0];
            int graph[][] = new int[n][];
            Arrays.stream(graph).forEach(x -> x = InputOutput.arrayFromString(lines.remove(0)));
            System.out.println("For given: ");
            Graph.printAdjacencyMatrix(graph);
            List<LinkedList<Integer>> ans= allPathSourceToTarget(graph);
            ans.forEach(System.out::println);
        }
    }

    public static LinkedList<LinkedList<Integer>> allPathSourceToTarget(int graph[][]) {
        @SuppressWarnings("unchecked")
        LinkedList<LinkedList<Integer>> visited[] = new LinkedList[graph.length];
        allPathSourceToTarget(graph, visited, 0);

        return visited[0];
    }

    public static void allPathSourceToTarget(int graph[][], LinkedList<LinkedList<Integer>> visited[],int vertex) {
        LinkedList<LinkedList<Integer>> ans = new LinkedList<>();
        if (vertex == graph.length - 1) {
            LinkedList<Integer> newAns = new LinkedList<>();
            newAns.add(vertex);
            ans.add(newAns);
            visited[vertex] = ans;
            return;
        }

        for (int v : graph[vertex]) {
            if (visited[v] == null)
                allPathSourceToTarget(graph, visited, v);

            visited[v].forEach(arr -> {
                LinkedList<Integer> newAns = new LinkedList<>();
                newAns.addAll(arr);
                newAns.addFirst(vertex);
                ans.add(newAns);
            });
        }
        visited[vertex] = ans;
    }



}