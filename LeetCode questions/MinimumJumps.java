import AkPackage.*;
import java.util.*;

public class MinimumJumps {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MinimumJumps());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For ip: " + Arrays.toString(nums));
            int dp[] = new int[nums.length];
            Arrays.fill(dp, -1);
            System.out.println("Op: " + minJumps(nums, 0, dp));
            Boolean booleandp[] = new Boolean[nums.length];
            System.out.println("canJump: " + canJump(nums, 0, booleandp));
        }
    }

    private static boolean canJump(int[] nums, int index, Boolean[] booleandp) {
        if (index >= nums.length - 1)
            return index >= nums.length - 1;
        if (booleandp[index] != null)
            return booleandp[index];

        for (int i = nums[index]; i >= 1; i--) {
            if (canJump(nums, index + i, booleandp)) {
                return booleandp[index] = true;
            }
        }

        return booleandp[index] = false;
    }

    private static int minJumps(int[] nums, int index, int[] dp) {
        if (index == nums.length - 1 || dp[index] != -1) {
            return index == nums.length - 1 ? 0 : dp[index];
        }

        int minValue = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index] && index + i < nums.length; i++) {
            minValue = Math.min(minValue, minJumps(nums, index + i, dp));
        }

        return dp[index] = minValue + 1;
    }

}