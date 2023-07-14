import AkPackage.*;
import java.util.*;

public class KthPermutation {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new KthPermutation());
        while (!lines.isEmpty()) {
            List<Integer> arr = InputOutput.ArrayListFromString(lines.remove(0));
            System.out.println("for ip: " + arr);
            System.out.println("op: " + solve(arr.get(0), arr.get(1)));
        }
    }

    private static String solve(int n, int k) {
        StringBuilder data = new StringBuilder();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            data.append(i);
            fact *= i;
        }
        k--;
        fact /= n--;

        String ans = "";
        while (n > 0) {
            ans += data.charAt(k / fact);
            data.deleteCharAt(k / fact);
            k %= fact;
            fact /= n--;
        }
        return ans+data.charAt(0);
    }
}