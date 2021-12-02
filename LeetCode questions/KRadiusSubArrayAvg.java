import AkPackage.*;
import java.util.*;


public class KRadiusSubArrayAvg {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new KRadiusSubArrayAvg());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            int k = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            System.out.println("For i/p: " + Arrays.toString(nums) + ", k: " + k);
            System.out.println("Ans: " + Arrays.toString(getAverages(nums, k)));
        }
    }

    public static int[] getAverages(int nums[], int k) {
        int ans[] = new int[nums.length];
        Arrays.fill(ans, -1);
        long size = (k << 1) + 1; //-> must be long, other wise the last tc did not pass
        long sum = 0;
        if (nums.length < size)
            return ans;
        for (int i = 0; i < size; i++)
            sum += nums[i];
        ans[k] = (int) (sum / size);
        for (int i = k+1; k + i < nums.length; i++) {
            sum += (nums[k + i] - nums[i - (k+1)]);
            ans[i] = (int) (sum / size);
        }
        return ans;
    }

}