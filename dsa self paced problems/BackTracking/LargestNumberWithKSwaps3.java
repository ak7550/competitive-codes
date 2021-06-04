import AkPackage.*;
import java.util.*;

//*TOUGHEST QUESTION, that i have ever faced so far.....
public class LargestNumberWithKSwaps3 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LargestNumberWithKSwaps());
        while (!lines.isEmpty()) {
            int k = Integer.parseInt(lines.remove(0));
            String str = lines.remove(0);
            System.out.println("\n\nFor the input of " + str);
            System.out.println("K: " + k);
            System.out.println("maximum number is: " + findMaximum(str, k));
        }
    }

    // * this question is really a pain
    static StringBuilder max;

    public static String findMaximum(String str, int k) {
        max = new StringBuilder(str);
        permutation(new StringBuilder(str), 0, 0, k);
        return max.toString();
    }

    public static void permutation(StringBuilder str, int start, int count, int k) {
        if (start == str.length() || count == k)
            return;
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) >= max.charAt(start)) {
                swap(str, i, start);
                max = checkMax(max, str, 0);
                permutation(str, start + 1, str.charAt(i) == str.charAt(start) ? count : count + 1, k);
                swap(str, i, start);
            }
        }
        // return max;
    }

    public static void swap(StringBuilder str, int a, int b) {
        char aa = str.charAt(a), bb = str.charAt(b);
        str.setCharAt(a, bb);
        str.setCharAt(b, aa);
    }

    public static StringBuilder checkMax(StringBuilder max, StringBuilder res, int start) {
        for (int i = start; i < max.length(); i++) {
            if (max.charAt(i) < res.charAt(i))
                return new StringBuilder(res);
            if (max.charAt(i) > res.charAt(i))
                return new StringBuilder(max);
        } // only run the loop when digits are similiar
        return new StringBuilder(max);
    }
}
