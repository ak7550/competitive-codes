import AkPackage.*;
import java.util.*;

public class NumberOfUniquePath {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new NumberOfUniquePath());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For Input: " + arr[0] + " " + arr[1]);
            System.out.println("Number of possible paths: " + numberOfPath(arr[0], arr[1]));
        }
    }

    public static int numberOfPath(int x, int y) {
        int dp[][] = new int[x + 1][y + 1];
        Arrays.fill(dp[1], 1); // row filled ==> if  the matrix is (1,x) ==> i can reach to any (1,i) just by going straight right
        for (int i = 1; i <= x; i++)
            dp[i][1] = 1; //col filled, if the matrix is (x,1) ==> I can reach to any (i,1) just by going to straight bottom.

        for (int i = 2; i <=x; i++) {
            for (int j = 2; j <=y; j++) {
                // i can reach to any dp[i][j], by taking right from dp[i][j-1]
                // i can reach to any dp[i][j], by taking bottom from dp[i-1][j]
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        Graph.printAdjacencyMatrix(dp);
        return dp[x][y];
    }
}