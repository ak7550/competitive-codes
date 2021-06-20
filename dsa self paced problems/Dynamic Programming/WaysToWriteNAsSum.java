import AkPackage.*;
import java.util.*;

public class WaysToWriteNAsSum {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new WaysToWriteNAsSum());
        while (!lines.isEmpty()) {
            int n = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            System.out.println("\n\nFor the given " + n + ": ");
            int res = countWays(n);
            System.out.println("Ans: " + res);
        }
    }

    //_ how many ways following coins can be used to make the given sum

    public static int countWays(int sum) {
        int dp[][] = new int[sum + 1][sum], mod=(int)Math.pow(10, 9)+7;

        if (sum <= 1)
            return 0;

        Arrays.fill(dp[0], 0); // can't make sum=0 with the help of any positive number

        for (int s = 1; s <= sum; s++)
            dp[s][1] = 1;

        for (int s = 1; s <= sum; s++) {
            for (int number = 2; number < sum; number++) {
                dp[s][number] = dp[s][number - 1];
                if(s>number)
                    dp[s][number] = (dp[s][number]+ (dp[s - number][number])%mod)%mod;
                if(s==number)
                    dp[s][number] = (dp[s][number]+1)%mod;
            }
        }


        // Graph.printAdjacencyMatrix(dp);
        return (dp[sum][sum-1])%mod;
    }
}