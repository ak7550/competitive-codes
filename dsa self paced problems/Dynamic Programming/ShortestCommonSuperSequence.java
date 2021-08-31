import AkPackage.*;
import java.util.*;

public class ShortestCommonSuperSequence {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ShortestCommonSuperSequence());
        while (!lines.isEmpty()) {
            String s1 = lines.remove(0), s2 = lines.remove(0);
            System.out.println("s1: " + s1);
            System.out.println("s2: " + s2);
            System.out.println("Length of shortest common subsequence: "
                    + shortestCommonSuperSequence(s1, s2, s1.length(), s2.length()));
        }
    }

    public static int shortestCommonSuperSequence(String s1, String s2, int x, int y) {
        int dp[][] = new int[x + 1][y + 1];
        // dp[i][i] == scs for s1[0...i-1] & s2[0...j-1]

        for (int i = 0; i <= x; i++)
            dp[i][0] = i;
        for (int i = 0; i <= y; i++)
            dp[0][i] = i;

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) // won't consider this one
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        }
        Graph.printAdjacencyMatrix(dp);
        return dp[x][y];
    }
}