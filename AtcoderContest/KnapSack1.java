import java.util.Scanner;

public class KnapSack1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), W = sc.nextInt();
        int weights[] = new int[n], values[] = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }
        System.out.println(knapSack(n, W, weights, values));
    }

    public static long knapSack(int n, int W, int weights[], int values[]) {
        long dp[][] = new long[W+1][n+1];
        //-> dp[w][i] ==> what's the max value that I can make using weights from 0 to i-1, total weight at most w

        for (int w = 1; w <= W; w++) {
            for (int i = 1; i <= n; i++) {
                dp[w][i] = dp[w][i - 1];
                if(w >= weights[i-1])
                    dp[w][i] = Math.max(dp[w][i], values[i - 1] + dp[w - weights[i - 1]][i - 1]);
            }
        }
        return dp[W][n];
    }
}
