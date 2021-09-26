import AkPackage.*;
import java.util.*;

public class MaxProfitUptoKTransactions {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaxProfitUptoKTransactions());
        while (!lines.isEmpty()) {
            int prices[] = InputOutput.arrayFromString(lines.remove(0));
            int k = Integer.parseInt(lines.remove(0));
            System.out.println("For input: " + Arrays.toString(prices) + " " + k);
            System.out.println("Max Profit is: " + maxProfit(prices, k));
        }
    }

    public static int maxProfit(int prices[], int K) {
        if (K >= prices.length / 2)
            return noLimitTrade(prices);
        int dp[][] = new int[K + 1][prices.length];
        for (int k = 1; k <= K; k++) {
            int maxD = Integer.MIN_VALUE;
            for (int i = 1; i < prices.length; i++) {
                maxD = Math.max(maxD, dp[k - 1][i - 1] - prices[i - 1]);
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] + maxD);
            }
        }
        return dp[K][prices.length - 1];
    }

    public static int noLimitTrade(int prices[]) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++)
            if (prices[i + 1] > prices[i])
                profit += (prices[i + 1] - prices[i]);

        return profit;
    }
}