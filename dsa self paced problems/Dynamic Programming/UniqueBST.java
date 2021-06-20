import AkPackage.*;
import java.util.*;

public class UniqueBST {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new UniqueBST());
        while (!lines.isEmpty()) {
            int n = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            System.out.println("For given: " + n);
            int res = numTrees(n);
            System.out.println("Possible unique bst's are: " + res);
        }
    }

    // -> The number of binary search trees = (Number of ways root can be chosen)*
    // (Number of Left binary search sub-trees) * (Number of Right binary search
    // sub-trees). ===> nth catalan number

    public static int numTrees(int n) {
        long dp[] = new long[n + 1];
        dp[0] = 1;
        int mod = (int) Math.pow(10, 9) + 7;
        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                // considering j as root [1...j-1] numbers will fall into left sub tree
                // [j+1….i] numbers will fall in the right subtree
                dp[i] = (dp[i] + (dp[j] * dp[i - j - 1]) % mod) % mod;
            }
        }
        return (int) dp[n];
    }
}