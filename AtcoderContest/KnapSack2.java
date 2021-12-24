import java.util.Arrays;
import java.util.Scanner;

// import AkPackage.Graph;

public class KnapSack2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long W = sc.nextLong();
        long weights[] = new long[n];
        int values[] = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextLong();
            values[i] = sc.nextInt();
        }

        System.out.println(knapSack2(n, W, weights, values));
    }

    // iterative approach
    public static long knapSack(int n, long W, long weights[], int values[]) {
        int V = Arrays.stream(values).sum();
        long dp[][] = new long[V + 1][values.length + 1];
        Arrays.stream(dp).forEach(x -> Arrays.fill(x, -1));
        Arrays.fill(dp[0], 0);
        long max = -1;
        for (int v = 1; v <= V; v++) {
            int i = 0;
            // dp[v][i] = 0;
            for (i = 1; i <= values.length; i++) {
                dp[v][i] = dp[v][i - 1];
                if (v > values[i - 1] && dp[v - values[i - 1]][i - 1] != -1)
                    dp[v][i] = Math.max(dp[v][i], dp[v - values[i - 1]][i - 1] + weights[i - 1]);

                dp[v][i] = Math.max(dp[v][i], weights[i - 1]);
            }
            System.out.println(Arrays.toString(dp[v]));
            if (dp[v][i - 1] <= W)
                max = Math.max(max, v);
        }
        return max;
    }

    // recurssive approach
    public static long knapSack2(int n, long maxWeight, long weights[], int values[]) {
        int V = Arrays.stream(values).sum();
        int maxV = -1;
        long dp[][] = new long[V + 1][values.length + 1];
        Arrays.stream(dp).forEach(x -> Arrays.fill(x, -1));
        for (int v = 0; v <= V; v++) {
            if (recurr(n - 1, v, weights, values, dp) <= maxWeight)
                maxV = v; // -> as v is increasing
        }
        return maxV;
    }

    // -> state(index, maxVal) ==> what is the minimum weight, I can consider for
    // which total value do not cross maxVal
    public static long recurr(int index, long maxVal, long weights[], int values[], long dp[][]) {
        if (index == -1) {
            if (maxVal > 0)
                return Long.MAX_VALUE;
            return 0; //-> maxVal == 0
        }
        if (maxVal == 0)
            return 0;

        if(dp[(int)maxVal][index] != -1)
            return dp[(int) maxVal][index];

        long take = Long.MAX_VALUE, dont = Long.MAX_VALUE;

        //_ there will be no situation where maxVal<0
        if (values[index] <= maxVal)
            take = recurr(index - 1, maxVal - values[index], weights, values, dp); // -> considering
        if (take != Long.MAX_VALUE)
            take += weights[index]; // ! if just add weights[index] with Long.MAX_VALUE, then it overflows and gives
                                    // wrong ans.
        dont = recurr(index - 1, maxVal, weights, values, dp); // -> not considering

        return dp[(int)maxVal][index] =  Math.min(take, dont);
    }

}
