import AkPackage.*;
import java.util.*;


public class MaxLenubArrayWithPostitiveProduct {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaxLenubArrayWithPostitiveProduct());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For I/P: " + Arrays.toString(nums));
            System.out.println("Max length: " + getMax(nums, 0));
        }
    }

    public static int  getMax(int nums[], int from) {
        if (from == nums.length)
            return 0;
        int i = 0, max = nums[from] >= 0 ? 1 : 0, negativeCount = 0, ni = -1, p = nums[from] > 0 ? 1 : 0;

        if (nums[from] == 0)
            return Math.max(max, getMax(nums, from + 1));

        for (i = from + 1; i < nums.length; i++) {
            if (nums[i] == 0) // come out from the loop to call a new recursion
                break;
            if (nums[i] < 0) {
                negativeCount++; // count total negative to check if it's even
                if (ni == -1)
                    ni = i;
                max = Math.max(max, p);
                p = 0;
            }
            if (nums[i] > 0)
                p++;
            if ((negativeCount & 1) == 0)
                max = Math.max(max, i - from + 1);
            max = Math.max(max, p);
        }

        if (i != nums.length) {
            max = Math.max(max, getMax(nums, i + 1));
        }
        max = Math.max(max, p);
        return max;
    }
}