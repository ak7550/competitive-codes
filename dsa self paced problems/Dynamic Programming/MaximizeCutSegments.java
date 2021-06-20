import AkPackage.*;
import java.util.*;

public class MaximizeCutSegments {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaximizeCutSegments());
        while (!lines.isEmpty()) {
            int line[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For the input: " + Arrays.toString(line));
            System.out.println("Maximum number of cuts are: " + maximizeCuts(line[0], line[1], line[2], line[3]));
        }
    }

    public static int maximizeCuts(int n, int a, int b, int c) {
        int dp[] = new int[n + 1];
        dp[0]=0;
        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
            if (i - a >= 0)
                dp[i] = Math.max(dp[i], dp[i - a]);
            if (i - b >= 0)
                dp[i] = Math.max(dp[i], dp[i - b]);
            if (i - c >= 0)
                dp[i] = Math.max(dp[i], dp[i - c]);
            if (dp[i] != -1) // successfull cuts are possible, then cut it once with any of a,b,c
                dp[i]++;
        }
        return dp[n] == -1 ? -1 : dp[n];
    }
}