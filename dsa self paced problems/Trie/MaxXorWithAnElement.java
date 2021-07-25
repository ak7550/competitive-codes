import AkPackage.*;
import java.util.*;

public class MaxXorWithAnElement {

    static class TrieNode {
        TrieNode children[] = new TrieNode[2];

        public void insert(int num) {
            TrieNode curr = this;
            for (int i = 31; i >= 0; i--) {
                int bit = (num & (1 << i)) == 0 ? 0 : 1;
                if (curr.children[bit] == null)
                    curr.children[bit] = new TrieNode();
                curr = curr.children[bit];
            }
        }

        public int getMaxXor(int num) {
            TrieNode curr = this;
            int res = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num & (1 << i)) == 0 ? 0 : 1;
                res = res << 1;
                if (curr.children[1 - bit] == null)
                    curr = curr.children[bit]; // I am getting the same value only.
                else {
                    // so I am getting the oppposite value
                    curr = curr.children[1 - bit];
                    res |= 1;
                }
            }
            return res;
        }

    }

    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaxXorWithAnElement());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            int query[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For: " + Arrays.toString(nums));
            Arrays.stream(query).forEach(x -> System.out.print(x + " "));
            System.out.println();
            System.out.println("Ans: " + maximizeXOR(nums, query));
        }
    }

    public static int[] maximizeXOR(int nums[], int queries[][]) {
        HashMap<int[], Integer> hm = new HashMap<>();
        for (int i = 0; i < queries.length; i++)
            hm.put(queries[i], i);
        Arrays.sort(queries, (a, b) -> a[1] - b[1]); 
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        Arrays.stream(queries).forEach(x -> System.out.print(Arrays.toString(x) + ""));
        int k = 0;
        int ans[] = new int[queries.length];
        TrieNode tr = new TrieNode();
        for (int i = 0; i < queries.length; i++) {
            while (k < nums.length && nums[k] <= queries[i][1])
                tr.insert(nums[k++]);
            ans[hm.get(queries[i])] = k == 0 ? -1 : tr.getMaxXor(queries[i][0]);
        }
        return ans;
    }

}