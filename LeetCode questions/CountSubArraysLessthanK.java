import AkPackage.*;
import java.util.*;


public class CountSubArraysLessthanK {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CountSubArraysLessthanK());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            long k = Long.parseLong(lines.remove(0));

            System.out.println("for ip: " + Arrays.toString(nums) + " " + k);
            System.out.println("op: " + countSubArrays(nums, k));
        }
    }

    public static long countSubArrays(int nums[], long k) {
        int start = 0, end = 0;
        int sum = 0;
        long mul = 1;
        long count = 0;
        while (end < nums.length) {
            sum += nums[end];
            mul = (sum * (end - start + 1));
            if (mul >= k) {
                // rule violates
                int n = end - start;
                count += ((n * (n + 1)) >> 1);
                sum = 0;
                start++;
                end = start;
            } else
                end++;
        }
        // after coming out of the loop, end == nums.length
        if (mul < k) {
            int n = end - start;
            count += ((n * (n + 1)) >> 1);
        }

        return count;
    }
}