import AkPackage.*;
import java.util.*;

public class CountNodesWithHighestScore {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CountNodesWithHighestScore());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For the gien array: " + Arrays.toString(nums));
            System.out.println("Number of nodes with highest score is: " + countHighestScoreNodes(nums));
        }
    }

    public static int countHighestScoreNodes(int nums[]) {
        HashMap<Integer, ArrayList<Integer>> children = new HashMap<>();
        computeChild(nums, children);
        int size[] = new int[nums.length];
        size[0] = computeSize(nums, size, children, 0);
        return computMaxScore(nums, size, children);
    }

    public static int computMaxScore(int parent[], int size[], HashMap<Integer, ArrayList<Integer>> children) {
        System.out.println("Size array: " + Arrays.toString(size));
        // System.out.println("Children: "+ children);

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // _ maxScore and frequency
        int maxProduct = 1;
        // for each value from 0 to n-1, we will try to remove all the nodes and count
        // the scores
        for (int node = 0; node < parent.length; node++) {
            int product = 1, remain = parent.length;
            if (children.get(node) != null) {
                for (int child : children.get(node)) {
                    product *= size[child];
                    remain -= size[child];
                }
            }
            remain--; // -> removing the ith node
            if (remain != 0)
                product *= remain;
            hm.put(product, hm.getOrDefault(product, 0) + 1);
            maxProduct = Math.max(maxProduct, product);
        }
        System.out.println("hm: " + hm);
        return hm.get(maxProduct);
    }

    public static int computeSize(int parent[], int size[], HashMap<Integer, ArrayList<Integer>> children, int root) {
        // if (size[root] != 0)
        // return size[root];

        if (children.get(root) == null) // -> leaf node
            return size[root] = 1;

        int count = 0;
        ArrayList<Integer> childs = children.get(root);
        for (int child : childs)
            count += computeSize(parent, size, children, child);
        return size[root] = count + 1;
    }

    public static void computeChild(int parent[], HashMap<Integer, ArrayList<Integer>> children) {
        for (int child = 1; child < parent.length; child++) {
            ArrayList<Integer> arr = children.getOrDefault(parent[child], new ArrayList<>());
            arr.add(child);
            children.put(parent[child], arr);
        }
    }

}