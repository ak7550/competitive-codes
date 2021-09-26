import AkPackage.*;
import java.util.*;

public class MinOperations {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MinOperations());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For: " + Arrays.toString(arr));
            System.out.println("Minimum operations required is: " + minimumOperations(arr));
        }
    }

    public static int minimumOperations(int nums[]) {
        int length = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
            hs.add(x);
        }

        int mCount = Integer.MAX_VALUE, count = 0;

        for (int i = 0; i < length; i++)
            if (hs.contains(min + i))
                count++;

        mCount = Math.min(mCount, length - count);

        for (int i = min + length; i <= max; i++) {
            if (hs.contains(i - length))
                count--;
            if (hs.contains(i))
                count++;

            mCount = Math.min(mCount, length - count);
        }

        return mCount;
    }
}