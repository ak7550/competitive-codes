import AkPackage.*;
import java.util.*;

//lc => 2035
public class PartitionsIntoTwoHalvesDifferenceMinimum {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new PartitionsIntoTwoHalvesDifferenceMinimum());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For: " + Arrays.toString(arr));
            System.out.println("Minimum difference is: " + minimumDifference(arr));
        }
    }

    //-> both the partitions, must have equal size elements.
    public static int minimumDifference(int nums[]) {
        int total = Arrays.stream(nums).sum(), sum = 0;
        Integer dp[] = new Integer[(1 << nums.length) - 1]; //_ implementing bitmask ==> still mle (memory limit exceeded)

        return minDiff(nums, total, sum, 0, 0, dp, 0);
    }

    static int minDiff(int nums[], int total, int sum, int index, int count, Integer dp[], int mask) {
        if (count > (nums.length >> 1))
            return Integer.MAX_VALUE;

        if (dp[mask] != null)
            return dp[mask];

        if (index == nums.length) {
            int ans = Math.abs(total - sum);
            return (sum == 0 || total == 0 || count != (nums.length >> 1)) ? Integer.MAX_VALUE : ans;

        }

        // take the index value or donot
        int v1 = minDiff(nums, total, sum, index + 1, count, dp, mask),
            v2 = minDiff(nums, total - nums[index],
                sum + nums[index], index + 1, count + 1, dp, mask | (1 << index));

        return dp[mask] = Math.min(v1, v2);
    }
}