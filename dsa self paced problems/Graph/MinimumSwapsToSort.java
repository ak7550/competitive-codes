import AkPackage.*;
import java.util.*;

public class MinimumSwapsToSort {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MinimumSwapsToSort());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For the given input: " + Arrays.toString(nums));
            System.out.println("Number of swaps required: " + minSwaps(nums));
        }
    }

    static class Pair {
        public int index, value;

        Pair(int i, int v) {
            index = i;
            value = v;
        }
    }

    public static int minSwaps(int nums[]) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        // Arrays.stream(nums).forEach(pq::add); // O(n)
        for (int x : nums) {
            hm.put(x, count++);
            pq.add(x);
        }
        count = 0;
        int i = 0;
        while (!pq.isEmpty()) {
            int smallest = pq.poll();
            if (nums[i] != smallest) {
                // time to swap
                count++;
                int index = hm.get(smallest);
                nums[index] = nums[i];
                nums[i] = smallest;
                hm.remove(smallest);
                hm.put(nums[index], index);
            }
            i++;
        }
        return count;
    }
}