import AkPackage.*;
import java.util.*;

public class ReachAGivenScore {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ReachAGivenScore());
        while (!lines.isEmpty()) {
            int n = InputOutput.arrayFromString(lines.remove(0))[0];
            System.out.println("For the given: " + n);
            System.out.println("Ans is: " + count(n));
        }
    }

    public static int count(int n) {
        if (n <= 2)
            return 0;
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 3; i <= n; i++)
            dp[i] += dp[i - 3]; // -> so we wont get duplicate permutation dp[5]=0 currently
        for (int i = 5; i <= n; i++)
            dp[i] += dp[i - 5];
        for (int i = 10; i <= n; i++)
            dp[i] += dp[i - 10];
        return dp[n];
    }
}