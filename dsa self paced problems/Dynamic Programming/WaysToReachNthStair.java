import AkPackage.*;
import java.util.*;

public class WaysToReachNthStair {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new WaysToReachNthStair());
        while (!lines.isEmpty()) {
            int n = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            System.out.println("\n\nFor the given " + n + ": " + countWays(n));
        }
    }

    public static int countWays(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int mod = (int) Math.pow(10, 9) + 7;
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;

        return dp[n] % mod;
    }
}