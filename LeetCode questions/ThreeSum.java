import AkPackage.*;
import java.util.*;

public class ThreeSum {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ThreeSum());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For Input: " + Arrays.toString(nums));
            System.out.println("Ans: ");
            threeSum(nums).forEach(System.out::println);
        }
    }

    public static List<List<Integer>> threeSum(int nums[]) {
        if (nums.length < 3)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            int trgt = -nums[i], start = i + 1, end = nums.length - 1;
            if (nums[i] > 0)
                break;
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum == trgt) {
                    ans.add(Arrays.asList(nums[i], nums[start++], nums[end--]));
                    while (start < end && nums[start] == nums[start - 1])
                        start++;
                    while (start < end && nums[end] == nums[end + 1])
                        end--;
                } else if (sum < trgt) {
                    start++;
                    while (start < end && nums[start] == nums[start + 1])
                        start++;
                } else {
                    end--;
                    while (start < end && nums[end] == nums[end - 1])
                        end--;
                }

            }

        }

        return ans;
    }
}