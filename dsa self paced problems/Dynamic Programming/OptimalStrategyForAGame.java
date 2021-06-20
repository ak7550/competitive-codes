import AkPackage.*;
import java.util.*;

//! tough question
//=> number of coins are always even.

public class OptimalStrategyForAGame {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new OptimalStrategyForAGame());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For: " + Arrays.toString(arr));
            System.out.println("Max value is: " + countMaximum2(arr));
        }
    }

    public static long countMaximum(int arr[]) {
        return countMaximum(arr, 0, arr.length - 1);
    }

    // recurssive approach
    public static long countMaximum(int arr[], int start, int end) {
        // base case
        if (start + 1 == end)
            return Math.max(arr[start], arr[end]);
        // -> if i take arr[start], opponent can take either arr[start+1] or arr[end],
        // in those case my options will be (i) from arr[start+2...end] or (ii)
        // arr[start+1....end-1]

        // _ opponent will always make sure that I do receive the combination of minimum
        // sum ==> Math.min from opponent pov ==> tricky to think....
        return Math.max(arr[start] + Math.min(countMaximum(arr, start + 2, end), countMaximum(arr, start + 1, end - 1)),
                arr[end] + Math.min(countMaximum(arr, start + 1, end - 1), countMaximum(arr, start, end - 2)));
        // -> if i take arr[end], opponent can take either arr[start] or arr[end-1], in
        // those case my options will be (i) from arr[start+1...end-1] or (ii)
        // arr[start....end-2]
    }

    // dp approach
    public static long countMaximum2(int arr[]) {
        long dp[][] = new long[arr.length][arr.length];

        // filling the base cases
        for (int i = 0; i < arr.length - 1; i++)
            dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);

        for (int gap = 3; gap < arr.length; gap += 2) { // skipping 1 row in each traversal ==> check dp table
            for (int start = 0; start + gap < arr.length; start++) {
                int end = gap + start; // moving diagonally
                dp[start][end] = Math.max(arr[start] + Math.min(dp[start + 1][end - 1], dp[start + 2][end]),
                        arr[end] + Math.min(dp[start][end - 2], dp[start + 1][end - 1]));
            }
        }

        return dp[0][arr.length - 1];
    }
}