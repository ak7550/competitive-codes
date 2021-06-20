import AkPackage.*;
import java.util.*;

public class SumOfAllSubstring {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SumOfAllSubstring());
        while (!lines.isEmpty()) {
            String n = lines.remove(0);
            System.out.println("For the given n: " + n);
            long res = sumSubstrings(n);
            System.out.println("Sum of all substring is: " + res);
        }
    }

    // -> sumofdigit[i] = (i+1)*num[i] + 10*sumofdigit[i-1]
    public static long sumSubstrings(String s) {
        int mod = (int) Math.pow(10, 9) + 7;
        long sum[] = new long[s.length() + 1];
        long res = 0;
        sum[0] = Integer.parseInt(s.charAt(0) + "");
        res = sum[0];
        for (int i = 1; i < s.length(); i++) {
            sum[i] = (((i + 1) * Integer.parseInt(s.charAt(i) + "")) % mod + (10 * sum[i - 1]) % mod) % mod;
            res = (res + sum[i]) % mod;
        }
        return res;
    }
}