import AkPackage.*;
import java.util.*;

public class NCR {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new NCR());
        while (!lines.isEmpty()) {
            int input[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("\nFor input: " + Arrays.toString(input));
            System.out.println("Ans is: " + nCrModp(input[0], input[1]));
        }
    }
    // -> FERMET'S LITTLE THEOREM
    // -> (a/b)%m ≠ (a%b / b%m) % m
    // -> (a/b)%m = (a%b / b^-1 %m) % m

    // _ that's why we use fermet's little theorem, which says b^-1 % m = b^(m-2) %
    // m

    public static int nCrModp(int n, int r) {
        if (r == 0 || r == n)
            return 1;
        if (r == 1 || n - r == 1)
            return n;
        if (r > n)
            return 0;
        if (!(r == (n / 2) + 1 && n % 2 == 1))
            r = Math.min(r, n - r);
        int mod = (int) Math.pow(10, 9) + 7;
        int nCr[] = new int[r + 1];
        nCr[1] = n;
        for (int i = 2; i <= r; i++) {
            nCr[i] = (nCr[i - 1] * (n - i + 1)) % mod;
            nCr[i] *= getInverse(i, mod);
            nCr[i] %= mod;
        }

        System.out.println(Arrays.toString(nCr));
        return (int) nCr[r] % mod;
    }

    public static int getInverse(int a, int mod) {
        return Mathematics.powMod(a, mod - 2, mod) % mod;
    }

}