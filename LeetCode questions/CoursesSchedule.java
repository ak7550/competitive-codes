import AkPackage.*;
import java.util.*;


public class CoursesSchedule {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CoursesSchedule());
        while (!lines.isEmpty()) {
            int numCourses = InputOutput.arrayFromString(lines.remove(0))[0];
            int prerequisites[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("for ip: " + numCourses);
            System.out.println("prerequisites: " + Arrays.deepToString(prerequisites));
            System.out.println("Ans: " + schedule(numCourses, prerequisites));
        }
    }

    private static boolean schedule(int numCourses, int prerequisites[][]) {
        if (numCourses == 1 || prerequisites.length == 0)
            return true;

        int inDegree[] = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int arr[] : prerequisites) {
            inDegree[arr[0]]++;
            adj.get(arr[1]).add(arr[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                numCourses--;
            }
        }

        if (q.isEmpty())
            return false;

        while (!q.isEmpty()) {
            int vertex = q.poll();
            for (int v : adj.get(vertex)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.add(v);
                    numCourses--;
                }
            }
        }

        return numCourses == 0;
    }
}