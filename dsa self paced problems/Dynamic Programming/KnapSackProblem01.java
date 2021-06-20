import AkPackage.*;
import java.util.*;

//*SOLVED
public class KnapSackProblem01 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new KnapSackProblem01());
        while (!lines.isEmpty()) {
            int values[] = InputOutput.arrayFromString(lines.remove(0)),
                    weights[] = InputOutput.arrayFromString(lines.remove(0));
            int weight = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            System.out.println("Values: " + Arrays.toString(values));
            System.out.println("Weights: " + Arrays.toString(weights));
            System.out.println("Weight: " + weight);
            System.out.println("Maximum weight is: " + knapSack(values, weights, weight));
        }
    }


    //O(n*W) time complexity, O(n*W) space complexity
    public static int knapSack(int values[], int weights[], int W) {
        int dp[][] = new int[values.length   + 1] [ W +1];
        //dp[0] is filled with 0, dp[0][i] are filled with 0 by default...


        //-> dp[i][j] ==> max value I can make out of 1toi weight-value pair to make the maximum weight of j
        for (int i = 1; i <= values.length; i++) { // col traverse ==> weight-value pair traverse
            for (int j = 1; j <= W; j++) { // row traverse ==> sum traverse
                if (weights[i - 1] > j) // can't consider this weight, as it exceeds the maximum load taking capability ==> same values will be there
                    dp[i][j] = dp[i - 1][j]; // same as it took to fill i-1 values to make j

                else // now I am considering values[i-1] too, so need to consider the max value I can make without using values[i-1]
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
            }
        }

        return dp[values.length][W];
    }
}