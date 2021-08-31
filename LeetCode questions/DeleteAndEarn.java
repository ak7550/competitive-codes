import AkPackage.*;
import java.util.*;


public class DeleteAndEarn {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new DeleteAndEarn());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For input: " + Arrays.toString(nums));
            System.out.println("Max is: " + getValue(nums));
        }
    }

    public static int getValue(int nums[]) {
        if (nums.length == 1)
            return nums[0];
        int length = Arrays.stream(nums).max().getAsInt() + 1;
        int arr[] = new int[length];
        for (int x : nums)
            arr[x] += x;

        for (int i = 3; i < length; i++)
            arr[i] +=  Math.max(arr[i - 2], arr[i - 3]);

        return Math.max(arr[length - 1], arr[length - 2]);

    }
}