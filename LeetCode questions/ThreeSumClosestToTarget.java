import AkPackage.*;
import java.util.*;

public class ThreeSumClosestToTarget {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ThreeSumClosestToTarget());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            int target = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            System.out.println("For input:" + Arrays.toString(nums));
            System.out.println("res is: " + findSum(nums, target));
        }
    }

    public static int findSum(int nums[], int target) {
        if (nums.length == 3)
            return Arrays.stream(nums).sum();
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE, op = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int s = i + 1, e = nums.length - 1;
            while (s < e) {
                int val = nums[i] + nums[s] + nums[e];
                if (Math.abs(target - val) < diff) {
                    diff = Math.abs(target - val);
                    op = val;
                }
                if (val == target)
                    return target;
                else if (val < target)
                    s++;
                else
                    e--;
            }
        }
        return op;
    }
}