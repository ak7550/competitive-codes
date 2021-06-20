import AkPackage.*;
import java.util.*;

public class LongestCommonSubSequence {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LongestCommonSubSequence());
        while (!lines.isEmpty()) {
            String s1 = lines.remove(0), s2 = lines.remove(0);
            System.out.println("s1: " + s1);
            System.out.println("s2: " + s2);
            System.out.println("Length of longest common subsequence: " + lcs(s1, s2, s1.length(), s2.length()));
        }
    }

    public static int lcs(String s1, String s2, int x, int y) {
        int dp[][] = new int[x + 1][y + 1];

        // Arrays.fill(dp[0], 0);
        // for (int i = 1; i < x; i++) //-> x: rows, y: cols
        //     dp[i][0] = 0; //-> NO NEED TO INITIALIZE AS PRIMITIVE ARRAY ELEMENTS GET INITIALIZE WITH 0 BY DEFAULT

        //_ dp[i][j] ==> the value of lcs for s1[0...i], s2[0...j]
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) // take lcs the value from s1[0...i-1] & s2[0...j-1] and +1 as wew are getting a new common element
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else // take the lcs value that we have encuntered so far, while traversing from s1[0...i] & s2[0...j]
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        Graph.printAdjacencyMatrix(dp);
        return dp[x][y];
    }
}