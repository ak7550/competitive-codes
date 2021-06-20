import AkPackage.*;
import java.util.*;

public class FibonacciNumbers {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FibonacciNumbers());
        while (!lines.isEmpty()) {
            int n = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            System.out.println("For  the given " + n + ": ");
            Long ans = fibonacciBottomUp(n);
            ans = fibonacciBottomUp2(n, new Long[n+1]);
            System.out.println(n + "th fibonacci number is: " + ans);

        }
    }

    public static Long fibonacciBottomUp2(int n, Long dp[]) {
        if (n == 0 || n == 1)
            return (long)n;

        if (dp[n] == null)
            dp[n] = fibonacciBottomUp2(n - 1, dp) + fibonacciBottomUp2(n - 2, dp);


        return dp[n];
    }

    public static Long fibonacciBottomUp(int n) {
        ArrayList<Long> dp = new ArrayList<>();
        dp.add((long)0);
        dp.add((long)1);
        for (int i = 2; i <= n; i++)
            dp.add(dp.get(i - 1) + dp.get(i - 2));

        System.out.println("dp is: " + dp);
        return dp.get(n);
    }
}