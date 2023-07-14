import java.util.Arrays;
import java.util.*;

public class FindOrder {
    public static void main(String[] args) {
        int n = 4;
        String[][] arr = new String[][] { { "B", "A" }, { "C", "A" }, { "D", "B" }, { "D", "C" } };

        System.out.println(Arrays.toString(findOrder(n, arr)));
    }

    private static String[] findOrder(int n, String[][] arr) {
        // return new String[1];
        /*
        B -> A ==> edge ==> to proceed with, I need to complete B first
        c -> A ==> edge
        D- > B
        -----------
        proceed with A, I need to complete  both B, C
        A has 2 dependencies
        B has 1 dependency
        C has 1 dependecy

        dependecy value
        ------------
        A 2
        b 1
        c 1
        d 0
        */

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (String str[] : arr) {
            char start = str[0].charAt(0), end = str[1].charAt(0);
            adj.get(start - 'A').add(end - 'A');
        }

        System.out.println(adj);

        int dependency[] = new int[adj.size() + 1];


        for (String str[] : arr) {
            char start = str[0].charAt(0), end = str[1].charAt(0);
            dependency[end - 'A']++;
        }

        Queue<Integer> q = new LinkedList<>();

        List<String> ans = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < dependency.length; i++) {
            if (dependency[i] == 0) {
                count++;
                q.add(i);
                char ch = (char) ('A' + i);
                ans.add(new String(ch + ""));
            }
        }

        return new String[0];

        // while(!q.isEmpty()){
    //     int v = q.poll();
    //     for (int x : adj.get(v)) {
    //         dependency[x]--;
    //         if (dependency[x] == 0) {
    //             count++;
    //             q.add(x);
    //             char ch = (char) ('A' + x);
    //             ans.add(new String(ch + ""));
    //         }
    //     }
    // }

    // String ansStr[] = new String[ans.size()];
    // int k = 0;

    // for(String str: ans){
    // ansStr[k++] = str;
    // }

    // return ans.size() == adj.size() ? ansStr : new String[0];
    }
}