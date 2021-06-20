import AkPackage.*;
import java.util.*;

public class MinimumNumberOfCoins {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MinimumNumberOfCoins());
        while (!lines.isEmpty()) {
            int value = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            int coins[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("\n\nFor the given input: " + Arrays.toString(coins));
            System.out.println("Value of: " + value);
            long res = minimumNumberOfCoins2(coins, coins.length, value);
            System.out.println("minimum number of coins required: " + res);
        }
    }

    // recurrsive approach
    public static long minimumNumberOfCoins2(int coins[], int n, int sum) {
        // base case
        if (sum == 0)
            return 0;
        if (sum < 0) // reject
            return Integer.MAX_VALUE;

        long p1 = Integer.MAX_VALUE, p2 = Integer.MAX_VALUE;
        if (n != 0) {
            if (sum >= coins[n - 1]) // taking the same coin
                p1 = minimumNumberOfCoins2(coins, n, sum - coins[n - 1]) + 1; // this is also considered
            p2 = minimumNumberOfCoins2(coins, n - 1, sum); // taking any other coin
        }
        return Math.min(p1, p2);
    }

    //dp approach
    public static long minimumNumberOfCoins(int coins[], int n, int sum) {
        long minSum[] = new long[sum + 1];
        minSum[0] = Integer.MAX_VALUE; // what is the minimum coins it takes to make minSum[i] value

        for (int s = 1; s <= sum; s++) {
            long min = Integer.MAX_VALUE;
            for (int c = 0; c < coins.length; c++) {
                long m = Integer.MAX_VALUE;
                if (coins[c] > s) // not possible to make s with coins[c]
                    m = Integer.MAX_VALUE;
                else if (s % coins[c] == 0) // take all of it, only this
                    m = s / coins[c];
                else
                    m = minSum[s - coins[c]] + 1; // (s-coins[c]) was made by minimum minSum[s-coins[c]] number
                                                         // of coins. extra +1 coin is necessary
                min = Math.min(min, m);
            }
            minSum[s] = min;
        }
        return minSum[sum];
    }
}