import AkPackage.*;
import java.util.*;

public class CommonChild {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CommonChild());
        while (!lines.isEmpty()) {
            String str[] = lines.remove(0).split(" ");
            System.out.println("For s1: " + str[0] + " s2: " + str[1]);
            System.out.println("Length of common child is: " + commonChild(str[0], str[1]));
        }
    }

    public static int commonChild(String s1, String s2) {
        int x = s1.length(), y = s2.length();
        int dp[][] = new int[x + 1][y + 1];

        // Arrays.fill(dp[0], 0);
        // for (int i = 1; i < x; i++) //-> x: rows, y: cols
        // dp[i][0] = 0; //-> NO NEED TO INITIALIZE AS PRIMITIVE ARRAY ELEMENTS GET
        // INITIALIZE WITH 0 BY DEFAULT

        // _ dp[i][j] ==> the value of lcs for s1[0...i], s2[0...j]
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) // take lcs the value from s1[0...i-1] & s2[0...j-1] and +1 as
                                                          // wew are getting a new common element
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else // take the lcs value that we have encuntered so far, while traversing from
                     // s1[0...i] & s2[0...j]
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