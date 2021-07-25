import AkPackage.*;
import java.util.*;


public class EggDroppingProblem {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new EggDroppingProblem());
        while (!lines.isEmpty()) {
            int input[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For Input: " + Arrays.toString(input));
            System.out.println("Minimum Trails: " + eggDrop(input[0], input[1]));
        }
    }

    // dp ==> O(f^2 e) time complexity
    public static int eggDrop(int eggs, int floor) {
        int dp[][] = new int[floor + 1][eggs + 1];
        for (int i = 1; i <= floor; i++)
            dp[i][1] = i; // for each floor we need an egg to test
        for (int i = 1; i <= eggs; i++)
            dp[1][i] = 1; // if there's only 1 floor, then we need 1 egg only
        for (int i = 2; i <= floor; i++) {
            for (int j = 2; j <= eggs; j++) {
                dp[i][j] = Integer.MAX_VALUE; // consider the minimum number we must need to test for ith floor with having j eggs
                for (int x = 1; x <= i; x++)
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[x - 1][j - 1], dp[i - x][j]));
                //-> egg break ==> thressold floor is below x, and I have lost an egg
                // -> egg does not break ==> thressold floor is above x, and the count of eggs is intact.
            }
        }
        return dp[floor][eggs];
    }
}