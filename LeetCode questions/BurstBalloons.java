import AkPackage.*;
import java.util.*;

public class BurstBalloons {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new BurstBalloons());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For i/p: " + Arrays.toString(nums));
            System.out.println("o/p: " + burstBalloons(nums));
        }
    }

    public static int burstBalloons(int nums[]) {
        Integer dp[][] = new Integer[nums.length][nums.length];
        // -> considering ith balloon to be the last balloon to burst, we need to
        // calculate what is the maxCost that I can earn bursting the balloon to it's
        // left side and right side
        return burstBalloons(nums, 0, nums.length - 1, dp);
        // return dp[0][nums.length - 1];
    }

    public static int burstBalloons(int nums[], int left, int right, Integer dp[][]) {
        if (left == -1 || right == nums.length)
            return 1;
        if (left > right)
            return 0;
        // if (left == right)
        //     return dp[left][right] = nums[left];
        if (dp[left][right] != null)
            return dp[left][right];
        int max = 0;
        for (int i = left; i <= right; i++)
            max = Math.max(max,
                    (nums[i] *
                            (left == 0 ? 1 : nums[left - 1])
                            * (right == nums.length - 1 ? 1 : nums[right + 1]))
                            + burstBalloons(nums, left, i - 1, dp)
                            + burstBalloons(nums, i+1, right, dp));

        return dp[left][right] = max;
    }
}