import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class LCS {
    public static void main(String[] args) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
        String s1 = stdin.readLine(), s2 = stdin.readLine();
        System.out.println(lcs3(s1, s2));
    }

    public static String lcs3(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? 1 + dp[i - 1][j - 1]
                        : Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        StringBuilder str = new StringBuilder();
        int i = s1.length(), j = s2.length();
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j]) //lcs matches with i --> go towards i
                i--;
            else if (dp[i][j] == dp[i][j - 1]) // vice versa
                j--;
            else {
                str.append(s1.charAt(i - 1)); // lcs matches with both i & j --> that means s1.charAt(i) & s2.charAt(j) both are common
                i--;
                j--;
            }
        }

        return str.reverse().toString();
    }

    //! playing with strings are costly operations, that's why we are geting tle
    //-> play with the numbers instead
    public static String lcs(String s1, String s2) {
        String dp[][] = new String[s1.length() + 1][s2.length() + 1];

        // return new StringBuilder(lcs(s1, s2, s1.length() - 1, s2.length() - 1, dp)).reverse().toString();
        // return lcs(s1, s2, 0, 0, dp);
        return lcs1(s1, s2);
    }



    public static String lcs(String s1, String s2, int i1, int i2, String dp[][]) {
        if (i1 == s1.length() || i2 == s2.length())
            return "";
        if (dp[i1][i2] != null)
            return dp[i1][i2];

        if (s1.charAt(i1) == s2.charAt(i2))
            return dp[i1][i2] = s1.charAt(i1) + lcs(s1, s2, i1 + 1, i2 + 1, dp); // or ulto
        else {
            String a = lcs(s1, s2, i1 + 1, i2, dp), b = lcs(s1, s2, i1, i2 + 1, dp);
            return dp[i1][i2] = a.length() >= b.length() ? a : b;
        }
    }

    public static String lcs1(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0)
            return "";
        String dp[][] = new String[s1.length() + 1][s2.length() + 1];
        Arrays.stream(dp).forEach(x -> Arrays.fill(x, ""));
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    dp[i][j] += s1.charAt(i - 1);
                } else
                    dp[i][j] = dp[i - 1][j].length() >= dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
