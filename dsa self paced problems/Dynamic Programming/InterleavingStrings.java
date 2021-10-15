import AkPackage.*;
import java.util.*;


public class InterleavingStrings {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new InterleavingStrings());
        while (!lines.isEmpty()) {
            String line[] = lines.remove(0).split(" ");
            String a = line[0], b = line[1], c = line[2];
            System.out.println("\n\nFor " + a + " " + b + " ");
            System.out.println("Intereleaving: " + c + " is: " + isInterleaving(a, b, c));
        }
    }

    public static boolean isInterleaving(String a, String b, String c) {
        if (c.length() != (a.length() + b.length()))
            return false;
        boolean dp[][] = new boolean[b.length() + 1][a.length() + 1];

        dp[0][0] = true;

        for(int i=1; i<=a.length(); i++)
            dp[0][i] = a.charAt(i - 1) == c.charAt(i - 1) && dp[0][i - 1]; //-> previous should be true, along with the condition.

        for (int i = 1; i <= b.length(); i++)
            dp[i][0] = b.charAt(i - 1) == c.charAt(i - 1) && dp[i - 1][0]; // -> previous should be true, along with the condition.

        for (int i = 1; i <=b.length(); i++)
            for (int j = 1; j <= a.length(); j++) {
                if (a.charAt(j - 1) == c.charAt(i + j - 1))  //-> when a matches, check the previous value
                    dp[i][j] = dp[i][j - 1];

                if(b.charAt(i-1) == c.charAt(i+j-1)) //-> when b matches, check the upper value
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
            }




        // System.out.println(Arrays.deepToString(dp));
        return dp[b.length()][a.length()];



    }
}