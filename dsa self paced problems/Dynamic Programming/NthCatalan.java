import AkPackage.*;

import java.math.BigInteger;
import java.util.*;

//docs: cat[i]=(((2*i)*(2*i-1)*cat[i-1])/(i*(i+1)));

public class NthCatalan {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new NthCatalan());
        while (!lines.isEmpty()) {
            int n = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            System.out.println("For  the given " + n + ": ");
            BigInteger res = findCatalan(n);
            System.out.println("Ans is: " + res);
        }
    }

    public static BigInteger findCatalan(int n) {
        BigInteger cat[] = new BigInteger[n + 1];
        // int cati[] = new int[n + 1];
        cat[0] = new BigInteger("1");
        // cati[0] = 1;

        //=> tabulation
        for (int i = 1; i <= n; i++) {
            cat[i] = cat[i - 1].multiply(BigInteger.valueOf((int) ((2 * i) * (2 * i - 1))));
            cat[i] = cat[i].divide(BigInteger.valueOf(i * (i + 1)));
            // cati[i] = (((2 * i) * (2 * i - 1) * cati[i - 1]) / (i * (i + 1)));

            // System.out.println("cati: "+cati[i]);
        }
        // System.out.println("catn:" + cati[n]);
        return cat[n];
    }
}