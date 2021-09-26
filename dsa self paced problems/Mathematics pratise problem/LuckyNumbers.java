import AkPackage.*;
import java.util.*;

public class LuckyNumbers {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LuckyNumbers());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            int q = Integer.parseInt(lines.remove(0));

            int Queries[][] = new int[q][2];
            for (int i = 0; i < Queries.length; i++)
                Queries[i] = InputOutput.arrayFromString(lines.remove(0));

            System.out.println("Lucky Numbers: " + luckyNumbers(arr.length, arr, q, Queries));
        }
    }

    public static int[] luckyNumbers(int N, int[] A, int Q, int[][] Queries) {
        int sieve[] = generateSieve(Arrays.stream(A).max().getAsInt());
        int result[] = new int[Queries.length], k = 0;
        for (int query[] : Queries) {
            int xor = 0;
            for (int i = query[0] - 1; i < query[1]; i++)
                if (sieve[A[i]] == A[i])
                    xor ^= A[i];

            result[k++] = xor;
        }
        return result;
    }

    public static int[] generateSieve(int n) {
        int[] spf = new int[n + 1];
        for (Integer i = 0; i <= n; i++) {
            spf[i] = i;
        }
        // separately marking spf for every even number as 2
        for (Integer i = 4; i <= n; i += 2) {
            spf[i] = 2;
        }
        for (Integer i = 3; i * i <= n; i++) {
            if (spf[i] == i) // that means i is a prime number as of now, replace all the multiples of i with
                             // i
            {
                for (Integer j = i * i; j <= n; j += i) {
                    // marking spf[j]=i
                    spf[j] = i;
                }
            }
        }
        return spf;
    }
}