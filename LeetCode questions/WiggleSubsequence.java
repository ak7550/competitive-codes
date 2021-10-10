import AkPackage.*;
import java.util.*;


public class WiggleSubsequence {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new WiggleSubsequence());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For Input: " + Arrays.toString(nums));
            System.out.println("Longest wiggle Subsequence length: " + wiggleMaxLength(nums));
        }
    }

    public static int wiggleMaxLength(int nums[]) {
        int max[] = new int[nums.length], min[] = new int[nums.length];
        max[0] = 1;
        min[0] = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            max[i] = 1;
            min[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) // increasing satisfies
                    max[i] = Math.max(max[i], min[j] + 1);
                else if (nums[j] > nums[i]) // decreasing satisfies
                    min[i] = Math.max(min[i], max[j] + 1);
            }
            ans = Math.max(ans, Math.max(max[i], min[i]));
        }
        return ans;
    }
}