import AkPackage.*;
import java.util.*;

public class SticklerThief {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SticklerThief());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For: " + Arrays.toString(arr));
            System.out.println("Maximum amount could have been: " + findMaxSum(arr));
        }
    }

    public static int findMaxSum(int arr[]) {
        if (arr.length == 1)
            return arr[0];
        if (arr.length == 2)
            return Math.max(arr[0], arr[1]);
        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        dp[2] = dp[0] + arr[2];
        // dp[i] = max sum till ith element without considering any of the consequtive pairs.
        for (int i = 3; i < arr.length; i++)
            dp[i] = Math.max(arr[i] + dp[i - 2], arr[i] + dp[i - 3]);
        return Math.max(dp[arr.length - 2], dp[arr.length - 1]);
    }
}