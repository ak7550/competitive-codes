import AkPackage.*;
import java.util.*;

public class PallindromicPartition {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new PallindromicPartition());
        while (!lines.isEmpty()) {
            String line = lines.remove(0);
            System.out.println("For i/p: " + line);
            System.out.println("Ans is: " + minCut(line));
        }
    }

    public static int minCut(String str) {
        Integer dp[][] = new Integer[str.length() + 1][str.length() + 1];
        Boolean isPal[][] = new Boolean[str.length() + 1][str.length() + 1];
        int ans = minCut(str, dp, isPal, 0, str.length() - 1);
        System.out.println(Arrays.deepToString(isPal));
        System.out.println(Arrays.deepToString(dp));
        return ans;
    }

    public static int minCut(String str, Integer dp[][], Boolean isPal[][], int start, int end) {
        if (isPal[start][end]==null)
            isPal(str, start, end, isPal);
        if (isPal[start][end] || start == end)
            return dp[start][end] = 0;
        if(dp[start][end]!= null)
            return dp[start][end];

        int cuts = Integer.MAX_VALUE;
        for (int i = start+1; i <= end; i++)
            cuts = Math.min(cuts, minCut(str, dp, isPal, start, i-1) + minCut(str, dp, isPal, i, end) + 1);

        return dp[start][end] = cuts;
    }

    private static boolean isPal(String str, int s, int e, Boolean isPal[][]) {
        int start = s, end = e;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                isPal[s][e] = false;
                return false;
            }
            start++;
            end--;
        }
        isPal[s][e] = true;
        return true;
    }

}