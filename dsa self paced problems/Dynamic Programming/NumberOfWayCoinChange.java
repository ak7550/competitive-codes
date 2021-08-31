import AkPackage.*;
import java.util.*;

public class NumberOfWayCoinChange {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new NumberOfWayCoinChange());
        while (!lines.isEmpty()) {
            int sum = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            int coins[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("\n\nFor the given input: " + Arrays.toString(coins));
            System.out.println("Value of: " + sum);
            Arrays.sort(coins);
            long res = numberOfWays2(coins, coins.length, sum);
            System.out.println("Number of ways to genrate the given sum is: " + res);
        }
    }

    // recursive approach
    public static long numberOfWays(int coins[], int n, int sum) {
        if (sum == 0)
            return 1;
        if (sum < 0)
            return 0;
        if (n != 0) // once i will consider the same number, then i wont
            return numberOfWays(coins, n, sum - coins[n - 1]) + numberOfWays(coins, n - 1, sum);
        return 0;
    }

    // dp approach
    public static long numberOfWays2(int coins[], int n, int sum) {
        long dp[][] = new long[sum + 1][coins.length];

        Arrays.fill(dp[0], 0); // i cant make sum =0, by using any number

        for (int s = 1; s <= sum; s++) // if i can make s with first of the coin
                dp[s][0] = s % coins[0] == 0 ? 1 : 0;

        for (int s = 1; s <= sum; s++) {
            for (int c = 1; c < coins.length; c++) {
                dp[s][c] = dp[s][c - 1];
                  if (s > coins[c])
                    dp[s][c] += dp[s - coins[c]][c];
                // increase by 1 only when s is same with coins[c]
                if (s == coins[c] )
                    dp[s][c]++;
            }
        }
        Arrays.deepToString(dp);
        return dp[sum][coins.length - 1];
    }
}