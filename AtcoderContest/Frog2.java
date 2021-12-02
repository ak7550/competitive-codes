import java.util.Arrays;
import java.util.Scanner;

public class Frog2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int stones[] = new int[n];
        for (int i = 0; i < n; i++)
            stones[i] = sc.nextInt();

        System.out.println(minimumPossibleTotalCost(stones, k));
    }

    public static long minimumPossibleTotalCost(int stones[], int k) {
        long dp[] = new long[stones.length];
        dp[0] = 0;
        dp[1] = Math.abs(stones[1] - stones[0]);
        for (int i = 2; i < stones.length; i++) {
            dp[i] = Long.MAX_VALUE;
            for (int j = 1; j <= k && i >= j; j++)
                dp[i] = Math.min(dp[i], Math.abs(stones[i] - stones[i - j]) + dp[i - j]);
        }
        return dp[stones.length - 1];
    }
}
