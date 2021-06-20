import AkPackage.*;
import java.util.*;

//* THERE'S NO ANY OTHER WAY TO SOLVE THIS.

public class NCR2 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new NCR());
        while (!lines.isEmpty()) {
            int input[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("\nFor input: " + Arrays.toString(input));
            System.out.println("Ans is: " + nCrModp(input[0], input[1]));
        }
    }

    public static int nCrModp(int n, int r) {
        if (r == 0 || r == n)
            return 1;
        if (r == 1 || n - r == 1)
            return n;
        if (r > n)
            return 0;
        int mod = (int) Math.pow(10, 9) + 7;
        if (!(r == (n / 2) + 1 && n % 2 == 1))
            r = Math.min(r, n - r);
        ArrayList<Integer> dp = new ArrayList<Integer>(), dp2 = new ArrayList<Integer>();

        dp.add(0);
        dp.add(1);
        dp.add(0);

        for (int i = 1; i <= n; i++) {
            dp2 = new ArrayList<>();
            dp2.add(0);
            for (int j = 1; j < dp.size(); j++) {
                int res = ((dp.get(j) % mod) + (dp.get(j - 1) % mod)) % mod;
                dp2.add(res);
                if (i == n && j == r+1)
                    break;
            }
            dp2.add(0); // row completed
            // System.out.println(dp2);
            dp = dp2;
        }
        return dp2.get(r+1);
    }
}