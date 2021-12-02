import AkPackage.*;
import java.util.*;

public class MoneyDistribution {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MoneyDistribution());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For: " + arr[0] + " " + arr[1]);
            System.out.println("Ans is: " + totalWays(arr[0], arr[1]));

        }
    }

    public static int totalWays(int n, int k) {
        if (n == k)
            return 1;
        if (n < k)
            return 0;
        n--;
        k--;
        return ncr(n, k);
    }

    private static int ncr(int n, int r) {
        long facto[] = new long[n + 1];
        factorial(n, facto);
        System.out.println(n + " --> " + facto[n]);
        System.out.println((n - r) + "  --> " + facto[n - r]);
        System.out.println(r + " --> " + facto[r]);
        long mod = (long) 1e9 + 7;
        return (int) (facto[n] / ((facto[r] * facto[n - r]))%mod);
    }

    private static void factorial(int n, long arr[]) {
        arr[0] = 1;
        arr[1] = 1;
        long mod = (long) 1e9 + 7;
        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] * i) % mod;
            System.out.println(i + " --> " + arr[i]);
            if (arr[i] == 0)
                break;
        }
    }


}