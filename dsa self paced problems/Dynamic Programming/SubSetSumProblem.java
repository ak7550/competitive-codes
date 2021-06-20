import AkPackage.*;
import java.util.*;

public class SubSetSumProblem {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SubSetSumProblem());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For: " + Arrays.toString(arr));
            System.out.println("Ans is: " + findPartition2(arr));
        }
    }

    // recurssive approach
    public static boolean findPartition(int arr[]) {
        int totalsum = Arrays.stream(arr).sum();

        // => if sum is odd return false because we cannot divide into 2 parts
        if (totalsum % 2 == 1)
            return false;

        return check(totalsum, 0, 0, arr);

    }

    public static boolean check(int totalsum, int sum, int index, int arr[]) {
        if (sum == totalsum / 2)
            return true;
        if (index == arr.length)
            return sum == totalsum / 2;

        // either I consider the number into the sum or i wont
        return check(totalsum, sum + arr[index], index + 1, arr) || check(totalsum, sum, index + 1, arr);
    } // tc: O(2^n)

    // dp approach ==> will use the concept of subset sum problem
    public static boolean findPartition2(int arr[]) {
        int totalsum = Arrays.stream(arr).sum();
        if ((totalsum & 1) == 1)
            return false;
        else {
            int res = subSetSum(arr, totalsum / 2);
            return res == 0 ? false : res % 2 == 0;
            // subsetsum will return the number of subsets that sums to totalSum /2 and if the count is an even number then only return true.
        }
    }

    public static int subSetSum(int arr[], int sum) {
        int dp[][] = new int[arr.length + 1][sum + 1];
        for (int i = 0; i <= arr.length; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= sum; i++)
            dp[0][i] = 0;
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < arr[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
            }
        }
        System.out.println("dp is: ");
        Graph.printAdjacencyMatrix(dp);
        return dp[arr.length][sum];
    }

}