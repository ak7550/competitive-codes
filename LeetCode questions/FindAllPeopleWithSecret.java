import AkPackage.*;
import java.util.*;

public class FindAllPeopleWithSecret {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FindAllPeopleWithSecret());
        while (!lines.isEmpty()) {
            int first[] = InputOutput.arrayFromString(lines.remove(0));
            int meetings[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For given: \nn= " + first[0] + " firstperson: " + first[1]);
            System.out.println(Arrays.deepToString(meetings));
            System.out.println("Ans: " + findAllPeople(first[0], meetings, first[1]));
        }
    }

    // intuition: dfs
    // => I have to make graph connctions bw all the members into the same time
    // frame
    public static List<Integer> findAllPeople(int n, int meetings[][], int firstPerson) {
        boolean[] doKnow = new boolean[n];
        doKnow[0] = true;
        doKnow[firstPerson] = true;
        TreeMap<Integer, ArrayList<int[]>> hm = new TreeMap<>();
        for (int met[] : meetings) {
            if (!hm.containsKey(met[2]))
                hm.put(met[2], new ArrayList<>());
            hm.get(met[2]).add(met);
        }
        for (ArrayList<int[]> mets : hm.values()) {
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            mets.stream().forEach(x -> {
                if (!map.containsKey(x[0]))
                    map.put(x[0], new ArrayList<>());
                if (!map.containsKey(x[1]))
                    map.put(x[1], new ArrayList<>());
                map.get(x[0]).add(x[1]);
                map.get(x[1]).add(x[0]);
            });

            mets.stream().forEach(x -> {
                if (doKnow[x[0]] || doKnow[x[1]]) {
                    dfs(x[0], map, doKnow);
                    dfs(x[1], map, doKnow);
                }
            });
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < doKnow.length; i++)
            if (doKnow[i])
                ans.add(i);

        return ans;
    }

    public static void dfs(int parent, HashMap<Integer, ArrayList<Integer>> map, boolean doKnow[]) {
        if (doKnow[parent])
            return;
        doKnow[parent] = true;
        for (Integer child : map.get(parent))
            dfs(child, map, doKnow);
    }
}