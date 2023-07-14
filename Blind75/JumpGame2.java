import AkPackage.*;
import javafx.util.converter.NumberStringConverter;

import java.util.*;


public class JumpGame2 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new JumpGame2());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("ip:" + Arrays.toString(nums));
            System.out.println("op: " + canJump(nums));
        }
    }

    private static boolean canJump(int nums[]) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        canJump(dp, 0, nums);
        return dp[0] != -1;
    }

    private static int canJump(int dp[], int start, int nums[]) {
        if (start >= nums.length)
            return 1;
        if (dp[start] != -1) {
            return dp[start];
        }

        for (int i = 1; i <= nums[start]; i++) {
            int val = canJump(dp, start + i, nums);
            // System.out.println("val at start" + val  + " " + start);
            if (val != -1) {
                dp[start] = dp[start] == -1 ? val + 1 : Math.min(val + 1, dp[start]);
            }
        }

        return dp[start];

    }
}