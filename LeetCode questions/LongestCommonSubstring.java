import AkPackage.*;
import java.util.*;


public class LongestCommonSubstring {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LongestCommonSubstring());
        while (!lines.isEmpty()) {
            String str = lines.remove(0);
            System.out.println("For input: " + str);
            System.out.println("Longest common substring is: " + lps(str, 0, str.length() - 1));
        }
    }

    public static String lps(String str, int start, int end) {
        if (isPal(str, start, end))
            return str.substring(start, end + 1);

        String maxL = new String();
        for (int i = start; i < end; i++) {
            String left = lps(str, start, i),
                    right = lps(str, i + 1, end);

            String max = left.length() > right.length() ? left : right;
            maxL = max.length() > maxL.length() ? max : maxL;
        }

        return maxL;
    }

    public static boolean isPal(String str, int s, int e) {
        while (s < e) {
            if (str.charAt(s) != str.charAt(e))
                return false;
            s++;
            e--;
        }
        return true;
    }
}