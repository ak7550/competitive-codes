import AkPackage.*;
import java.util.*;

public class CountNodesWithHighestScore2 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CountNodesWithHighestScore());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For the gien array: " + Arrays.toString(nums));
            System.out.println("Number of nodes with highest score is: " + countHighestScoreNodes(nums));
        }
    }

    static long maxProduct;

    public static int countHighestScoreNodes(int parent[]) {
        maxProduct = 1;
        HashMap<Long, Integer> frequency = new HashMap<Long, Integer>();
        HashMap<Integer, ArrayList<Integer>> children = new HashMap<>();
        computeChild(parent, children);
        compute(parent, children, frequency, 0);
        System.out.println(frequency);
        return frequency.get(maxProduct);
    }

    public static int compute(int parent[], HashMap<Integer, ArrayList<Integer>> children,
            HashMap<Long, Integer> frequency, int root) {

        // -> leaf node
        if (!children.containsKey(root)) {
            long remain = parent.length - 1; // -> leaf node, only the node will not be considered.
            frequency.put(remain, frequency.getOrDefault(remain, 0) + 1);
            maxProduct = Math.max(maxProduct, remain);
            return 1;
        }
        int remain = parent.length; // -> the itself nust deduct
        long product = 1;
        int  total = 0;
        for (int child : children.get(root)) {
            int size = compute(parent, children, frequency, child);
            remain -= size;
            product *= size;
            total += size;
        } // -> considering all the subtrees
        remain--;
        if (remain != 0) //_ when root is the head ==> remain ==0
            product *= remain;

        frequency.put(product, frequency.getOrDefault(product, 0) + 1);
        maxProduct = Math.max(maxProduct, product);

        return total + 1; // -> counting the node it self.
    }

    public static void computeChild(int parent[], HashMap<Integer, ArrayList<Integer>> children) {
        for (int i = 0; i < parent.length; i++) {
            if (!children.containsKey(parent[i]))
                children.put(parent[i], new ArrayList<>());
            children.get(parent[i]).add(i);
        }
    }
}