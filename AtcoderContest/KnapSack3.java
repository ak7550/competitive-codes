import java.util.Arrays;
import java.util.Scanner;

//=> same knapsack 2 question, doing it just for practise purpose
public class KnapSack3 {
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

        System.out.println(knapSack3(n, W, weights, values));
    }

    public static int knapSack3(int n, long W, long weights[], int values[]) {
        int min = Arrays.stream(values).min().getAsInt(), max = Arrays.stream(values).sum();
        int maxV = -1;
        Long dp[][] = new Long[max+1][values.length+1];
        for (int v = min; v <= max; v++) {
            long wei = makeV(v, weights, values, 0, dp);
            dp[v][0] = wei;
            if (wei <= W) // then v is a feassible solution
                maxV = Math.max(maxV, v);
        }

        return maxV;
    }

    public static long makeV(int value, long weights[], int values[], int index, Long dp[][]) {
        if (index == weights.length) // base case
        {
            if (value == 0) //-> nothing is left, we are succeeded
                return 0;
            else //_ value>0 is, but we are out of stones
                return Long.MAX_VALUE;
        }
        if (dp[value][index] != null)
            return dp[value][index];

        //take
        long take=Long.MAX_VALUE;
        if (value >= values[index]) {
            take = makeV(value - values[index], weights, values, index + 1, dp);
            //->to avoid over flow situation
            if(take != Long.MAX_VALUE)
                take += weights[index];
        }
        long dont = makeV(value, weights, values, index + 1, dp);
        return dp[value][index] = Math.min(take, dont);
    }
}
