import AkPackage.*;
import java.util.*;

//_ hard problem
//-> solved ✔
public class MaximumNumberOfWaysToPartitionAnArray {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaximumNumberOfWaysToPartitionAnArray());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0)), k = Integer.parseInt(lines.remove(0));
            System.out.println("For: " + Arrays.toString(nums) + " k=" + k);
            System.out.println("Max number of partition: " + waysToPartition(nums, k) + "\n\n");
        }
    }

    public static int waysToPartition(int nums[], int k) {
        if(k==0 && Arrays.stream(nums).distinct().count() == 1)
            return 1;
        HashMap<Long, ArrayList<Integer>> index = new HashMap<>(); // numbers, arraylist of indexes
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!index.containsKey((long)nums[i]))
                index.put((long)nums[i], new ArrayList<>());

            index.get((long)nums[i]).add(i);
            totalSum += nums[i];
        }
        int cArr[] = new int[nums.length];
        long left = 0, right = totalSum;
        int count = 0;
        for (int pivot = 1; pivot < nums.length; pivot++) {
            left += nums[pivot - 1];
            right -= nums[pivot - 1];
            if (left == right)
                count++;
            else if (left < right) {
                long difference = right - left;
                // uplift left
                if (index.containsKey(k - difference)) {
                    for (int in : index.get(k - difference))
                        if (in < pivot)
                            cArr[in]++;
                }

                // downlift right
                if (index.containsKey(k + difference))
                    for (int in : index.get(k + difference))
                        if (in >= pivot)
                            cArr[in]++;
            }
            else {
                long difference = left - right;
                //uplift right
                if(index.containsKey(k-difference))
                    for (int in : index.get(k-difference))
                        if(in >= pivot)
                            cArr[in]++;

                //downlift left
                if(index.containsKey(k+difference))
                    for (int in : index.get(k+difference))
                        if(in < pivot)
                            cArr[in]++;
            }
        }
        int max = k==0 ? 0 : Arrays.stream(cArr).max().getAsInt();
        return Math.max(count, max);
    }
}