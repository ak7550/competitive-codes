import AkPackage.*;
import java.util.*;

// tough code (toughest of all my entire career)
public class LargestNumberWithKSwaps {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LargestNumberWithKSwaps());
        while (!lines.isEmpty()) {
            int k = Integer.parseInt(lines.remove(0));
            String str = lines.remove(0);
            System.out.println("\nmaximum number is: " + findMaximum(str, k));
        }
    }

    public static String findMaximum(String str, int k) {
        StringBuilder string = new StringBuilder(str);
        return permute2(string, k, 0).toString();
    }

    public static StringBuilder permute(StringBuilder str, int k, int start) {
        if (start == str.length() || k == 0)
            return str;
        int maxIndex = str.length() - 1;
        for (int i = str.length() - 1; i >= start; i--)
            if (str.charAt(i) > str.charAt(maxIndex))
                maxIndex = i;
        return str.charAt(maxIndex) == str.charAt(start) ? permute(str, k, start + 1) : permute(str, k - 1, start + 1);
    }

    public static StringBuilder permute2(StringBuilder str, int k, int start) {
        if (start == str.length() || k == 0)
            return str;
        StringBuilder res = new StringBuilder(str), max = new StringBuilder(str);
        for (int i = start; i <= str.length() - 1; i++) {
            // if (str.charAt(i) >= str.charAt(start)) {
            if(str.charAt(i) >= max.charAt(start)){ // more optimal
                res = permute2(swap(str, i, start), str.charAt(start) == str.charAt(i) ? k : k - 1, start + 1);
                max = max.charAt(start) > res.charAt(start) ? max : res;
            }
        }
        return max;
    }

    public static StringBuilder getMax(StringBuilder a, StringBuilder b, int end) {
        int i = -1;
        for (i = 0; i <= end; i++)
            if (a.charAt(i) != b.charAt(i))
                break;
        return a.charAt(i) > b.charAt(i) ? a : b;
    }

    public static StringBuilder swap(StringBuilder str, int a, int b) {
        StringBuilder str2 = new StringBuilder(str);
        char ac = str2.charAt(a), bc = str2.charAt(b);
        str2.replace(a, a + 1, bc + "");
        str2.replace(b, b + 1, ac + "");
        return str2;
    }
}