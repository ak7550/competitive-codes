import java.util.*;

public class Frog1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long stones[] = new long[n];
        for (int i = 0; i < stones.length; i++)
            stones[i] = sc.nextLong();
        System.out.println(minimumPossibleTotalCost(stones));
    }

    public static long minimumPossibleTotalCost(long stones[]) {
        long dp[] = new long[stones.length];
        dp[0] = 0;
        dp[1] = Math.abs(stones[1] - stones[0]);
        for (int i = 2; i < stones.length; i++)
            dp[i] = Math.min(Math.abs(stones[i] - stones[i - 1]) + dp[i - 1],
                        Math.abs(stones[i] - stones[i-2])+dp[i-2]);
        return dp[stones.length - 1];
    }
}
